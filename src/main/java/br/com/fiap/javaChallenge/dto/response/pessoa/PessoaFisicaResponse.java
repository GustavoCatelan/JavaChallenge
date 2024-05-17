package br.com.fiap.javaChallenge.dto.response.pessoa;

import lombok.Builder;

@Builder
public record PessoaFisicaResponse(

        Long id,

        String cpf,

        String rg
) {
}
