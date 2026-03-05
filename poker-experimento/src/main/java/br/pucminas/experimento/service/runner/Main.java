package br.pucminas.experimento.runner;

import br.pucminas.experimento.service.PokerHand;

public class Main {

    public static void main(String[] args) {

        PokerHand jogador = new PokerHand("2H 3H 4H 5H 6H");
        PokerHand oponente = new PokerHand("AS AD AC AH JD");

        PokerHand.Resultado resultado = jogador.compareWith(oponente);

        System.out.println("Mão do jogador: 2H 3H 4H 5H 6H");
        System.out.println("Mão do oponente: AS AD AC AH JD");
        System.out.println("Resultado: " + resultado);
    }
}