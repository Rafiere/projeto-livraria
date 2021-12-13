package br.com.giantlivros.livrariaonline.produto.adapter.out.persistence;

import br.com.giantlivros.livrariaonline.produto.domain.ProdutoLeitura;
import br.com.giantlivros.livrariaonline.produto.domain.enums.Idioma;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProdutoLeituraRepository extends JpaRepository<ProdutoLeitura, Long> {

    @Query("SELECT p " +
            "FROM ProdutoLeitura p")
    List<ProdutoLeitura> buscarTodosSemFiltroComOrdenacao(Sort ordenacao);

    @Query("SELECT p " +
           "FROM ProdutoLeitura p " +
           "WHERE p.preco < ?1")
    List<ProdutoLeitura> buscarTodosComFiltroPrecoMaxEOrdenacao(@Param("filtPrecoMax") BigDecimal precoMax,
                                                                Sort ordenacao);

    @Query("SELECT p " +
           "FROM ProdutoLeitura p " +
           "WHERE p.idioma = ?1")
    List<ProdutoLeitura> buscarTodosComFiltroIdiomaEOrdenacao(@Param("filtIdioma") Idioma idiomaLivro,
                                                              Sort ordenacao);

    @Query("SELECT p " +
            "FROM ProdutoLeitura p " +
            "WHERE p.preco < ?1 " +
            "AND p.idioma = ?2")
    List<ProdutoLeitura> buscarTodosComFiltroPrecoMaxEIdiomaEOrdenacao(@Param("filtPrecoMax") BigDecimal precoMax,
                                                                       @Param("filtIdioma") Idioma idiomaLivro,
                                                                       Sort ordenacao);
}
