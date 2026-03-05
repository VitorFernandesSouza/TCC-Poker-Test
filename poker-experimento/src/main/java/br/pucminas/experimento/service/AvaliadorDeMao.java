package br.pucminas.experimento.service;

import java.util.*;
import java.util.stream.Collectors;

public class AvaliadorDeMao {

    /**
     * Retorna apenas a categoria/nível da mão.
     * IMPORTANTE: sem desempate complexo. Se duas mãos tiverem o mesmo nível, considere EMPATE.
     *
     * Níveis (maior é melhor):
     * 8 = STRAIGHT_FLUSH
     * 7 = QUADRA
     * 6 = FULL_HOUSE
     * 5 = FLUSH
     * 4 = STRAIGHT
     * 3 = TRINCA
     * 2 = DOIS_PARES
     * 1 = UM_PAR
     * 0 = CARTA_ALTA
     */
    public int avaliarNivel(List<Carta> cartas) {
        boolean flush = isFlush(cartas);
        boolean straight = isStraight(cartas);

        Map<Integer, Long> freq =
                cartas.stream().collect(Collectors.groupingBy(Carta::getValor, Collectors.counting()));

        Collection<Long> contagens = freq.values();

        if (straight && flush) return 8;
        if (contagens.contains(4L)) return 7;
        if (contagens.contains(3L) && contagens.contains(2L)) return 6;
        if (flush) return 5;
        if (straight) return 4;
        if (contagens.contains(3L)) return 3;

        long pares = contagens.stream().filter(v -> v == 2L).count();
        if (pares == 2) return 2;
        if (pares == 1) return 1;

        return 0;
    }

    private boolean isFlush(List<Carta> cartas) {
        char naipe = cartas.get(0).getNaipe();
        for (Carta c : cartas) {
            if (c.getNaipe() != naipe) return false;
        }
        return true;
    }

    public int avaliar(List<Carta> cartas) {
    return avaliarNivel(cartas);
}

    private boolean isStraight(List<Carta> cartas) {
        List<Integer> valores = cartas.stream()
                .map(Carta::getValor)
                .sorted()
                .collect(Collectors.toList());

        if (valores.equals(Arrays.asList(2, 3, 4, 5, 14))) return true;

        for (int i = 0; i < valores.size() - 1; i++) {
            if (valores.get(i) + 1 != valores.get(i + 1)) return false;
        }
        return true;
    }

}
