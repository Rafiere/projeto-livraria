package br.com.giantlivros.livrariaonline.produto.application.port.in;

import br.com.giantlivros.livrariaonline.core.shared.UseCase;
import br.com.giantlivros.livrariaonline.produto.application.port.out.BuscarProdutoLeituraPorIdPort;
import br.com.giantlivros.livrariaonline.produto.domain.*;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscarProdutoLeituraPorIdUseCase extends UseCase<
        BuscarProdutoLeituraPorIdUseCase.InputValues,
        BuscarProdutoLeituraPorIdUseCase.OutputValues> {

    private final BuscarProdutoLeituraPorIdPort buscarProdutoPorIdPort;

    @Override
    public OutputValues execute(InputValues input) {
        ProdutoLeitura produtoLeitura = buscarProdutoPorIdPort.buscarProdutoLeituraPorId(input.getIdProdutoLeitura());

        return OutputValues.of(
                produtoLeitura
        );
    }

    @Value
    public static class InputValues implements UseCase.InputValues {
        private final Long idProdutoLeitura;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {

        private final ProdutoLeitura produtoLeitura;

        public static BuscarProdutoLeituraPorIdUseCase.OutputValues of(ProdutoLeitura produtoLeitura){
            return new BuscarProdutoLeituraPorIdUseCase.OutputValues(
                    produtoLeitura
            );
        }
    }
}
