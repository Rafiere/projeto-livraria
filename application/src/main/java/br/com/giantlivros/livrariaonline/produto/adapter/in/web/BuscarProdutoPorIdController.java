package br.com.giantlivros.livrariaonline.produto.adapter.in.web;

import br.com.giantlivros.livrariaonline.produto.adapter.in.web.response.BuscarProdutoPorIdResponse;
import br.com.giantlivros.livrariaonline.produto.application.port.in.BuscarProdutoPorIdUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Produto")

@RestController
@RequestMapping(path = "/produto")
@RequiredArgsConstructor
public class BuscarProdutoPorIdController {

    private final BuscarProdutoPorIdUseCase buscarProdutoPorIdUseCase;

    @ApiOperation(value = "Busca um \"ProdutoLeitura\" através do ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 404, message = "Produto não encontrado"),
            @ApiResponse(code = 400, message = "Algum argumento inválido encontrado")})
    @GetMapping(path = "/buscar-produto/{idProduto}")
    public ResponseEntity<BuscarProdutoPorIdResponse> executa(@PathVariable(name = "idProduto") Long idProduto) {

        BuscarProdutoPorIdUseCase.OutputValues output = buscarProdutoPorIdUseCase.execute(new BuscarProdutoPorIdUseCase.InputValues(
                idProduto
        ));

        return ResponseEntity.ok().body(
                new BuscarProdutoPorIdResponse(output));
    }
}