package br.com.giantlivros.livrariaonline.produto.adapter.in.web;

import br.com.giantlivros.livrariaonline.produto.adapter.in.web.response.ListarTodosIdiomasDisponiveisResponse;
import br.com.giantlivros.livrariaonline.produto.application.port.in.ListarTodosIdiomasDisponiveisUseCase;
import br.com.giantlivros.livrariaonline.produto.domain.enums.Idioma;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@Api(tags = "Produto")

@RestController
@RequestMapping(path = "/produto")
@RequiredArgsConstructor
public class ListarTodosIdiomasDisponiveisController {

    private final ListarTodosIdiomasDisponiveisUseCase listarTodosIdiomasDisponiveisUseCase;

    @ApiOperation(value = "Produto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 404, message = ""),
            @ApiResponse(code = 400, message = "")})
    @GetMapping(path = "/obter-todos-idiomas-disponiveis")
    public ResponseEntity<ListarTodosIdiomasDisponiveisResponse> executa() {

        ListarTodosIdiomasDisponiveisUseCase.OutputValues output = listarTodosIdiomasDisponiveisUseCase.execute(
                new ListarTodosIdiomasDisponiveisUseCase.InputValues()
        );

        return ResponseEntity.ok().body(
                new ListarTodosIdiomasDisponiveisResponse
                        (output.getIdiomasDisponiveis()));
    }
}