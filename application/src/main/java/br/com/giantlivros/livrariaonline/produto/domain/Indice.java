package br.com.giantlivros.livrariaonline.produto.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
public class Indice {

    private String isbn10;
    private String isbn13;
}
