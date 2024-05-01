package br.com.fiap.javaChallenge.dto.response;

import lombok.Builder;

import java.util.Collection;

@Builder
public record DistribuidorResponse(

        Long id,

        String nome,

        String areaCobertura,

        String localizacao,

        String tipo,

        Collection<ProdutoResponse> produto,

        Collection<ServicoResponse> servico
) {
}
