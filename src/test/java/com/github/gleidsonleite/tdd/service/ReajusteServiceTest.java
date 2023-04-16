package com.github.gleidsonleite.tdd.service;

import com.github.gleidsonleite.tdd.modelo.Desempenho;
import com.github.gleidsonleite.tdd.modelo.Funcionario;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar() {
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Gleidson", LocalDate.now(), new BigDecimal("1000"));
    }

    @AfterEach
    public void finalizar() {
        System.out.println("fim");
    }

    @BeforeAll
    public static void antesDeTodos() {
        System.out.println("ANTES DE TODOS");
    }

    @AfterAll
    public static void depoisDeTodos() {
        System.out.println("DEPOIS DE TODOS");
    }

    @Test
    public void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADesejar() {
        service.execute(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030"), funcionario.getSalario().setScale(0, RoundingMode.HALF_UP));
    }
    @Test
    public void reajusteDeveriaSerDe15PorCentoQuandoDesempenhoForADesejar() {
        service.execute(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150"), funcionario.getSalario().setScale(0, RoundingMode.HALF_UP));
    }
    @Test
    public void reajusteDeveriaSerDe20PorCentoQuandoDesempenhoForADesejar() {
        service.execute(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200"), funcionario.getSalario().setScale(0, RoundingMode.HALF_UP));
    }
}
