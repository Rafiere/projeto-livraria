package br.com.giantlivros.livrariaonline.pedido.domain;

import br.com.giantlivros.livrariaonline.cliente.domain.Cliente;
import br.com.giantlivros.livrariaonline.pedido.domain.enums.Transportadora;
import br.com.giantlivros.livrariaonline.produto.domain.ProdutoLeitura;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * ID do pedido que ficará exposto para o cliente.
     */

    @NotNull
    private String idPedidoExterno = UUID.randomUUID().toString();

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Cliente clientes;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pedido_id")
    private List<ProdutoLeitura> produtos = new ArrayList<>();

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private ValoresPedido valoresPedido;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private InformacoesPagamentoPedido informacoesPagamentoPedido;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private DatasPedido datasPedido;

    @NotNull
    private String urlNotaFiscalEletronica;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Transportadora transportadora;

    /**
     * Avisos que poderão ser inseridos pela transportadora em relação a um
     * determinado pedido.
     */

    @NotNull
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pedido_id")
    private List<Aviso> avisos;
}
