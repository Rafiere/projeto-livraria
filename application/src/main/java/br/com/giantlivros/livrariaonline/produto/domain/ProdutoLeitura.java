package br.com.giantlivros.livrariaonline.produto.domain;

import br.com.giantlivros.livrariaonline.produto.domain.enums.Categoria;
import br.com.giantlivros.livrariaonline.produto.domain.enums.Genero;
import br.com.giantlivros.livrariaonline.produto.domain.enums.Idioma;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "tb_produtoleitura")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ProdutoLeitura extends Produto {

    @NotNull
    @Embedded
    private Autor autor;

    @NotNull
    @Embedded
    private Editora editora;

    @NotNull
    private Integer qtdPaginas;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Idioma idioma;

    @Embedded
    private Indice indice;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Genero genero;

    public ProdutoLeitura(String titulo,
                          BigDecimal preco,
                          Tamanho tamanho,
                          Integer qtdEstoque,
                          List<Avaliacao> avaliacoes,
                          List<ImagemProduto> imagensProduto,
                          Categoria categoria,
                          Autor autor,
                          Editora editora,
                          Integer qtdPaginas,
                          Idioma idioma,
                          Indice indice,
                          Genero genero) {
        super(titulo, preco, tamanho, qtdEstoque, avaliacoes, imagensProduto, categoria);
        this.autor = autor;
        this.editora = editora;
        this.qtdPaginas = qtdPaginas;
        this.idioma = idioma;
        this.indice = indice;
        this.genero = genero;
    }

}
