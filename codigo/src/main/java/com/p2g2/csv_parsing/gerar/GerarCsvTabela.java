package main.java.com.p2g2.csv_parsing.gerar;

import java.io.File;
import java.io.FileWriter;
import java.time.Year;
import java.util.ArrayList;

import main.java.com.p2g2.model.Jogo;
import main.java.com.p2g2.model.Placar;
import main.java.com.p2g2.model.Tabela;

public class GerarCsvTabela {

    /**
     * Gera um arquivo gravando os dados presentes em Tabela.
     * @param tabela a {@code Tabela} a ser gravada
     * @param ano especifica o nome do arquivo
     */

    public void gerar(Tabela tabela, Year ano) {
        ArrayList<Jogo> jogos = tabela.getJogos();
        Jogo auxJogo;
        Placar auxPlacar;
        
        try {
            File f = new File("codigo\\db\\tabela" + ano + ".csv");
            f.createNewFile();
            FileWriter fw = new FileWriter(f); // fileWriter apontando para o path onde estão os dados 
            
            for(int i = 0; i < jogos.size(); i++) {
                auxJogo = jogos.get(i);
                auxPlacar = auxJogo.getPlacar();
                fw.write(auxJogo.getData().toString()+","+auxJogo.getEquipeA().getNome()+","+auxJogo.getEquipeB().getNome()+","+auxPlacar.Q1[0]+","+auxPlacar.Q1[1]+","+auxPlacar.Q2[0]+","+auxPlacar.Q2[1]+","+auxPlacar.Q3[0]+","+auxPlacar.Q3[1]+","+auxPlacar.Q4[0]+","+auxPlacar.Q4[1]+","+auxPlacar.OT[0]+","+auxPlacar.OT[1]+"\n");
            }

            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
