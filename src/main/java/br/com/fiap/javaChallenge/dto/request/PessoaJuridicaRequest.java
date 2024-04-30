package br.com.fiap.javaChallenge.dto.request;


public record PessoaJuridicaRequest(

        String cnpj,

        String nomeEmpresa,

        String nomeFantasia,

        String naturezaJuridica,

        String situacao,

        AbstractRequest usuario
) {
}
