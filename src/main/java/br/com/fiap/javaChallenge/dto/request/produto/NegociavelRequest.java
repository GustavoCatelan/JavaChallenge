package br.com.fiap.javaChallenge.dto.request.produto;

public record NegociavelRequest(

        String nome,

        String descricao,

        float preco
) {
}
