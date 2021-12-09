package br.com.giantlivros.livrariaonline.produto.adapter.in.web.response;

import br.com.giantlivros.livrariaonline.produto.application.port.in.BuscarProdutoPorIdUseCase;
import br.com.giantlivros.livrariaonline.produto.domain.*;
import br.com.giantlivros.livrariaonline.produto.domain.enums.Categoria;
import br.com.giantlivros.livrariaonline.produto.domain.enums.Genero;
import br.com.giantlivros.livrariaonline.produto.domain.enums.Idioma;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class BuscarProdutoPorIdResponse {

        private final Long id;
        private String titulo;
        private BigDecimal preco;
        private Tamanho tamanho;
        private Integer qtdEstoque;
        private List<Avaliacao> avaliacoes;
        private List<ImagemProduto> imagensProduto;
        private Categoria categoria;
        private Autor autor;
        private Editora editora;
        private Integer qtdPaginas;
        private Idioma idioma;
        private Indice indice;
        private Genero genero;

    public BuscarProdutoPorIdResponse(BuscarProdutoPorIdUseCase.OutputValues output){
        this.id = output.getProdutoLeitura().getId();
        this.titulo = output.getProdutoLeitura().getTitulo();
        this.preco = output.getProdutoLeitura().getPreco();
        this.tamanho = output.getProdutoLeitura().getTamanho();
        this.qtdEstoque = output.getProdutoLeitura().getQtdEstoque();
        this.avaliacoes = output.getProdutoLeitura().getAvaliacoes();
        this.imagensProduto = output.getProdutoLeitura().getImagensProduto();
        this.categoria = output.getProdutoLeitura().getCategoria();
        this.autor = output.getProdutoLeitura().getAutor();
        this.editora = output.getProdutoLeitura().getEditora();
        this.qtdPaginas = output.getProdutoLeitura().getQtdPaginas();
        this.idioma = output.getProdutoLeitura().getIdioma();
        this.indice = output.getProdutoLeitura().getIndice();
        this.genero = output.getProdutoLeitura().getGenero();
    }
}
