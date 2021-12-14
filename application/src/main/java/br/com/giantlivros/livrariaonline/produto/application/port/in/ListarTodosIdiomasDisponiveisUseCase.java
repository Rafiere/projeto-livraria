package br.com.giantlivros.livrariaonline.produto.application.port.in;

import br.com.giantlivros.livrariaonline.core.shared.UseCase;
import br.com.giantlivros.livrariaonline.produto.application.port.out.ListarTodosIdiomasDisponiveisPort;
import br.com.giantlivros.livrariaonline.produto.domain.enums.Idioma;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Estou utilizando um "LinkedList<>" pois o "Arrays.asList()" retorna uma lista imutável, ou seja, que
 * não permite a realização de remoções, e como eu preciso remover o elemento "NONE" pois ele não é
 * um idioma de fato, precisei utilizar uma "LinkedList".
 */

@Service
@RequiredArgsConstructor
public class ListarTodosIdiomasDisponiveisUseCase extends UseCase<
        ListarTodosIdiomasDisponiveisUseCase.InputValues,
        ListarTodosIdiomasDisponiveisUseCase.OutputValues> {

    @Override
    public OutputValues execute(InputValues input) {
        List<Idioma> idiomas = new LinkedList<>(Arrays.asList(Idioma.class.getEnumConstants()));
        idiomas.remove(Idioma.NONE);

        return OutputValues.of(idiomas);
    }

    @Value
    public static class InputValues implements UseCase.InputValues {

    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        List<Idioma> idiomasDisponiveis;

        private static OutputValues of(List<Idioma> idiomas) {
            return new OutputValues(
                    idiomas
            );
        }
    }
}
