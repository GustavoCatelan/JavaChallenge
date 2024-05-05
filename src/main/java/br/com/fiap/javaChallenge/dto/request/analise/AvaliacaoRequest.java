package br.com.fiap.javaChallenge.dto.request.analise;


import br.com.fiap.javaChallenge.dto.request.AbstractRequest;

import java.time.LocalDate;

public record AvaliacaoRequest(


        String texto,

        LocalDate data,

        AbstractRequest negociavel
) {
}
