package br.com.fiap.javaChallenge.dto.response;

import lombok.Builder;

@Builder
public record ServicoResponse(

        Long id,

        String nome,

        String descricao,

        float preco,

        AnaliseDadosResponse analiseDados
) {
}
