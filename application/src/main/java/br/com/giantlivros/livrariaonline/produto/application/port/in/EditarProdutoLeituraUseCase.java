package br.com.giantlivros.livrariaonline.produto.application.port.in;

import br.com.giantlivros.livrariaonline.core.shared.UseCase;
import br.com.giantlivros.livrariaonline.produto.application.port.out.CadastrarProdutoLeituraPort;
import br.com.giantlivros.livrariaonline.produto.application.port.out.RemoverProdutoLeituraPort;
import br.com.giantlivros.livrariaonline.produto.domain.*;
import br.com.giantlivros.livrariaonline.produto.domain.enums.Categoria;
import br.com.giantlivros.livrariaonline.produto.domain.enums.Genero;
import br.com.giantlivros.livrariaonline.produto.domain.enums.Idioma;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EditarProdutoLeituraUseCase extends
        UseCase<EditarProdutoLeituraUseCase.InputValues,
                EditarProdutoLeituraUseCase.OutputValues> {

    private final RemoverProdutoLeituraPort removerProdutoLeituraPort;
    private final CadastrarProdutoLeituraPort cadastrarProdutoLeituraPort;

    @Override
    public OutputValues execute(InputValues input) {
        removerProdutoLeituraPort.remover(input.getIdProdutoLeitura());

        ProdutoLeitura produtoLeituraNovo = new ProdutoLeitura(
                input.getTitulo(),
                input.getPreco(),
                input.getTamanho(),
                input.getQtdEstoque(),
                input.getAvaliacoes(),
                input.getImagensProduto(),
                input.getCategoria(),
                input.getAutor(),
                input.getEditora(),
                input.getQtdPaginas(),
                input.getIdioma(),
                input.getIndice(),
                input.getGenero()
        );

        cadastrarProdutoLeituraPort.salvar(produtoLeituraNovo);

        return OutputValues.of(
                produtoLeituraNovo
        );
    }

    @Value
    public static class InputValues implements UseCase.InputValues {
        private final Long idProdutoLeitura;
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
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {

        private final Long idProdutoEditado;

        public static EditarProdutoLeituraUseCase.OutputValues of(ProdutoLeitura produtoLeituraNovo){
            return new EditarProdutoLeituraUseCase.OutputValues(
                produtoLeituraNovo.getId()
            );
        }
    }
}
