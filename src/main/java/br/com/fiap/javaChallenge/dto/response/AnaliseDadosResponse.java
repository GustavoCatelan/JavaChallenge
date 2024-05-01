package br.com.fiap.javaChallenge.dto.response;

import lombok.Builder;

@Builder
public record AnaliseDadosResponse(

        Long id,

        String avaliacoes,

        String numeroCompra,

        String recomendacoes,

        String tipo,

        String data
) {
}
