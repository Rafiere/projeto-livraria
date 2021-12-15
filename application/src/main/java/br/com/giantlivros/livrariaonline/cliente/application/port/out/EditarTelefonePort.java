package br.com.giantlivros.livrariaonline.cliente.application.port.out;

public interface EditarTelefonePort {

    void editarTelefoneCliente(Long idCliente, String novoTelefoneFixo, String novoTelefoneCelular);

}
