package br.com.giantlivros.livrariaonline.cliente.adapter.out.persistence;

import br.com.giantlivros.livrariaonline.cliente.domain.Cliente;
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

}
