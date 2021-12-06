package br.com.giantlivros.livrariaonline.produto.domain;

import br.com.giantlivros.livrariaonline.produto.domain.enums.Categoria;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@NoArgsConstructor
@MappedSuperclass
public abstract class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String titulo;

    @NotNull
    private BigDecimal preco;

    @NotNull
    private LocalDateTime dataDeInsercao;

    @NotNull
    @Embedded
    private Tamanho tamanho;

    @NotNull
    private Integer qtdEstoque;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "produto_id")
    private List<Avaliacao> avaliacoes = new ArrayList<>();;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "produto_id")
    private List<ImagemProduto> imagensProduto = new ArrayList<>();

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Categoria categoria;

    public Produto(String titulo,
                   BigDecimal preco,
                   Tamanho tamanho,
                   Integer qtdEstoque,
                   List<Avaliacao> avaliacoes,
                   List<ImagemProduto> imagensProduto,
                   Categoria categoria) {
        this.titulo = titulo;
        this.preco = preco;
        this.dataDeInsercao = LocalDateTime.now();
        this.tamanho = tamanho;
        this.qtdEstoque = qtdEstoque;
        this.avaliacoes = avaliacoes;
        this.imagensProduto = imagensProduto;
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
