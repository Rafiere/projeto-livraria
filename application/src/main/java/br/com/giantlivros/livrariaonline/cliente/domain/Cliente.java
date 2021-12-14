package br.com.giantlivros.livrariaonline.cliente.domain;

import br.com.giantlivros.livrariaonline.pedido.domain.Pedido;
import br.com.giantlivros.livrariaonline.produto.domain.Avaliacao;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private DadosPessoais dadosPessoais;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private DadosBancarios dadosBancarios;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Endereco endereco;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Telefone telefone;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cliente_id")
    private List<Pedido> pedidos = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cliente_id")
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public Cliente(DadosPessoais dadosPessoais,
                   DadosBancarios dadosBancarios,
                   Endereco endereco,
                   Telefone telefone,
                   List<Pedido> pedidos,
                   List<Avaliacao> avaliacoes) {

        this.dadosPessoais = dadosPessoais;
        this.dadosBancarios = dadosBancarios;
        this.endereco = endereco;
        this.telefone = telefone;
        this.pedidos = pedidos;
        this.avaliacoes = avaliacoes;
    }
}
