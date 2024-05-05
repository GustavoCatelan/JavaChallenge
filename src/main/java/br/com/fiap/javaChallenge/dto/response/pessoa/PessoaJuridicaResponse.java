package br.com.fiap.javaChallenge.dto.response.pessoa;

import lombok.Builder;

@Builder
public record PessoaJuridicaResponse(

        Long id,

        String cnpj,

        String nomeFantasia,

        String naturezaJuridica,

        String situacao
) {
}
