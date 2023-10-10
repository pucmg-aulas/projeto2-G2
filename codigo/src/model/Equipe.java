package model;

public class Equipe {
    private String nome;

    /**
     * Construtor para criar uma nova instância de Equipe com um nome especificado.
     *
     * @param nome O nome da equipe.
     */
    public Equipe(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String setNome() {
        return nome;
    }
}
