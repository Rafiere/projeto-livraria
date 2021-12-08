package br.com.giantlivros.livrariaonline.produto.application.port.in;

import br.com.giantlivros.livrariaonline.core.shared.UseCase;
import br.com.giantlivros.livrariaonline.produto.application.port.out.RemoverProdutoLeituraPort;
import br.com.giantlivros.livrariaonline.produto.domain.*;
import br.com.giantlivros.livrariaonline.produto.domain.enums.Categoria;
import br.com.giantlivros.livrariaonline.produto.domain.enums.Genero;
import br.com.giantlivros.livrariaonline.produto.domain.enums.Idioma;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RemoverProdutoLeituraUseCase extends
        UseCase<RemoverProdutoLeituraUseCase.InputValues,
        RemoverProdutoLeituraUseCase.OutputValues>{

    private final RemoverProdutoLeituraPort removerProdutoLeituraPort;

    @Override
    public OutputValues execute(InputValues input) {
        removerProdutoLeituraPort.remover(input.getIdProdutoLeitura());
        return OutputValues.ofEmpty();
    }

    @Value
    public static class InputValues implements UseCase.InputValues {
        private final Long idProdutoLeitura;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        public static RemoverProdutoLeituraUseCase.OutputValues ofEmpty(){
            return new RemoverProdutoLeituraUseCase.OutputValues();
        }
    }
}
