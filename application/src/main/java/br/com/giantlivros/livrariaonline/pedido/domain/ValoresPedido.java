package br.com.giantlivros.livrariaonline.pedido.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_valorespedido")
public class ValoresPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private BigDecimal valorFrete;

    @NotNull
    private BigDecimal valorSomaProdutos;

    @NotNull
    private BigDecimal valorTotalProdutosComFrete;
}
