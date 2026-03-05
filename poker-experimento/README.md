# Experimento -- Avaliação de Autonomia Técnica no Desenvolvimento de Software

Este repositório contém um exercício prático utilizado em um experimento
acadêmico que investiga o impacto do uso de ferramentas de Inteligência
Artificial generativa no processo de aprendizagem e na autonomia técnica
durante atividades de desenvolvimento de software.

O experimento é composto por duas etapas principais:

1.  **Modelagem de software (UML)**
2.  **Implementação em Java**

O problema proposto consiste na implementação de um sistema capaz de
**comparar duas mãos de poker** e determinar qual delas é vencedora.

------------------------------------------------------------------------

# Objetivo do exercício

O objetivo do exercício é desenvolver um pequeno sistema orientado a
objetos capaz de:

-   Representar cartas de um baralho
-   Representar uma mão de poker
-   Avaliar a força de uma mão
-   Comparar duas mãos de poker

O sistema deve seguir princípios de **Programação Orientada a Objetos**,
como:

-   encapsulamento
-   separação de responsabilidades
-   organização em classes

------------------------------------------------------------------------

# Regras simplificadas do Poker utilizadas no exercício

Uma mão de poker é composta por **5 cartas**.

Cada carta possui:

-   **Valor**
-   **Naipe**

## Valores possíveis

| Símbolo | Valor |
|--------|------|
| 2 | 2 |
| 3 | 3 |
| 4 | 4 |
| 5 | 5 |
| 6 | 6 |
| 7 | 7 |
| 8 | 8 |
| 9 | 9 |
| T | 10 |
| J | Valete |
| Q | Dama |
| K | Rei |
| A | Ás |


## Naipes possíveis

| Símbolo | Naipe |
|--------|------|
| H | Hearts (Copas) |
| D | Diamonds (Ouros) |
| C | Clubs (Paus) |
| S | Spades (Espadas) |

Exemplo de carta:

    KS

Significa:

    K = Rei
    S = Espadas
<img width="153" height="289" alt="image" src="https://github.com/user-attachments/assets/4aadc3ee-004e-417c-b1af-b27b3c6c78a0" />

------------------------------------------------------------------------

# Representação das mãos

Uma mão é representada como uma **string com 5 cartas separadas por
espaço**.

Exemplo:

    "KS 2H 5C JD TD"

------------------------------------------------------------------------

<img width="73" height="209" alt="image" src="https://github.com/user-attachments/assets/4aadc3ee-004e-417c-b1af-b27b3c6c78a0" />
<img width="73" height="209" alt="image" src="https://github.com/user-attachments/assets/1ff07e27-2724-4fce-a582-288466d10ab9" />
<img width="73" height="209" alt="image" src="https://github.com/user-attachments/assets/e413e294-9c91-42ce-beaf-3232fd042237" />
<img width="73" height="209" alt="image" src="https://github.com/user-attachments/assets/c1470375-2586-4f02-8dcc-ef9a7a45841a" />
<img width="73" height="209" alt="image" src="https://github.com/user-attachments/assets/2798ab45-38a3-4f40-84ce-5a7cc798d6c9" />

## Como cada mão é formada

Abaixo estão exemplos e descrições de cada tipo de mão utilizada no exercício.

### Straight Flush
Cinco cartas **em sequência numérica** e **do mesmo naipe**.

Exemplo: 2H 3H 4H 5H 6H

<img width="657" height="250" alt="image" src="https://github.com/user-attachments/assets/53e7163b-92eb-4045-92f3-0e6a7b8304d6" />

Todas as cartas são de **copas (H)** e estão em **sequência**.

---

### Four of a Kind (Quadra)
Quatro cartas com **o mesmo valor**.

Exemplo:

<img width="657" height="250" alt="image" src="https://github.com/user-attachments/assets/add25734-4b3d-475e-8d37-e5821a68ce23" />

Quatro ases e uma carta qualquer.

---

### Full House
Uma **trinca** e um **par**.

Exemplo:

<img width="657" height="250" alt="image" src="https://github.com/user-attachments/assets/5df7332c-2e2c-4542-85a2-25fc633832f0" />

Três cartas de valor 3 e duas cartas de valor 9.

---

### Flush
Cinco cartas **do mesmo naipe**, mas **não necessariamente em sequência**.

Exemplo:


<img width="657" height="250" alt="image" src="https://github.com/user-attachments/assets/2eb86957-341d-4591-aeef-460be2be63a5" />


Todas as cartas são de copas.

---

### Straight
Cinco cartas em **sequência numérica**, mas **com naipes diferentes**.

Exemplo:

<img width="657" height="250" alt="image" src="https://github.com/user-attachments/assets/e63de0dc-cc6b-4948-90f0-d80bd481df5c" />


---

### Three of a Kind (Trinca)
Três cartas com **o mesmo valor**.

Exemplo:

<img width="657" height="250" alt="image" src="https://github.com/user-attachments/assets/86548832-7f10-4870-a91f-0c6495fc5bc9" />


---

### Two Pair (Dois pares)
Dois pares diferentes.

Exemplo:

<img width="657" height="250" alt="image" src="https://github.com/user-attachments/assets/c5593982-fab6-47ea-812b-242bc94af314" />


---

### Pair (Um par)
Duas cartas com **o mesmo valor**.

Exemplo:

<img width="657" height="250" alt="image" src="https://github.com/user-attachments/assets/41fbaf86-3b49-479f-a45b-4e19ac632ce0" />


---

### High Card (Carta alta)
Nenhuma combinação especial.

Exemplo:

<img width="657" height="250" alt="image" src="https://github.com/user-attachments/assets/d2b22ca8-fd54-41e6-ada4-5ef676f2703c" />


# Ranking das mãos

O ranking de mãos utilizado no exercício (do mais forte para o mais
fraco) é:

| Nível | Mão |
|------|-----|
| 8 | Straight Flush |
| 7 | Four of a Kind (Quadra) |
| 6 | Full House |
| 5 | Flush |
| 4 | Straight |
| 3 | Three of a Kind (Trinca) |
| 2 | Two Pair (Dois pares) |
| 1 | Pair (Um par) |
| 0 | High Card (Carta alta) |

### Importante

Neste exercício **não é necessário implementar desempates complexos**.

Se duas mãos tiverem **a mesma categoria**, o resultado deve ser
considerado:

    EMPATE

------------------------------------------------------------------------

# Estrutura do projeto

O projeto já possui uma estrutura inicial organizada em pacotes.

    src
    ├─ main
    │  └─ java
    │     └─ br.pucminas.experimento
    │        ├─ runner
    │        │     Main.java
    │        │
    │        └─ service
    │              Carta.java
    │              PokerHand.java
    │              AvaliadorDeMao.java
    │              ForcaDaMao.java
    │
    └─ test
       └─ java
          └─ br.pucminas.experimento.service
               TestesPokerSemDesempate.java

------------------------------------------------------------------------

# Parte 1 -- Modelagem UML

Antes da implementação do código, você deve criar um **diagrama de
classes UML** representando a solução.

O diagrama deve representar:

-   as classes do sistema
-   seus atributos
-   seus métodos
-   os relacionamentos entre elas

## Classes esperadas

O sistema deve possuir pelo menos as seguintes classes:

### Carta.java

Representa uma carta do baralho.

Responsável por: - armazenar o valor da carta - armazenar o naipe

### PokerHand.java

Representa uma mão de poker.

Responsável por: - armazenar as cartas da mão - comparar duas mãos

### AvaliadorDeMao.java

Responsável por: - analisar uma mão - determinar sua força

### ForcaDaMao.java

Representa o resultado da avaliação da mão.

Responsável por: - armazenar o nível da mão - permitir comparação entre
forças de mãos

## Ferramentas sugeridas para UML

Você pode utilizar:

-   Draw.io
-   PlantUML
-   Lucidchart
-   qualquer outra ferramenta de modelagem UML

------------------------------------------------------------------------

# Parte 2 -- Implementação

Após criar o diagrama UML, você deve implementar o sistema em Java.

A implementação deve permitir comparar duas mãos de poker.

## Exemplo de uso esperado

``` java
PokerHand jogador = new PokerHand("2H 3H 4H 5H 6H");
PokerHand oponente = new PokerHand("AS AD AC AH JD");

PokerHand.Resultado resultado = jogador.compareWith(oponente);
```

Resultado esperado:

    VITORIA

------------------------------------------------------------------------

# Resultado da comparação

O método `compareWith` deve retornar:

  Resultado   Significado
  ----------- ------------------------------------
  VITORIA     A primeira mão é mais forte
  DERROTA     A segunda mão é mais forte
  EMPATE      As duas mãos têm a mesma categoria

------------------------------------------------------------------------

# Testes automatizados

O projeto já contém **testes automatizados**.

Você não precisa criar novos testes.

Sua implementação deve passar nos testes fornecidos.

------------------------------------------------------------------------

# Requisitos importantes

Durante a implementação, procure:

-   utilizar boas práticas de programação
-   manter classes com responsabilidades claras
-   evitar colocar toda a lógica em uma única classe
-   manter o código organizado

------------------------------------------------------------------------

# O que será entregue

Você deve entregar:

1.  O **diagrama de classes UML**
2.  A **implementação completa em Java**
3.  O código capaz de executar os testes fornecidos

------------------------------------------------------------------------

# Tempo estimado

O exercício foi projetado para ser resolvido em aproximadamente:

    60 minutos

------------------------------------------------------------------------

# Observação

O objetivo deste exercício **não é apenas chegar à solução**, mas
compreender como você estrutura e desenvolve a solução para o problema
proposto.
