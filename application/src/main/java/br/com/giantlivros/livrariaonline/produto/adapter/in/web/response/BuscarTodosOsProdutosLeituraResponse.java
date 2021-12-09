package br.com.giantlivros.livrariaonline.produto.adapter.in.web.response;

import br.com.giantlivros.livrariaonline.produto.application.port.in.BuscarProdutoLeituraPorIdUseCase;
import br.com.giantlivros.livrariaonline.produto.application.port.in.BuscarTodosOsProdutosLeituraUseCase;
import br.com.giantlivros.livrariaonline.produto.domain.*;
import br.com.giantlivros.livrariaonline.produto.domain.enums.Categoria;
import br.com.giantlivros.livrariaonline.produto.domain.enums.Genero;
import br.com.giantlivros.livrariaonline.produto.domain.enums.Idioma;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class BuscarTodosOsProdutosLeituraResponse {

    private final Long id;
    private final String titulo;
    private final BigDecimal preco;
    private final Tamanho tamanho;
    private final Integer qtdEstoque;
    private final List<Avaliacao> avaliacoes;
    private final List<ImagemProduto> imagensProduto;
    private final Categoria categoria;
    private final Autor autor;
    private final Editora editora;
    private final Integer qtdPaginas;
    private final Idioma idioma;
    private final Indice indice;
    private final Genero genero;

    public BuscarTodosOsProdutosLeituraResponse(ProdutoLeitura produtoLeitura){
        this.id = produtoLeitura.getId();
        this.titulo = produtoLeitura.getTitulo();
        this.preco = produtoLeitura.getPreco();
        this.tamanho = produtoLeitura.getTamanho();
        this.qtdEstoque = produtoLeitura.getQtdEstoque();
        this.avaliacoes = produtoLeitura.getAvaliacoes();
        this.imagensProduto = produtoLeitura.getImagensProduto();
        this.categoria = produtoLeitura.getCategoria();
        this.autor = produtoLeitura.getAutor();
        this.editora = produtoLeitura.getEditora();
        this.qtdPaginas = produtoLeitura.getQtdPaginas();
        this.idioma = produtoLeitura.getIdioma();
        this.indice = produtoLeitura.getIndice();
        this.genero = produtoLeitura.getGenero();
    }
}
