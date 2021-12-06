package br.com.giantlivros.livrariaonline.produto.domain;

import br.com.giantlivros.livrariaonline.cliente.domain.Cliente;
import br.com.giantlivros.livrariaonline.produto.domain.enums.NotaAvaliacao;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_avaliacao")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private NotaAvaliacao notaAvaliacao;

    private String textoAvaliacao;

    private LocalDate dataAvaliacao;
}
