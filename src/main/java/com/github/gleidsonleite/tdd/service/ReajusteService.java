package com.github.gleidsonleite.tdd.service;

import com.github.gleidsonleite.tdd.modelo.Desempenho;
import com.github.gleidsonleite.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void execute(Funcionario funcionario, Desempenho desempenho) {
        BigDecimal percentualReajuste = desempenho.percentualReajuste();
        BigDecimal reajuste = funcionario.getSalario().multiply(percentualReajuste);
        funcionario.reajustarSalario(reajuste);
    }
}
