package br.jus.trf1.secad.seinf.websipe.model;

import br.jus.trf1.secad.seinf.websipe.external.dto.RegistroResponse;

import java.time.format.DateTimeFormatter;

public class RegistroModel {

    public static final RegistroModel NULL_OBJECT = new RegistroModel(null, "--:--", "-----", null);

    private Long id;
    private String hora;
    private String sentido;
    private Integer versao;


    public RegistroModel(Long id, String hora, String sentido, Integer versao) {
        this.id = id;
        this.hora = hora;
        this.sentido = sentido;
        this.versao = versao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getSentido() {
        return sentido;
    }

    public void setSentido(String sentido) {
        this.sentido = sentido;
    }

    public Integer getVersao() {
        return versao;
    }

    public void setVersao(Integer versao) {
        this.versao = versao;
    }

    public static RegistroModel of(RegistroResponse response) {
        var horaStr = response.hora().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        return new RegistroModel(response.id(), horaStr, response.sentido(), response.versao());
    }

}
