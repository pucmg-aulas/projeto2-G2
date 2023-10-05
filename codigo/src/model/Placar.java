package model;
public class Placar {

    public int[] Q1;
    public int[] Q2;
    public int[] Q3;
    public int[] Q4; 
    public int[] OT;

    public Placar(){
        Q1 = new int[2];
        Q2 = new int[2];
        Q3 = new int[2];
        Q4 = new int[2];
        OT = new int[2];
    }
    
    public int totalPontos(int posEquipe){
        return Q1[posEquipe] + Q2[posEquipe] + Q3[posEquipe] + Q4[posEquipe] + OT[posEquipe]; 
    }

    public char vencedorDoJogo(){
        if(totalPontos(0) > totalPontos(1)){
            return 'A';
        }else {
            return 'B';
        }
    }
}