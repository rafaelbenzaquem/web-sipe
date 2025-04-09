package br.jus.trf1.secad.seinf.websipe.external.services;

import br.jus.trf1.secad.seinf.websipe.external.clients.PontoClient;
import br.jus.trf1.secad.seinf.websipe.external.dto.PontoResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PontoService {
    private final PontoClient pontoClient;

    public PontoService(PontoClient pontoClient) {
        this.pontoClient = pontoClient;
    }

    public PontoResponse buscaPonto(String matricula, LocalDate dia) {
        String diaStr = dia.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
        return pontoClient.buscaPonto(matricula, diaStr);
    }

    public List<PontoResponse> buscaPontos(String matricula, LocalDate inicio, LocalDate fim) {
        String inicioStr = inicio.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
        String fimStr = fim.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
        return pontoClient.buscaPontos(matricula, inicioStr, fimStr).getPontos();
    }

    public List<PontoResponse> atualizaPontos(String matricula, LocalDate inicio, LocalDate fim) {
        String inicioStr = inicio.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
        String fimStr = fim.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
        return pontoClient.atualizaPontos(matricula, inicioStr, fimStr).getPontos();
    }
}
