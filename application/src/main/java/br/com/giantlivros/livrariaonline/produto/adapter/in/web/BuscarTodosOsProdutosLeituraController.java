package br.com.giantlivros.livrariaonline.produto.adapter.in.web;

import br.com.giantlivros.livrariaonline.produto.adapter.in.web.response.BuscarTodosOsProdutosLeituraResponse;
import br.com.giantlivros.livrariaonline.produto.application.port.in.BuscarTodosOsProdutosLeituraUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "Produto")

@RestController
@RequestMapping(path = "/produto")
@RequiredArgsConstructor
public class BuscarTodosOsProdutosLeituraController {

    private final BuscarTodosOsProdutosLeituraUseCase buscarTodosOsProdutosUseCase;

    @ApiOperation(value = "Busca todos os \"ProdutoLeitura\" cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
    })
    @GetMapping(path = "/buscar-todos-produtos")
    public ResponseEntity<List<BuscarTodosOsProdutosLeituraResponse>> executa() {

        BuscarTodosOsProdutosLeituraUseCase.OutputValues output =
                buscarTodosOsProdutosUseCase.execute(new BuscarTodosOsProdutosLeituraUseCase.InputValues());

        return ResponseEntity.ok().body(
                output.getProdutosLeituraResultado()
                        .stream()
                        .map(BuscarTodosOsProdutosLeituraResponse::new)
                        .collect(Collectors.toList()));
    }
}