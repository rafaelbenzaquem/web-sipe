package br.jus.trf1.secad.seinf.websipe.external.clients;

import br.jus.trf1.secad.seinf.websipe.external.dto.PontoResponse;
import br.jus.trf1.secad.seinf.websipe.external.dto.PontosEmbeddedResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(url = "${sipe.backend.url}", name = "ponto")
public interface PontoClient {


    @GetMapping("/v1/sap/pontos/{matricula}/{dia}")
    PontoResponse buscaPonto(@PathVariable String matricula,
                              @PathVariable String dia);

    @GetMapping("/v1/sap/pontos")
    PontosEmbeddedResponse buscaPontos(@RequestParam String matricula,
                                        @RequestParam String inicio,
                                        @RequestParam String fim);


    @PostMapping("/v1/sap/pontos/usuarios")
    PontosEmbeddedResponse atualizaPontos(@RequestParam String matricula,
                                          @RequestParam String inicio,
                                          @RequestParam String fim);

}
