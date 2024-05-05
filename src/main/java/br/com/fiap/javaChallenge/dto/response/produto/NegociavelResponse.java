package br.com.fiap.javaChallenge.dto.response.produto;

import lombok.Builder;

@Builder
public record NegociavelResponse(

        Long id,

        String nome,

        String descricao,

        float preco
) {
}
