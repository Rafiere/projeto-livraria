package br.com.giantlivros.livrariaonline.cliente.adapter.in.web;

import br.com.giantlivros.livrariaonline.cliente.application.port.in.EditarDadosBancariosUseCase;
import br.com.giantlivros.livrariaonline.cliente.domain.DadosBancarios;
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
public class EditarDadosBancariosController {

    private final EditarDadosBancariosUseCase editarDadosBancariosUseCase;

    @ApiOperation(value = "Endpoint que permite a alteração dos dados bancários de um usuário.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 404, message = "Usuário não encontrado."),
            @ApiResponse(code = 400, message = "Algum argumento inválido encontrado")})
    @PutMapping(path = "/alterar-dados-bancarios-cliente/{idCliente}")
    public ResponseEntity<Void> executa(@PathVariable(name = "idCliente") Long idCliente,
                                        @RequestBody DadosBancarios novoDadosBancarios) {

        editarDadosBancariosUseCase.execute(new EditarDadosBancariosUseCase.InputValues(
                idCliente,
                novoDadosBancarios.getNumeroConta(),
                novoDadosBancarios.getBanco()
        ));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}