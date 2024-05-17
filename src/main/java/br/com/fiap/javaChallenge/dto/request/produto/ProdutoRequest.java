package br.com.fiap.javaChallenge.dto.request.produto;

import br.com.fiap.javaChallenge.dto.request.AbstractRequest;

public record ProdutoRequest (

        Integer quantidade,

        AbstractRequest avaliacao
){
}
