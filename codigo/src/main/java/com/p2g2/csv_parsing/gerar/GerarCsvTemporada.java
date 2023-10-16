package com.p2g2.csv_parsing.gerar;

import java.io.File;
import java.io.FileWriter;
import java.time.Year;
import java.util.ArrayList;

import com.p2g2.model.Equipe;
import com.p2g2.model.Temporada;

public class GerarCsvTemporada {

     /**
     * Gera um arquivo CSV contendo os dados de uma temporada, incluindo o ano e a lista de equipes.
     *
     * @param temporada A temporada da qual os dados serão gerados.
     * @param ano       O ano da temporada.
     */
    public void gerar(Temporada temporada, Year ano) {
        ArrayList<Equipe> equipes = temporada.getEquipes();
        int tamEquipes = equipes.size();

        try {
            File f = new File("codigo\\db\\temporada" + ano + ".csv");
            f.createNewFile();
            FileWriter fw = new FileWriter(f); // fileWriter apontando para o path onde estão os dados

            fw.write(ano.toString() + "," + "Tabela" + ano + ",");

            if (tamEquipes > 0) {
                for (int i = 0; i < tamEquipes; i++) {
                    fw.write(equipes.get(i).getNome()+",");
                }
            } else {
                fw.write("null,");
            }

            fw.write("\n");

            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}