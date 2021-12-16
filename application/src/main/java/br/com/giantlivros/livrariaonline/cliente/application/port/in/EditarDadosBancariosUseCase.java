package br.com.giantlivros.livrariaonline.cliente.application.port.in;

import br.com.giantlivros.livrariaonline.cliente.application.port.out.EditarDadosBancariosPort;
import br.com.giantlivros.livrariaonline.cliente.domain.enums.Banco;
import br.com.giantlivros.livrariaonline.core.shared.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class EditarDadosBancariosUseCase extends UseCase<
        EditarDadosBancariosUseCase.InputValues,
        EditarDadosBancariosUseCase.OutputValues> {

    private final EditarDadosBancariosPort editarDadosBancariosPort;

    @Override
    @Transactional
    public OutputValues execute(InputValues input) {
        editarDadosBancariosPort.editarDadosBancariosCliente(
                input.getIdUsuario(),
                input.getNovoNumeroConta(),
                input.getNovoBanco());

        return OutputValues.ofEmpty();
    }

    @Value
    public static class InputValues implements UseCase.InputValues {

        Long idUsuario;
        String novoNumeroConta;
        Banco novoBanco;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {

        private static OutputValues ofEmpty() {
            return new OutputValues();
        }
    }
}
