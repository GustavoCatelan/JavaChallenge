package br.com.fiap.javaChallenge.dto.response.anlise;

import br.com.fiap.javaChallenge.dto.response.produto.NegociavelResponse;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record AvaliacaoResponse (

        Long id,

        String texto,

        LocalDate data,

        NegociavelResponse negociavel
){
}
