package br.com.giantlivros.livrariaonline.cliente.adapter.out.persistence;

import br.com.giantlivros.livrariaonline.cliente.domain.Cliente;
import br.com.giantlivros.livrariaonline.cliente.domain.enums.Banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Modifying
    @Query(
            "UPDATE Telefone t " +
            "SET t.telefoneFixo = ?2, t.telefoneCelular = ?3 " +
            "WHERE t.id IN (SELECT c FROM Cliente c WHERE c.telefone.id = ?1)"
    )
    void editarTelefoneCliente(@Param(value = "idCliente") Long idCliente,
                               @Param(value = "novoTelefoneFixo") String novoTelefoneFixo,
                               @Param(value = "novoTelefoneCelular") String novoTelefoneCelular);

    @Modifying
    @Query(
           "UPDATE Endereco e " +
           "SET e.estado = ?2, e.cidade = ?3, e.rua = ?4, e.numero = ?5, e.complemento = ?6 " +
           "WHERE e.id IN (SELECT c FROM Cliente c WHERE c.endereco.id = ?1)"
    )
    void editarEnderecoCliente(@Param(value = "idCliente") Long idCliente,
                               @Param(value = "novoEstado") String estado,
                               @Param(value = "novaCidade") String cidade,
                               @Param(value = "novaRua") String rua,
                               @Param(value = "novoNumero") Integer numero,
                               @Param(value = "novoComplemento") String complemento);

    @Modifying
    @Query(
            "UPDATE DadosBancarios d " +
            "SET d.numeroConta = ?2, d.banco = ?3 " +
            "WHERE d.id IN (SELECT c FROM Cliente c WHERE c.dadosBancarios.id = ?1)"
    )
    void editarDadosBancariosCliente(Long idCliente, String novoNumeroConta, Banco novoBanco);
}
