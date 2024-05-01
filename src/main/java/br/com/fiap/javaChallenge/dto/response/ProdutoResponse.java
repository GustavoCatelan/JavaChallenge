package br.com.fiap.javaChallenge.dto.response;

import lombok.Builder;

@Builder
public record ProdutoResponse(

        Long id,

        String nome,

        String descricao,

        float preco,

        int quantidade,

        AnaliseDadosResponse analiseDados
) {
}
