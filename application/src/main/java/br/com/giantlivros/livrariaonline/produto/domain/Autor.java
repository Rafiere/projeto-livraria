package br.com.giantlivros.livrariaonline.produto.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
public class Autor {

    private String nomeAutor;

}
