package br.com.giantlivros.livrariaonline.produto.adapter.out.persistence;

import br.com.giantlivros.livrariaonline.produto.application.port.out.BuscarProdutoPorIdPort;
import br.com.giantlivros.livrariaonline.produto.application.port.out.CadastrarProdutoLeituraPort;
import br.com.giantlivros.livrariaonline.produto.application.port.out.RemoverProdutoLeituraPort;
import br.com.giantlivros.livrariaonline.produto.domain.ProdutoLeitura;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProdutoLeituraPersistenceAdapter implements
        CadastrarProdutoLeituraPort,
        RemoverProdutoLeituraPort,
        BuscarProdutoPorIdPort {

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
}
