package br.com.giantlivros.livrariaonline.produto.util;

import org.springframework.data.domain.Sort;

public class ConverterOrdemUrlParaObjetoSort {

    public static Sort converterSortAlfEPreco(String ordemAlf, String ordemPreco) {

        if(ordemAlf.equals("NONE") && ordemPreco.equals("NONE")){
            return Sort.unsorted();
        }else if(ordemAlf.equals("NONE")){
            return Sort.by(converterSortPreco(ordemPreco));
        }else {
            return Sort.by(converterSortAlf(ordemAlf));
        }
    }

    private static Sort.Order converterSortAlf(String ordemAlf){
        return ordemAlf.equals("ASC") ? Sort.Order.asc("titulo") : Sort.Order.desc("titulo");
    }

    private static Sort.Order converterSortPreco(String ordemPreco){
        return ordemPreco.equals("ASC") ? Sort.Order.asc("preco") : Sort.Order.desc("preco");
    }
}