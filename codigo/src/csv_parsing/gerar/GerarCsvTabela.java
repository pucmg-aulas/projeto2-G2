package csv_parsing.gerar;

import java.io.File;
import java.io.FileWriter;
import java.time.Year;
import java.util.ArrayList;

import model.Jogo;
import model.Placar;
import model.Tabela;


public class GerarCsvTabela {

    public void gerar(Tabela tabela, Year ano) {
        ArrayList<Jogo> jogos = tabela.getJogos();
        Jogo auxJogo;
        Placar auxPlacar;
        
        try {
            FileWriter fw = new FileWriter(new File("../db/" + "tabela" + ano + ".csv")); // fileWriter apontando para o path onde estão os dados 
            
            for(int i = 0; i < jogos.size(); i++) {
                auxJogo = jogos.get(i);
                auxPlacar = auxJogo.getPlacar();
                fw.write(auxJogo.getData().toString()+","+auxJogo.getEquipeA().getNome()+","+auxJogo.getEquipeB().getNome()+","+auxPlacar.Q1[0]+","+auxPlacar.Q1[1]+","+auxPlacar.Q2[0]+","+auxPlacar.Q2[1]+","+auxPlacar.Q3[0]+","+auxPlacar.Q3[1]+","+auxPlacar.Q4[0]+","+auxPlacar.Q4[1]+","+auxPlacar.OT[0]+","+auxPlacar.OT[1]+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
