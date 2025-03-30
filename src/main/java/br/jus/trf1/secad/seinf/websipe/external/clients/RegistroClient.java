package br.jus.trf1.secad.seinf.websipe.external.clients;

import br.jus.trf1.secad.seinf.websipe.external.dto.RegistroResponse;
import br.jus.trf1.secad.seinf.websipe.external.dto.RegistrosEmbeddedResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(url = "${sipe.backend.url}", name = "registro")
public interface RegistroClient {


    @GetMapping("/v1/sap/registros/pontos")
    RegistrosEmbeddedResponse listaRegistros(@RequestParam String matricula,
                                             @RequestParam String dia);

    @GetMapping("/v1/sap/pontos/registros/{id}")
    RegistroResponse buscaPorId(@PathVariable Long id);
}
