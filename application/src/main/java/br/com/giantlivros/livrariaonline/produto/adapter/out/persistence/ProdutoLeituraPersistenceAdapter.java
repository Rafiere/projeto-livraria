package br.com.giantlivros.livrariaonline.produto.adapter.out.persistence;

import br.com.giantlivros.livrariaonline.produto.application.port.out.*;
import br.com.giantlivros.livrariaonline.produto.domain.ProdutoLeitura;
import br.com.giantlivros.livrariaonline.produto.domain.enums.Idioma;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProdutoLeituraPersistenceAdapter implements
        CadastrarProdutoLeituraPort,
        RemoverProdutoLeituraPort,
        BuscarProdutoLeituraPorIdPort,
        BuscarTodosOsProdutosLeituraPort,
        BuscarProdutosLeituraPorFiltroOrdenacaoPort {

    private final ProdutoLeituraRepository produtoLeituraRepository;

    public ProdutoLeitura salvar(ProdutoLeitura produtoLeitura){
        return produtoLeituraRepository.save(produtoLeitura);
    }

    public ProdutoLeitura remover(Long idProdutoLeitura){
        produtoLeituraRepository.deleteById(idProdutoLeitura);
        return null;
    }

    @Override
    public ProdutoLeitura buscarProdutoLeituraPorId(Long idProdutoLeitura) {
        return produtoLeituraRepository.findById(idProdutoLeitura).orElseThrow();
    }

    @Override
    public List<ProdutoLeitura> buscarTodosProdutosLeitura() {
        return produtoLeituraRepository.findAll();
    }


    @Override
    public List<ProdutoLeitura> buscarProdutosOrdenadosEFiltrados(BigDecimal precoMax, String idiomaLivro, Sort sortAlfEPreco) {
        if(precoMax.compareTo(BigDecimal.ZERO) == 0 && idiomaLivro.equals("NONE")){
            return produtoLeituraRepository.buscarTodosSemFiltroComOrdenacao(sortAlfEPreco);
        }else if(precoMax.compareTo(BigDecimal.ZERO) == 0 && (!idiomaLivro.equals("NONE"))){
            return produtoLeituraRepository.buscarTodosComFiltroIdiomaEOrdenacao(Idioma.valueOf(Idioma.class, idiomaLivro), sortAlfEPreco);
        }else if(precoMax.compareTo(BigDecimal.ZERO) > 0 && (idiomaLivro.equals("NONE"))){
            return produtoLeituraRepository.buscarTodosComFiltroPrecoMaxEOrdenacao(precoMax, sortAlfEPreco);
        }else{
            return produtoLeituraRepository.buscarTodosComFiltroPrecoMaxEIdiomaEOrdenacao(precoMax, Idioma.valueOf(Idioma.class, idiomaLivro), sortAlfEPreco);
        }
    }
}
