package br.com.giantlivros.livrariaonline.cliente.application.port.in;

import br.com.giantlivros.livrariaonline.cliente.application.port.out.EditarTelefonePort;
import br.com.giantlivros.livrariaonline.core.shared.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class EditarTelefoneUseCase extends UseCase<
        EditarTelefoneUseCase.InputValues,
        EditarTelefoneUseCase.OutputValues> {

    private final EditarTelefonePort editarTelefonePort;

    @Override
    @Transactional
    public OutputValues execute(InputValues input) {

        editarTelefonePort.editarTelefoneCliente(
                input.getIdCliente(),
                input.getNovoTelefoneFixo(),
                input.getNovoTelefoneCelular());

        return OutputValues.ofEmpty();
    }

    @Value
    public static class InputValues implements UseCase.InputValues {
        Long idCliente;
        String novoTelefoneFixo;
        String novoTelefoneCelular;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        private static OutputValues ofEmpty() {
            return new OutputValues(
            );
        }
    }
}
