package br.com.giantlivros.livrariaonline.produto.application.port.out;

import br.com.giantlivros.livrariaonline.produto.domain.ProdutoLeitura;

import java.util.List;

public interface BuscarTodosOsProdutosLeituraPort {

    List<ProdutoLeitura> buscarTodosProdutosLeitura();

}
