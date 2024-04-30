package br.com.fiap.javaChallenge.dto.request;


public record DistribuidorRequest(

        String nome,

        String areaCobertura,

        String localizacao,

        String tipo
) {
}
