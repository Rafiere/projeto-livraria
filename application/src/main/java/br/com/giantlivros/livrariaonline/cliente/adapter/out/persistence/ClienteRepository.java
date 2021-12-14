package br.com.giantlivros.livrariaonline.cliente.adapter.out.persistence;

import br.com.giantlivros.livrariaonline.cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
