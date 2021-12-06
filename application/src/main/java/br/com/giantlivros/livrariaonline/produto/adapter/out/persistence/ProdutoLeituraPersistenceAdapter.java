package br.com.giantlivros.livrariaonline.produto.adapter.out.persistence;

import br.com.giantlivros.livrariaonline.produto.application.port.out.CadastrarProdutoLeituraPort;
import br.com.giantlivros.livrariaonline.produto.domain.ProdutoLeitura;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProdutoLeituraPersistenceAdapter implements
        CadastrarProdutoLeituraPort {

    private final ProdutoLeituraRepository produtoLeituraRepository;

    public ProdutoLeitura salvar(ProdutoLeitura produtoLeitura){
        return produtoLeituraRepository.save(produtoLeitura);
    }
}
