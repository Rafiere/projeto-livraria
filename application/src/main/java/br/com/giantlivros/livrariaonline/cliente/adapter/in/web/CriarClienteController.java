package br.com.giantlivros.livrariaonline.cliente.adapter.in.web;

import br.com.giantlivros.livrariaonline.cliente.application.port.in.CriarClienteUseCase;
import br.com.giantlivros.livrariaonline.cliente.domain.Cliente;
import br.com.giantlivros.livrariaonline.produto.application.port.in.CadastrarProdutoLeituraUseCase;
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
public class CriarClienteController {

    private final CriarClienteUseCase criarClienteUseCase;

    @ApiOperation(value = "Cria um cliente no banco de dados através das informações fornecidas.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Requisição bem sucedida"),
            @ApiResponse(code = 404, message = ""),
            @ApiResponse(code = 400, message = "Algum argumento inválido encontrado")})
    @PostMapping(path = "/criar-cliente")
    public ResponseEntity<Void> executa(
            @RequestBody CriarClienteUseCase.InputValues input
    ){

        criarClienteUseCase.execute(input);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}