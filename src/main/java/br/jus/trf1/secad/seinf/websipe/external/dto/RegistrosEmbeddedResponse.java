package br.jus.trf1.secad.seinf.websipe.external.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RegistrosEmbeddedResponse {

    @JsonProperty("_embedded")
    private Embedded embedded;

    public List<RegistroResponse> getRegistros() {
        return embedded != null ? embedded.registros : List.of();
    }

    public static class Embedded {
        @JsonProperty("registros")
        private List<RegistroResponse> registros;
    }
}