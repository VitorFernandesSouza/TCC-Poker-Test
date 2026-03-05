package br.pucminas.experimento.service;

public class Carta {

    private final int valor;
    private final char naipe;

    public Carta(String representacao) {

        char valorChar = representacao.charAt(0);
        char naipeChar = representacao.charAt(1);

        this.valor = converterValor(valorChar);
        this.naipe = naipeChar;
    }

    private int converterValor(char valor) {

        switch (valor) {
            case 'T': return 10;
            case 'J': return 11;
            case 'Q': return 12;
            case 'K': return 13;
            case 'A': return 14;
            default:
                return Character.getNumericValue(valor);
        }
    }

    public int getValor() {
        return valor;
    }

    public char getNaipe() {
        return naipe;
    }
}