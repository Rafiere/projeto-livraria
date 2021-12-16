package br.com.giantlivros.livrariaonline.cliente.application.port.out;

public interface EditarEnderecoPort {

    void editarEnderecoPort(Long idCliente, String estado, String cidade, String rua, Integer numero, String complemento);

}
