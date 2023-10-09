package model;

import java.time.LocalDate;

public class Jogo {
    private LocalDate data;
    private Equipe equipeA;
    private Equipe equipeB;
    private Placar placar;

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
