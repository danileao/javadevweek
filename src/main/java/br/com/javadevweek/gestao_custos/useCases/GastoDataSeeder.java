package br.com.javadevweek.gestao_custos.useCases;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.javadevweek.gestao_custos.entity.Despesa;
import br.com.javadevweek.gestao_custos.repository.DespesaRepository;

@Component
public class GastoDataSeeder implements CommandLineRunner {

    @Autowired
    private DespesaRepository repository;

    @Override
    public void run(String... args) {
        System.out.println("Passou aqui");
        if (repository.count() > 0) {
            List<Despesa> lista = new ArrayList<>();

            for (int i = 0; i < 5000; i++) {
                Despesa gasto = new Despesa();
                // gasto.setId(UUID.randomUUID());
                gasto.setDescricao("Gasto nº " + i);
                gasto.setValor(BigDecimal.valueOf(10 + (i % 50)));
                gasto.setData(LocalDate.now().minusDays(i % 30));
                gasto.setCategoria("TESTE");
                gasto.setEmail("demo@email.com");

                lista.add(gasto);
            }

            repository.saveAll(lista);
        }
    }
}
