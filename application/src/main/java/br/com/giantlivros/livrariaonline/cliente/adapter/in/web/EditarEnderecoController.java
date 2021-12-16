package br.com.giantlivros.livrariaonline.cliente.adapter.in.web;

import br.com.giantlivros.livrariaonline.cliente.application.port.in.EditarEnderecoUseCase;
import br.com.giantlivros.livrariaonline.cliente.domain.Endereco;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Cliente")

@RestController
@RequestMapping(path = "/cliente")
@RequiredArgsConstructor
public class EditarEnderecoController {

    private final EditarEnderecoUseCase editarEnderecoUseCase;

    @ApiOperation(value = "Endpoint que permite a alteração do endereço de um cliente.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 404, message = ""),
            @ApiResponse(code = 400, message = "Algum argumento inválido encontrado")})
    @PutMapping(path = "/alterar-endereco-cliente/{idCliente}")
    public ResponseEntity<Void> executa(@PathVariable(name = "idCliente") Long idCliente,
                                        @RequestBody Endereco endereco) {

        EditarEnderecoUseCase.OutputValues output = editarEnderecoUseCase.execute(new EditarEnderecoUseCase.InputValues(
                idCliente,
                endereco.getEstado(),
                endereco.getCidade(),
                endereco.getRua(),
                endereco.getNumero(),
                endereco.getComplemento()
        ));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}