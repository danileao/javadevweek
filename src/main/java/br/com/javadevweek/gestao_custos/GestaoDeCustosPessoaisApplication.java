package br.com.javadevweek.gestao_custos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class GestaoDeCustosPessoaisApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoDeCustosPessoaisApplication.class, args);
	}

}
