package br.com.giantlivros.livrariaonline.cliente.application.port.in;

import br.com.giantlivros.livrariaonline.cliente.application.port.out.EditarEnderecoPort;
import br.com.giantlivros.livrariaonline.core.shared.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class EditarEnderecoUseCase extends UseCase<
        EditarEnderecoUseCase.InputValues,
        EditarEnderecoUseCase.OutputValues> {

    private final EditarEnderecoPort editarEnderecoPort;

    @Override
    @Transactional
    public OutputValues execute(InputValues input) {

        editarEnderecoPort.editarEnderecoPort(input.getIdCliente(),
                input.getEstado(),
                input.getCidade(),
                input.getRua(),
                input.getNumero(),
                input.getComplemento());

        return OutputValues.ofEmpty();
    }

    @Value
    public static class InputValues implements UseCase.InputValues {
        Long idCliente;
        String estado;
        String cidade;
        String rua;
        Integer numero;
        String complemento;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {

        private static OutputValues ofEmpty() {
            return new OutputValues();
        }
    }
}
