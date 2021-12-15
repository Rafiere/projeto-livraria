package br.com.giantlivros.livrariaonline.cliente.adapter.out.persistence;

import br.com.giantlivros.livrariaonline.cliente.application.port.out.CriarClientePort;
import br.com.giantlivros.livrariaonline.cliente.application.port.out.EditarTelefonePort;
import br.com.giantlivros.livrariaonline.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClientePersistenceAdapter implements
        CriarClientePort,
        EditarTelefonePort {

    private final ClienteRepository clienteRepository;

    @Override
    public void salvarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void editarTelefoneCliente(Long idCliente, String novoTelefoneFixo, String novoTelefoneCelular) {
        clienteRepository.editarTelefoneCliente(idCliente, novoTelefoneFixo, novoTelefoneCelular);
    }
}
