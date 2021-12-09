package br.com.giantlivros.livrariaonline.produto.application.port.in;

import br.com.giantlivros.livrariaonline.core.shared.UseCase;
import br.com.giantlivros.livrariaonline.produto.application.port.out.BuscarTodosOsProdutosLeituraPort;
import br.com.giantlivros.livrariaonline.produto.domain.ProdutoLeitura;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuscarTodosOsProdutosLeituraUseCase extends UseCase<
        BuscarTodosOsProdutosLeituraUseCase.InputValues,
        BuscarTodosOsProdutosLeituraUseCase.OutputValues> {

    private final BuscarTodosOsProdutosLeituraPort buscarTodosOsProdutosLeituraPort;

    @Override
    public OutputValues execute(InputValues input) {

        List<ProdutoLeitura> todosOsProdutosLeitura =
                buscarTodosOsProdutosLeituraPort.buscarTodosProdutosLeitura();

        return OutputValues.of(
                todosOsProdutosLeitura
        );
    }

    @Value
    public static class InputValues implements UseCase.InputValues {

    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        List<ProdutoLeitura> produtosLeituraResultado;

        private static OutputValues of(List<ProdutoLeitura> produtosLeitura){
            return new BuscarTodosOsProdutosLeituraUseCase.OutputValues(
                    produtosLeitura
            );
        }
    }
}
