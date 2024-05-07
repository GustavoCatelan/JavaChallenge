package br.com.fiap.javaChallenge.dto.request.produto;

import br.com.fiap.javaChallenge.dto.request.AbstractRequest;

public record ProdutoRequest (

        String nome,

        String descricao,

        float preco,

        int quantidade,

        AbstractRequest avaliacao
){
}
