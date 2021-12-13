package br.com.giantlivros.livrariaonline.produto.adapter.in.web;

import br.com.giantlivros.livrariaonline.produto.adapter.in.web.response.BuscarTodosOsProdutosLeituraResponse;
import br.com.giantlivros.livrariaonline.produto.application.port.in.BuscarProdutosLeituraPorFiltroOrdenacaoUseCase;
import br.com.giantlivros.livrariaonline.produto.domain.enums.Idioma;
import br.com.giantlivros.livrariaonline.produto.util.ConverterOrdemUrlParaObjetoSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Explicação do funcionamento da task PLO-24:
 *
 * 1. Parâmetros recebidos e validados no controller.
 * 2. Parâmetros enviados para o "UseCase" através do "InputValues".
 * 3. Passagem dos parâmetros recebidos na URL para o método declarado na porta.
 * 4. O "PersistenceAdapter" recebe os parâmetros e chama a "@Query" do repository que é correspondente aos parâmetros passados.
 * 5. A "@Query", que foi chamada pelo "PersistenceAdapter", é executada e retorna uma lista de "ProdutoLeitura".
 * 6. Essa lista é armazenada na lista que recebe o retorno do método "execute", do "UseCase".
 * 7. A lista é convertida para um "OutputValues" e retornada para o controller.
 * 8. O controller mapeia os valores recebidos, que estão no "OutputValues", para a response.
 * 9. A response é retornada, através do "ResponseEntity", no formato JSON, para quem realizou essa solicitação no endpoint.
 */

@Api(tags = "Produto")

@RestController
@RequestMapping(path = "/produto")
@RequiredArgsConstructor
public class BuscarProdutosLeituraPorFiltroOrdenacaoController {

    private final BuscarProdutosLeituraPorFiltroOrdenacaoUseCase buscarProdutosLeituraPorFiltroOrdenacaoUseCase;

    @ApiOperation(value = "Busca todos os \"ProdutoLeitura\" através de um filtro especificado.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 400, message = "Algum argumento inválido encontrado")})
    @GetMapping(path = "/buscar-todos-produtos-filtros")
    public ResponseEntity<List<BuscarTodosOsProdutosLeituraResponse>> executa(
            @RequestParam(name = "ordAlf") String ordAlfabetica,
            @RequestParam(name = "ordPreco") String ordPreco,
            @RequestParam(name = "precoMaximo") BigDecimal precoMaximo,
            @RequestParam(name = "idioma") String idioma
    ) {

        if(precoMaximo.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("O preço máximo não pode ser menor que zero.");
        }

        if((Arrays.stream(Idioma.values())
                .map(Idioma::toString)
                .noneMatch(idiomaEnum -> idiomaEnum.equals(idioma))) && (!idioma.equals("NONE"))){
            throw new IllegalArgumentException("Idioma inválido. Envie um idioma pertencente ao enum \"Idioma\".");
        }

        if((!ordAlfabetica.equals("ASC")) && (!ordAlfabetica.equals("DESC")) && (!ordAlfabetica.equals("NONE"))){
            throw new IllegalArgumentException("Tipo de ordenação alfabética inválido. Deve ser \"ASC\", \"DESC\" ou \"NONE\"");
        }

        if((!ordPreco.equals("ASC")) && (!ordPreco.equals("DESC")) && (!ordPreco.equals("NONE"))){
            throw new IllegalArgumentException("Tipo de ordenação de preço inválido. Deve ser \"ASC\", \"DESC\" ou \"NONE\"");
        }

        if(((!ordAlfabetica.equals("NONE")) && (!ordPreco.equals("NONE")))){
            throw new IllegalArgumentException("Apenas uma ordenação deve ser passada.");
        }

        Sort sortAlfEPreco = ConverterOrdemUrlParaObjetoSort.converterSortAlfEPreco(ordAlfabetica, ordPreco);

        BuscarProdutosLeituraPorFiltroOrdenacaoUseCase.OutputValues output =
                buscarProdutosLeituraPorFiltroOrdenacaoUseCase.execute(new
                BuscarProdutosLeituraPorFiltroOrdenacaoUseCase.InputValues(
                    sortAlfEPreco,
                    precoMaximo,
                    idioma
        ));

        return ResponseEntity.ok().body(
            output.getProdutosLeituraResultado()
                .stream()
                .map(BuscarTodosOsProdutosLeituraResponse::new)
                .collect(Collectors.toList())
        );
    }
}