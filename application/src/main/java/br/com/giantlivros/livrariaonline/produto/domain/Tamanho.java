package br.com.giantlivros.livrariaonline.produto.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
public class Tamanho {

    private Double largura;
    private Double altura;
    private Double profundidade;
}
