package br.com.giantlivros.livrariaonline.pedido.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_dataspedido")
public class DatasPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDate dataDeRealizacaoPedido = LocalDate.now();

    private LocalDateTime dataEHoraConfirmacaoPagamento;

    @NotNull
    private LocalDate diaDaEntregaPrevisto;

    private LocalDate diaDaEntregaEfetuada;

}
