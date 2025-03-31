package br.jus.trf1.secad.seinf.websipe.controllers;

import br.jus.trf1.secad.seinf.websipe.model.RegistroModel;
import br.jus.trf1.secad.seinf.websipe.external.services.PontoService;
import br.jus.trf1.secad.seinf.websipe.external.services.RegistroService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pontos")
public class PontosViewController {

    private final PontoService pontoService;
    private final RegistroService registroService;

    public PontosViewController(PontoService pontoService, RegistroService registroService) {
        this.pontoService = pontoService;
        this.registroService = registroService;
    }

    @GetMapping("/tabela")
    public String tabelaPontosHtml(@RequestParam String matricula,
                                   @RequestParam
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                   LocalDate inicio,
                                   @RequestParam
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                   LocalDate fim,
                                   Model model) {

        var pontos = pontoService.buscaPontos(matricula, inicio, fim);

        var pontosComRegistros = pontos.stream().map(ponto -> {
            var registroModelList = registroService.listaRegistrosPonto(ponto.matricula(), ponto.dia())
                    .stream().map(RegistroModel::of).toList();
            var registroModelListCompleto = completarLista(new ArrayList<>(registroModelList));
            return Map.of(
                    "dia", ponto.dia(),
                    "descricao", ponto.descricao(),
                    "tempoTotal", formataTempoTotal(Duration.ofSeconds(ponto.indice() * ponto.totalSegundos())),
                    "registros", registroModelListCompleto
            );
        }).toList();

        model.addAttribute("pontos", pontosComRegistros);
        return "fragmentos/tabela-pontos"; // HTML renderizado
    }

    @GetMapping
    public String listaPontos() {
        return "pontos/lista";
    }

    private static List<RegistroModel> completarLista(List<RegistroModel> lista) {
        // Verifica se a lista é nula para evitar NullPointerException
        if (lista == null) {
            throw new IllegalArgumentException("A lista não pode ser nula");
        }

        // Calcula quantos elementos faltam para completar 8
        int elementosFaltantes = 8 - lista.size();

        // Adiciona RegistroModel.NULL_OBJECT até completar 8 elementos
        for (int i = 0; i < elementosFaltantes; i++) {
            lista.add(RegistroModel.NULL_OBJECT);
        }
        return lista;
    }

    private static String formataTempoTotal(Duration permanencia) {
        var horas = permanencia.toHours();
        var minutos = permanencia.toMinutes();
        var segundos = permanencia.toSeconds();

        return "%02d:%02d:%02d".formatted(horas,
                horas == 0 ? minutos : minutos % (horas * 60),
                minutos == 0 ? segundos : segundos % (minutos * 60));
    }
}

