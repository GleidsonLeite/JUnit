package com.github.gleidsonleite.tdd.service;

import com.github.gleidsonleite.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class BonusService {

    private static final BigDecimal LIMITE_BONUS = new BigDecimal("1000");

    private static final BigDecimal PERCENTUAL_BONUS = new BigDecimal("0.1");

    public BigDecimal calcularBonus(Funcionario funcionario) {
        BigDecimal valor = funcionario.getSalario().multiply(PERCENTUAL_BONUS);

        if(valor.compareTo(LIMITE_BONUS) > 0) {
            valor = BigDecimal.ZERO;
        }

        return valor;
    }
}
