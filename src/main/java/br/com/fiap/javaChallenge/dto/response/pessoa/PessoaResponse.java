package br.com.fiap.javaChallenge.dto.response.pessoa;

import lombok.Builder;

@Builder
public record PessoaResponse(

        Long id,

        String nome
) {
}
