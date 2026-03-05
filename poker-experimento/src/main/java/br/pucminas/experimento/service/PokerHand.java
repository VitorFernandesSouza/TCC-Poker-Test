package br.pucminas.experimento.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PokerHand {

    public enum Resultado { EMPATE, VITORIA, DERROTA }

    private static final int QTD_CARTAS = 5;

    private final List<Carta> cartas;
    private final AvaliadorDeMao avaliador;

    public PokerHand(String hand) {
        Objects.requireNonNull(hand, "hand não pode ser null");

        this.cartas = parsearCartas(hand);
        this.avaliador = new AvaliadorDeMao();
    }

    public Resultado compareWith(PokerHand outra) {
        Objects.requireNonNull(outra, "outra mão não pode ser null");

        ForcaDaMao minhaForca = avaliador.avaliar(this.cartas);
        ForcaDaMao forcaOponente = avaliador.avaliar(outra.cartas);

        if (minhaForca.maiorQue(forcaOponente)) return Resultado.VITORIA;
        if (minhaForca.menorQue(forcaOponente)) return Resultado.DERROTA;
        return Resultado.EMPATE; 
    }

    private List<Carta> parsearCartas(String hand) {
        String[] tokens = hand.trim().split("\\s+");
        if (tokens.length != QTD_CARTAS) {
            throw new IllegalArgumentException("A mão deve conter exatamente " + QTD_CARTAS + " cartas.");
        }

        List<Carta> lista = new ArrayList<>(QTD_CARTAS);
        for (String token : tokens) {
            lista.add(new Carta(token));
        }
        return lista;
    }

    List<Carta> getCartas() {
        return cartas;
    }
}