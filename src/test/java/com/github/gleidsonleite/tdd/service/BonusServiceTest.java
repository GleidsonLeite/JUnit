package com.github.gleidsonleite.tdd.service;

import com.github.gleidsonleite.tdd.modelo.Funcionario;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusServiceTest {
    @Test
    public void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario(
                "caUdas",
                LocalDate.now(),
                new BigDecimal("25000")
        ));

        assertEquals(BigDecimal.ZERO, bonus);
    }

    @Test
    public void bonusDeveriaSer10PorCentoDoSalario() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario(
                "Gleidson",
                LocalDate.now(),
                new BigDecimal("2500")
        ));

        assertEquals(new BigDecimal("250"), bonus.setScale(0, RoundingMode.HALF_UP));
    }

    @Test
    public void bonus() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario(
                "Tom",
                LocalDate.now(),
                new BigDecimal("10000")
        ));

        assertEquals(new BigDecimal("1000"), bonus.setScale(0, RoundingMode.HALF_UP));
    }
}