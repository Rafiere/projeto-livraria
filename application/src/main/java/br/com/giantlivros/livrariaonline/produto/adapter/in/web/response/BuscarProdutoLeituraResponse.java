package br.com.giantlivros.livrariaonline.produto.adapter.in.web.response;

import br.com.giantlivros.livrariaonline.produto.application.port.in.BuscarProdutoLeituraPorIdUseCase;
import br.com.giantlivros.livrariaonline.produto.domain.*;
import br.com.giantlivros.livrariaonline.produto.domain.enums.Categoria;
import br.com.giantlivros.livrariaonline.produto.domain.enums.Genero;
import br.com.giantlivros.livrariaonline.produto.domain.enums.Idioma;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class BuscarProdutoLeituraResponse {

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

    public BuscarProdutoLeituraResponse(BuscarProdutoLeituraPorIdUseCase.OutputValues output){
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
