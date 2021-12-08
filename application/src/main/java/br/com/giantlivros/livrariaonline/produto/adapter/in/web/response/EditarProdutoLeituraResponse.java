package br.com.giantlivros.livrariaonline.produto.adapter.in.web.response;

import br.com.giantlivros.livrariaonline.produto.application.port.in.EditarProdutoLeituraUseCase;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class EditarProdutoLeituraResponse {

    private final Long novoIdProdutoLeituraEditado;

    public EditarProdutoLeituraResponse(EditarProdutoLeituraUseCase.OutputValues output){
        this.novoIdProdutoLeituraEditado = output.getIdProdutoEditado();
    }
}
