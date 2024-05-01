package br.com.fiap.javaChallenge.dto.response;

import lombok.Builder;

@Builder
public record EnderecoResponse(

        Long id,

        String cep,

        String logradouro,

        String numero,

        String complemento,

        String bairro,

        String cidade,

        String estado,

        UsuarioResponse usuario,

        DistribuidorResponse distribuidor
) {
}
