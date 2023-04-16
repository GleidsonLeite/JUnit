package com.github.gleidsonleite.tdd.service;

import com.github.gleidsonleite.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class BonusService {

    private static final BigDecimal LIMITE_BONUS = new BigDecimal("1000");

    private static final BigDecimal PERCENTUAL_BONUS = new BigDecimal("0.1");

    public BigDecimal calcularBonus(Funcionario funcionario) throws IllegalArgumentException {
        BigDecimal valor = funcionario.getSalario().multiply(PERCENTUAL_BONUS);

        if (valor.compareTo(LIMITE_BONUS) > 0) {
            throw new IllegalArgumentException("Funcionario com salario maior do que R$ 10.000,00 nao pode receber bonus!");
        }

        return valor;
    }
}
