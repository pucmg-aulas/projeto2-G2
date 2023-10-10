package model;
public class Placar {

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