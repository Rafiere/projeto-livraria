package br.com.giantlivros.livrariaonline.cliente.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String estado;

    @NotNull
    private String cidade;

    @NotNull
    private String rua;

    @NotNull
    private Integer numero;

    @NotNull
    private String complemento;
}
