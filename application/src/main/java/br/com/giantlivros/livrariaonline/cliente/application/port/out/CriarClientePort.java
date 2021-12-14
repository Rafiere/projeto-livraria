package br.com.giantlivros.livrariaonline.cliente.application.port.out;

import br.com.giantlivros.livrariaonline.cliente.domain.Cliente;

public interface CriarClientePort {
    void salvarCliente(Cliente cliente);
}