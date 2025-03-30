package br.jus.trf1.secad.seinf.websipe.external.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalTime;

@Builder
public record RegistroResponse(Long id,
                               @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
                               LocalTime hora,
                               String sentido,
                               Integer versao) {
}
