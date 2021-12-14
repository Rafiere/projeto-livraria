package br.com.giantlivros.livrariaonline.cliente.application.port.in;

import br.com.giantlivros.livrariaonline.cliente.application.port.out.CriarClientePort;
import br.com.giantlivros.livrariaonline.cliente.domain.*;
import br.com.giantlivros.livrariaonline.core.shared.UseCase;
import br.com.giantlivros.livrariaonline.pedido.domain.Pedido;
import br.com.giantlivros.livrariaonline.produto.domain.Avaliacao;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CriarClienteUseCase extends UseCase<
        CriarClienteUseCase.InputValues,
        CriarClienteUseCase.OutputValues> {

    private final CriarClientePort criarClientePort;

    @Override
    public OutputValues execute(InputValues input) {

        Cliente cliente = new Cliente(
                input.getDadosPessoais(),
                input.getDadosBancarios(),
                input.getEndereco(),
                input.getTelefone(),
                input.getPedidos(),
                input.getAvaliacoes()
        );

        criarClientePort.salvarCliente(cliente);
        return OutputValues.ofEmpty();
    }

    @Value
    public static class InputValues implements UseCase.InputValues {
        DadosPessoais dadosPessoais;
        DadosBancarios dadosBancarios;
        Endereco endereco;
        Telefone telefone;
        List<Pedido> pedidos;
        List<Avaliacao> avaliacoes;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {

        private static OutputValues ofEmpty() {
            return new OutputValues();
        }
    }
}
