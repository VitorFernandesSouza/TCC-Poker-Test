package br.pucminas.experimento.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestesPokerSemDesempate {

    private final PokerHand.Resultado derrota = PokerHand.Resultado.DERROTA;
    private final PokerHand.Resultado vitoria = PokerHand.Resultado.VITORIA;
    private final PokerHand.Resultado empate  = PokerHand.Resultado.EMPATE;

    @Test
    public void testeRanking() {

        executarTeste("Straight flush vence quadra",
                vitoria, "2H 3H 4H 5H 6H", "AS AD AC AH JD");

        executarTeste("Quadra vence full house",
                vitoria, "2S AH 2H AS AC", "JS JD JC JH AD");

        executarTeste("Full house vence flush",
                vitoria, "2S AH 2H AS AC", "2H 3H 5H 6H 7H");

        executarTeste("Flush vence sequência (straight)",
                vitoria, "2H 3H 5H 6H 7H", "2S 3H 4H 5S 6C");

        executarTeste("Sequência (straight) vence trinca",
                vitoria, "2S 3H 4H 5S 6C", "AH AC 5H 6H AS");

        executarTeste("Trinca vence dois pares",
                vitoria, "AH AC 5H 6H AS", "2S 2H 4H 5S 4C");

        executarTeste("Dois pares vence um par",
                vitoria, "2S 2H 4H 5S 4C", "AH AC 5H 6H 7S");

        executarTeste("Um par vence carta alta",
                vitoria, "AH AC 5H 6H 7S", "2S AH 4H 5S KC");


        // Mesma categoria => EMPATE (sem desempate)
        executarTeste("Dois straight flush diferentes => empate",
                empate, "2H 3H 4H 5H 6H", "KS AS TS QS JS");

        executarTeste("Duas quadras diferentes => empate",
                empate, "AS AH 2H AD AC", "JS JD JC JH 3D");

        executarTeste("Dois full house diferentes => empate",
                empate, "2S AH 2H AS AC", "3S KH 3H KS KC");

        executarTeste("Dois flush diferentes => empate",
                empate, "AS 3S 4S 8S 2S", "2H 3H 5H 6H 7H");

        executarTeste("Dois straights diferentes => empate",
                empate, "2S 3H 4H 5S 6C", "3D 4C 5H 6H 7S");

        executarTeste("Duas trincas diferentes => empate",
                empate, "AH AC 5H 6H AS", "KH KC 2H 2D KS");

        executarTeste("Dois dois-pares diferentes => empate",
                empate, "2S 2H 4H 5S 4C", "3S 3H 7H 7S KC");

        executarTeste("Dois pares diferentes => empate",
                empate, "6S AD 7H 4S AS", "AH AC 5H 6H 7S");

        executarTeste("Duas cartas-altas diferentes => empate",
                empate, "2S 3H 6H 7S 9C", "4S 5H 6H TS AC");

        executarTeste("Cartas iguais => empate",
                empate, "2S AH 4H 5S 6C", "AD 4C 5H 6H 2C");
    }

    private void executarTeste(String descricao, PokerHand.Resultado esperado, String maoJogador, String maoOponente) {
        PokerHand jogador = new PokerHand(maoJogador);
        PokerHand oponente = new PokerHand(maoOponente);
        assertEquals(esperado, jogador.compareWith(oponente), descricao + ":");
    }

}



