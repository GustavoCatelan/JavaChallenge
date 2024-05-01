package br.com.fiap.javaChallenge.dto.response;

import lombok.Builder;

@Builder
public record PessoaJuridicaResponse(

        Long id,

        String cnpj,

        String nomeEmpresa,

        String nomeFantasia,

        String naturezaJuridica,

        String situacao,

        UsuarioResponse usuario
) {
}
