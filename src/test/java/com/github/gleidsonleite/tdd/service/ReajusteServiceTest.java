package com.github.gleidsonleite.tdd.service;

import com.github.gleidsonleite.tdd.modelo.Desempenho;
import com.github.gleidsonleite.tdd.modelo.Funcionario;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class ReajusteServiceTest {
    @Test
    public void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADesejar() {
        ReajusteService service = new ReajusteService();

        Funcionario funcionario = new Funcionario("Gleidson", LocalDate.now(), new BigDecimal("1000"));
        service.execute(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030"), funcionario.getSalario().setScale(0, RoundingMode.HALF_UP));
    }
    @Test
    public void reajusteDeveriaSerDe15PorCentoQuandoDesempenhoForADesejar() {
        ReajusteService service = new ReajusteService();

        Funcionario funcionario = new Funcionario("Gleidson", LocalDate.now(), new BigDecimal("1000"));
        service.execute(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150"), funcionario.getSalario().setScale(0, RoundingMode.HALF_UP));
    }
    @Test
    public void reajusteDeveriaSerDe20PorCentoQuandoDesempenhoForADesejar() {
        ReajusteService service = new ReajusteService();

        Funcionario funcionario = new Funcionario("Gleidson", LocalDate.now(), new BigDecimal("1000"));
        service.execute(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200"), funcionario.getSalario().setScale(0, RoundingMode.HALF_UP));
    }
}
