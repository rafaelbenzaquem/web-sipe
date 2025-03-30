package br.jus.trf1.secad.seinf.websipe.external.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record PontoResponse(String matricula,
                            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                            LocalDate dia,
                            String descricao,
                            Integer indice,
                            @JsonProperty("total_segundos")
                            Long totalSegundos) {

}
