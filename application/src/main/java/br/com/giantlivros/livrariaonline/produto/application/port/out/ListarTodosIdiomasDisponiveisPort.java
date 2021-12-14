package br.com.giantlivros.livrariaonline.produto.application.port.out;

import br.com.giantlivros.livrariaonline.produto.domain.enums.Idioma;

import java.util.List;

public interface ListarTodosIdiomasDisponiveisPort {
    List<Idioma> listarTodosIdiomasDisponiveis();
}