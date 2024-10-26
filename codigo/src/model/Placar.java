package model;
public class Placar {

    // Aconselharia o uso de uma matriz para a armazenagem dos
    // pontos de cada quarto

    // Todos os atributos de uma classe deveriam ser privados com metodos
    // set para que seus valores sejam alterados.

    // Sinto que o uso da nomeclarutra equipe A e B, ao mesmo tempo que posEquipe
    // 0 e 1, é um pouco confusa. Escolheria uma unica para usar e Criaria um Objeto
    // separada para ter a noção de Placar por quarto, na qual cada quaeto teria
    // dois atributos inteiros, um para a pirmiera equipe outra para a segunda.
    public int[] Q1;
    public int[] Q2;
    public int[] Q3;
    public int[] Q4; 
    public int[] OT;

    /**
     * Construtor padrão que inicializa os arrays para duas equipes.
     */
    public Placar(){
        Q1 = new int[2];
        Q2 = new int[2];
        Q3 = new int[2];
        Q4 = new int[2];
        OT = new int[2];
    }

    /**
     * Construtor que permite inicializar os arrays com valores específicos.
     *
     * @param Q1 Um array com os pontos de cada equipe no primeiro quarto.
     * @param Q2 Um array com os pontos de cada equipe no segundo quarto.
     * @param Q3 Um array com os pontos de cada equipe no terceiro quarto.
     * @param Q4 Um array com os pontos de cada equipe no quarto quarto.
     * @param OT Um array com os pontos de cada equipe na prorrogação.
     */
    public Placar(int[] Q1,int[] Q2,int[] Q3,int[] Q4, int[] OT){
        this.Q1 = Q1;
        this.Q2 = Q2;
        this.Q3 = Q3;
        this.Q4 = Q4;
        this.OT = OT;
    }
    
    /**
     * Calcula o total de pontos de uma equipe ao longo do jogo.
     *
     * @param posEquipe A posição da equipe no array (0 para equipe A, 1 para equipe B).
     * @return O total de pontos da equipe.
     */
    public int totalPontos(int posEquipe){
        return Q1[posEquipe] + Q2[posEquipe] + Q3[posEquipe] + Q4[posEquipe] + OT[posEquipe]; 
    }

     /**
     * Determina o vencedor do jogo com base nos pontos totais das equipes.
     *
     * @return 'A' se a equipe A vencer, 'B' se a equipe B vencer.
     */
    public char vencedorDoJogo(){
        if(totalPontos(0) > totalPontos(1)){
            return 'A';
        }else {
            return 'B';
        }
    }
}