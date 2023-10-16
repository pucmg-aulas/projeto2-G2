package main.java.com.p2g2.model;

import java.time.LocalDate;

public class Jogo {
    private LocalDate data;
    private Equipe equipeA;
    private Equipe equipeB;
    private Placar placar;

    /**
     * Construtor para criar uma nova instância de Jogo com a data, equipes e placar especificados.
     *
     * @param data     A data em que o jogo ocorreu.
     * @param equipeA  A equipe A que participou do jogo.
     * @param equipeB  A equipe B que participou do jogo.
     * @param placar   O placar do jogo.
     */
    public Jogo(LocalDate data, Equipe equipeA, Equipe equipeB, Placar placar) {
        this.data = data;
        this.equipeA = equipeA;
        this.equipeB = equipeB;
        this.placar = placar;
    }

    public LocalDate getData() {
        return data;
    }

    public Equipe getEquipeA() {
        return equipeA;
    }

    public Equipe getEquipeB() {
        return equipeB;
    }

    public Placar getPlacar() {
        return placar;
    }

    /**
     * Exibe o placar do jogo no console.
     */
    public void exibirPlacar() {
        if (placar != null) {
            int pontosEquipeA = placar.totalPontos(0);
            int pontosEquipeB = placar.totalPontos(1);
            System.out.println("Placar do jogo -" + data + ":");
            System.out.println(equipeA.getNome() + ": " + pontosEquipeA);
            System.out.println(equipeB.getNome() + ": " + pontosEquipeB);
        } else {
            System.out.println("Placar do jogo -" + data + ":");
            System.out.println(equipeA.getNome() + ": " + "x");
            System.out.println(equipeB.getNome() + ": " + "x");
        }

    }

     /**
     * Determina qual equipe corresponde a um nome de equipe fornecido ('A' para equipeA, 'B' para equipeB).
     *
     * @param nomeEquipe O nome da equipe a ser verificado.
     * @return 'A' se o nome corresponder à equipeA, 'B' se corresponder à equipeB.
     * @throws IllegalArgumentException Se o nome de equipe não corresponder a nenhuma das equipes.
     */
    public char qualEquipe(String nomeEquipe) {
        if (nomeEquipe.equals(equipeA.getNome())) {
            return 'A';
        } else if (nomeEquipe.equals(equipeB.getNome())) {
            return 'B';
        } else {
            throw new IllegalArgumentException("Nome de equipe inválido.");
        }
    }

}
