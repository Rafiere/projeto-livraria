package br.com.giantlivros.livrariaonline.produto.adapter.in.web;

import br.com.giantlivros.livrariaonline.produto.application.port.in.CadastrarProdutoLeituraUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Produto")
@RestController
@RequestMapping(path = "/produto")
@RequiredArgsConstructor
public class CadastrarProdutoLeituraController {

    private final CadastrarProdutoLeituraUseCase cadastrarProdutoLeituraUseCase;

    @ApiOperation(value = "Cadastrar um produto.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Produto cadastrado."),
            @ApiResponse(code = 400, message = "Argumento inválido. Verifique o JSON enviado.")
    })
    @PostMapping(path = "/cadastrar-produto")
    public ResponseEntity<Void> cadastrarProduto(
            @RequestBody CadastrarProdutoLeituraUseCase.InputValues input){

        CadastrarProdutoLeituraUseCase.OutputValues outputValues =
                cadastrarProdutoLeituraUseCase.execute(input);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
