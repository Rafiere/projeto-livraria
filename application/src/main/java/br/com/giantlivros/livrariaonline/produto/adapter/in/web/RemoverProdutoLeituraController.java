package br.com.giantlivros.livrariaonline.produto.adapter.in.web;

import br.com.giantlivros.livrariaonline.produto.application.port.in.CadastrarProdutoLeituraUseCase;
import br.com.giantlivros.livrariaonline.produto.application.port.in.RemoverProdutoLeituraUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Produto")
@RestController
@RequestMapping(path = "/produto")
@RequiredArgsConstructor
public class RemoverProdutoLeituraController {

    private final RemoverProdutoLeituraUseCase removerProdutoLeituraUseCase;

    @ApiOperation(value = "Remover um produto.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Produto removido."),
            @ApiResponse(code = 400, message = "Argumento inválido. Verifique o parâmetro enviado.")
    })
    @DeleteMapping(path = "/remover-produto/{idProdutoLeitura}")
    public ResponseEntity<Void> cadastrarProduto(
            @PathVariable(name = "idProdutoLeitura") Long idProdutoLeitura){

        removerProdutoLeituraUseCase.execute(new RemoverProdutoLeituraUseCase.InputValues(
                idProdutoLeitura));

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
