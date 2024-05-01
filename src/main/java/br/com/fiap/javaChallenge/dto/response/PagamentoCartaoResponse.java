package br.com.fiap.javaChallenge.dto.response;

import lombok.Builder;

@Builder
public record PagamentoCartaoResponse(

        Long id,

        String tipo,

        String bandeira,

        String validade,

        String numero,

        String cvv,

        PagamentoResponse pagamento
) {
}
