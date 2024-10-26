package model;

// Eu faria o uso da lib lombok para gerar os getters, setters
// e construtores. Isso evitaria a necessidade de escrever código
// repetitivo.
public class Equipe {
    private String nome;
    // Para todo tipo de código que não seja uma biblioteca, é
    // essencial que se evite o uso de comentario, pois elem poluem
    // seu código e o tornam mais verboso que o necessário. Especialmente
    // quando o código é auto-explicativo. como o caso da variavel nome abaixo.

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

    // O método setNome esta incorreto, pois ele não recebe um parametro.
    // Este na verdade parece ser um clone do metodo get porém
    // com o nome alterado.
    public String setNome() {
        return nome;
    }
}
