package br.com.fiap.javaChallenge.dto.response;

import lombok.Builder;

@Builder
public record UsuarioResponse(

        Long id,

        String nome,

        String email,

        String assinatura
) {
}
