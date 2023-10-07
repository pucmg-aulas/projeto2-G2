package csv_parsing.ler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Year;
import java.util.ArrayList;

import model.Equipe;
import model.Temporada;
import model.Tabela;

public class LerCsvTemporada {

    public Tabela BuscarTabela(String[] dados){

    }

    public Temporada ler(Year ano) {
        ArrayList<Equipe> equipes = new ArrayList<Equipe>();
        String line;
        String[] dados;

        try {
            
            BufferedReader br = new BufferedReader(new FileReader(".../db/temporada"+ano+".csv"));
            line = br.readLine();
            //Tabela tabela = temporada.getTabela();

            while (line != null) {
                dados = line.split(",");

                //Criando equipes com  os nomes do arquivo gerado e adicionando no ArrayList de equipes
                Equipe equipe = new Equipe(dados[2]);
                equipes.add(equipe);
                
                equipe = new Equipe(dados[3]);
                equipes.add(equipe);

                equipe = new Equipe(dados[4]);
                equipes.add(equipe);

                equipe = new Equipe(dados[5]);
                equipes.add(equipe);

                equipe = new Equipe(dados[6]);
                equipes.add(equipe);

                equipe = new Equipe(dados[7]);
                equipes.add(equipe);

                equipe = new Equipe(dados[8]);
                equipes.add(equipe);

                equipe = new Equipe(dados[9]);
                equipes.add(equipe);

                line = br.readLine();
            }

            br.close();

            return new Temporada(ano, tabela, equipes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
