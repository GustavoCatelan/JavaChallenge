package br.com.fiap.javaChallenge.dto.request.pessoa;

import br.com.fiap.javaChallenge.dto.request.AbstractRequest;

public record DistribuidorRequest(

        String nome,

        String areaCobertura,

        String localizacao,

        String tipo,

        AbstractRequest pessoa
) {
}
