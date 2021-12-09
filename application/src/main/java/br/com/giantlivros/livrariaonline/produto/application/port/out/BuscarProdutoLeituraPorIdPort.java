package br.com.giantlivros.livrariaonline.produto.application.port.out;

import br.com.giantlivros.livrariaonline.produto.domain.ProdutoLeitura;

public interface BuscarProdutoLeituraPorIdPort {

    ProdutoLeitura buscarProdutoLeituraPorId(Long idProdutoLeitura);
}
