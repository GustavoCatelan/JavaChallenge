package br.com.fiap.javaChallenge.dto.request;

public record UsuarioRequest(

        String nome,

        String email,

        String assinatura
) {
}
