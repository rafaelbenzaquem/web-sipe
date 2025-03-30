package br.jus.trf1.secad.seinf.websipe.external.services;

import br.jus.trf1.secad.seinf.websipe.external.clients.RegistroClient;
import br.jus.trf1.secad.seinf.websipe.external.dto.RegistroResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class RegistroService {

    private final RegistroClient registroClient;

    public RegistroService(RegistroClient registroClient) {
        this.registroClient = registroClient;
    }

    public List<RegistroResponse> listaRegistrosPonto(String matricula, LocalDate dia) {
        String diaStr = dia.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
        var embedded = registroClient.listaRegistros(matricula, diaStr);
        return embedded.getRegistros();
    }

    public RegistroResponse buscaRegistroPorId(Long id) {
        return registroClient.buscaPorId(id);
    }
}
