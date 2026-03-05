package br.pucminas.experimento.service;

public class ForcaDaMao {

    private final int nivel;

    public ForcaDaMao(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }

    public boolean maiorQue(ForcaDaMao outra) {
        return this.nivel > outra.nivel;
    }

    public boolean menorQue(ForcaDaMao outra) {
        return this.nivel < outra.nivel;
    }

    public boolean igual(ForcaDaMao outra) {
        return this.nivel == outra.nivel;
    }

}