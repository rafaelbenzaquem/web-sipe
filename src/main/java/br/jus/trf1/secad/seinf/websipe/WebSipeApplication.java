package br.jus.trf1.secad.seinf.websipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class WebSipeApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSipeApplication.class, args);
    }

}
