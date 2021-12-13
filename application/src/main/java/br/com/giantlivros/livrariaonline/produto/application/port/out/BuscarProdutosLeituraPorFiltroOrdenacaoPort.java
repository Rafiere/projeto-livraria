package br.com.giantlivros.livrariaonline.produto.application.port.out;

import br.com.giantlivros.livrariaonline.produto.domain.ProdutoLeitura;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.List;

public interface BuscarProdutosLeituraPorFiltroOrdenacaoPort {

    List<ProdutoLeitura> buscarProdutosOrdenadosEFiltrados(BigDecimal precoMax, String idiomaLivro, Sort sortAlfEPreco);
}
