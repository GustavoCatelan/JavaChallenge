package br.com.fiap.javaChallenge.dto.response;

import lombok.Builder;

@Builder
public record CompraResponse(

        Long id,

        float valorTotal,

        String status,

        UsuarioResponse usuario,

        PagamentoResponse pagamento
) {
}
