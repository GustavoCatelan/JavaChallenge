package br.com.fiap.javaChallenge.dto.request;


public record ProdutoRequest(

        String nome,

        String descricao,

        float preco,

        int quantidade,

        AbstractRequest analiseDados
) {
}
