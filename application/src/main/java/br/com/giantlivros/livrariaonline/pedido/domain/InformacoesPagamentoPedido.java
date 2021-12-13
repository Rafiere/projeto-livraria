package br.com.giantlivros.livrariaonline.pedido.domain;

import br.com.giantlivros.livrariaonline.pedido.domain.enums.MetodoPagamento;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_informacoespagamentopedido")
public class InformacoesPagamentoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private MetodoPagamento metodoPagamentoEscolhido;

    @NotNull
    private boolean isPagamentoConfirmado;
}
