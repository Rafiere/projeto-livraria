package br.com.giantlivros.livrariaonline.produto.adapter.in.web;

import br.com.giantlivros.livrariaonline.produto.adapter.in.web.response.EditarProdutoLeituraResponse;
import br.com.giantlivros.livrariaonline.produto.application.port.in.EditarProdutoLeituraUseCase;
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
public class EditarProdutoLeituraController {

    private final EditarProdutoLeituraUseCase editarProdutoLeituraUseCase;

    @ApiOperation(value = "Editar um produto.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Produto atualizado."),
            @ApiResponse(code = 400, message = "Argumento inválido. Verifique o parâmetro enviado e o corpo da requisição enviados.")
    })
    @PutMapping(path = "/editar-produto/{idProdutoLeitura}")
    public ResponseEntity<EditarProdutoLeituraResponse> editarProduto(
            @PathVariable(name = "idProdutoLeitura") Long idProdutoLeitura,
            @RequestBody EditarProdutoLeituraUseCase.InputValues input){

        EditarProdutoLeituraUseCase.OutputValues output = editarProdutoLeituraUseCase.execute(
                new EditarProdutoLeituraUseCase.InputValues(
                    idProdutoLeitura,
                    input.getTitulo(),
                    input.getPreco(),
                    input.getTamanho(),
                    input.getQtdEstoque(),
                    input.getAvaliacoes(),
                    input.getImagensProduto(),
                    input.getCategoria(),
                    input.getAutor(),
                    input.getEditora(),
                    input.getQtdPaginas(),
                    input.getIdioma(),
                    input.getIndice(),
                    input.getGenero()));


        return ResponseEntity.status(HttpStatus.CREATED).body(
            new EditarProdutoLeituraResponse(output));
    }
}
