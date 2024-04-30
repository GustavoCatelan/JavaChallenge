package br.com.fiap.javaChallenge.dto.request;


public record EnderecoRequest(

        String cep,

        String logradouro,

        String numero,

        String complemento,

        String bairro,

        String cidade,

        String estado,

        AbstractRequest usuario,

        AbstractRequest distribuidor
) {
}
