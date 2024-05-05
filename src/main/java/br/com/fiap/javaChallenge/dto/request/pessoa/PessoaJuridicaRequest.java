package br.com.fiap.javaChallenge.dto.request.pessoa;

public record PessoaJuridicaRequest(


        String cnpj,

        String nomeFantasia,

        String naturezaJuridica,

        String situacao
){
}
