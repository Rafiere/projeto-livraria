package br.com.giantlivros.livrariaonline.cliente.adapter.in.web;

import br.com.giantlivros.livrariaonline.cliente.application.port.in.EditarTelefoneUseCase;
import br.com.giantlivros.livrariaonline.cliente.domain.Telefone;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Cliente")

@RestController
@RequestMapping(path = "/cliente")
@RequiredArgsConstructor
public class EditarTelefoneController {

    private final EditarTelefoneUseCase editarEnderecoUseCase;

    @ApiOperation(value = "Endpoint para permitir a alteração do telefone de um cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 404, message = ""),
            @ApiResponse(code = 400, message = "Algum argumento inválido encontrado")})
    @PutMapping(path = "/alterar-telefone/{idCliente}")
    public ResponseEntity<Void> executa(
            @PathVariable(name = "idCliente") Long idCliente,
            @RequestBody Telefone telefone
    ) {

        editarEnderecoUseCase.execute(new EditarTelefoneUseCase.InputValues(
                idCliente,
                telefone.getTelefoneFixo(),
                telefone.getTelefoneCelular()
        ));

        return ResponseEntity.ok().build();
    }
}