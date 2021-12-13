package br.com.giantlivros.livrariaonline.produto.application.port.in;

import br.com.giantlivros.livrariaonline.core.shared.UseCase;
import br.com.giantlivros.livrariaonline.produto.application.port.out.BuscarProdutosLeituraPorFiltroOrdenacaoPort;
import br.com.giantlivros.livrariaonline.produto.domain.ProdutoLeitura;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BuscarProdutosLeituraPorFiltroOrdenacaoUseCase extends UseCase<
        BuscarProdutosLeituraPorFiltroOrdenacaoUseCase.InputValues,
        BuscarProdutosLeituraPorFiltroOrdenacaoUseCase.OutputValues> {

    private final BuscarProdutosLeituraPorFiltroOrdenacaoPort buscarProdutosLeituraPorFiltroOrdenacaoPort;

    @Override
    public OutputValues execute(InputValues input) {

        List<ProdutoLeitura> produtosLeituraFiltradosOrdenados =
                buscarProdutosLeituraPorFiltroOrdenacaoPort.buscarProdutosOrdenadosEFiltrados(input.getPrecoMaximo(), input.getIdioma(), input.getSortAlfEPreco());

        return OutputValues.of(
            produtosLeituraFiltradosOrdenados
        );
    }

    @Value
    public static class InputValues implements UseCase.InputValues {
        Sort sortAlfEPreco;
        BigDecimal precoMaximo;
        String idioma;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        List<ProdutoLeitura> produtosLeituraResultado;

        private static OutputValues of(List<ProdutoLeitura> produtosLeitura){
            return new OutputValues(
                    produtosLeitura
            );
        }
    }
}
