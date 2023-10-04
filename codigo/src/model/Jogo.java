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

    }

    public char qualEquipe(String nomeEquipe) {
        
    }
}
