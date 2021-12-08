package br.com.giantlivros.livrariaonline.cliente.domain;

import br.com.giantlivros.livrariaonline.cliente.domain.enums.StatusConta;
import br.com.giantlivros.livrariaonline.cliente.domain.enums.TipoConta;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_dadospessoais")
public class DadosPessoais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String sobrenome;

    @NotNull
    private LocalDate dataNascimento;

    @NotNull
    private String cpf;

    @NotNull
    private String email;

    @NotNull
    private String senha;

    @NotNull
    private String urlAvatar;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusConta statusConta;
}
