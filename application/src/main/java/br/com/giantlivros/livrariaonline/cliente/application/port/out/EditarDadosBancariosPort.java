package br.com.giantlivros.livrariaonline.cliente.application.port.out;

import br.com.giantlivros.livrariaonline.cliente.domain.enums.Banco;

public interface EditarDadosBancariosPort {

    void editarDadosBancariosCliente(Long idCliente, String novoNumeroConta, Banco novoBanco);

}
