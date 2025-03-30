package br.jus.trf1.secad.seinf.websipe.external.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PontosEmbeddedResponse {

    @JsonProperty("_embedded")
    private Embedded embedded;

    public List<PontoResponse> getPontos() {
        return embedded != null ? embedded.pontos : List.of();
    }

    public static class Embedded {
        @JsonProperty("pontoResponseList")
        private List<PontoResponse> pontos;
    }
}