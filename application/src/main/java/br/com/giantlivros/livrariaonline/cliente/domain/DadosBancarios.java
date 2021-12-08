package br.com.giantlivros.livrariaonline.cliente.domain;

import br.com.giantlivros.livrariaonline.cliente.domain.enums.Banco;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_dadosbancarios")
public class DadosBancarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String numeroConta;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Banco banco;
}
