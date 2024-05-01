package br.com.fiap.javaChallenge.dto.response;

import lombok.Builder;

@Builder
public record TelefoneResponse(

        Long id,

        String ddi,

        String ddd,

        String numero,

        DistribuidorResponse distribuidor,

        UsuarioResponse usuario
) {
}
