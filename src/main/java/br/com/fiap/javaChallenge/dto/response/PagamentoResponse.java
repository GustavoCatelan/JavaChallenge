package br.com.fiap.javaChallenge.dto.response;

import lombok.Builder;

@Builder
public record PagamentoResponse(

        Long id,

        String metodo,

        String status
) {
}
