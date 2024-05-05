package br.com.fiap.javaChallenge.dto.response.pessoa;

import lombok.Builder;

@Builder
public record UsuarioResponse(

        Long id,

        String userName,

        String password,

        PessoaResponse pessoa
) {
}
