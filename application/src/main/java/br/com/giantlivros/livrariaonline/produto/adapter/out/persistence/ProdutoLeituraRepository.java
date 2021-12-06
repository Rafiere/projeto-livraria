package br.com.giantlivros.livrariaonline.produto.adapter.out.persistence;

import br.com.giantlivros.livrariaonline.produto.domain.ProdutoLeitura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoLeituraRepository extends JpaRepository<ProdutoLeitura, Long> {
}
