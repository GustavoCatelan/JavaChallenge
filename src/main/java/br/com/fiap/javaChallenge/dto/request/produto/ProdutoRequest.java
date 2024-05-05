package br.com.fiap.javaChallenge.dto.request.produto;

import br.com.fiap.javaChallenge.dto.request.AbstractRequest;

public record ProdutoRequest (


        int quantidade,

        AbstractRequest avaliacao
){
}
