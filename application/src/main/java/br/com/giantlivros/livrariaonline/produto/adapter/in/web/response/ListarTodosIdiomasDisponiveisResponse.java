package br.com.giantlivros.livrariaonline.produto.adapter.in.web.response;

import br.com.giantlivros.livrariaonline.produto.domain.enums.Idioma;
import lombok.Getter;

import java.util.List;

@Getter
public class ListarTodosIdiomasDisponiveisResponse {

    private List<Idioma> idiomas;

    public ListarTodosIdiomasDisponiveisResponse(List<Idioma> idiomas){
        this.idiomas = idiomas;
    }
}
