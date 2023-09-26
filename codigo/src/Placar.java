public class Placar {

    private int[] Q1 = new int[2];
    private int[] Q2 = new int[2];
    private int[] Q3 = new int[2];
    private int[] Q4 = new int[2]; 
    private int[] OT = new int[2];


    public int[] getQ1(){
        return Q1; 
    }

    public void setQ1(int[] Q1){
        this.Q1 = Q1; 
    }

    public int[] getQ2(){
        return Q2; 
    }

    public void setQ2(int[] Q2){
        this.Q2 = Q2; 
    }

    public int[] getQ3(){
        return Q3; 
    }

    public void setQ3(int[] Q3){
        this.Q3 = Q3; 
    }

    public int[] getQ4(){
        return Q4; 
    }

    public void setQ4(int[] Q4){
        this.Q4 = Q4; 
    }

    public int[] getOT(){
        return OT; 
    }

    public void setOT(int[] OT){
        this.OT = OT; 
    }


    public int[] totalPontos(){

        int[] somaPontos = new int[2];

        for(int i = 0; i < 2; i++){
            somaPontos[i] = Q1[i] + Q2[i] + Q3[i] + Q4[i] + OT[i];
        }

        return somaPontos; 
    }

    public char VencedorDoJogo(){

        int[] pontosEquipes = totalPontos();

        if(pontosEquipes[0] > pontosEquipes[1]){
            return 'A';
        }else{
            return 'B'; 
        }
    }
}