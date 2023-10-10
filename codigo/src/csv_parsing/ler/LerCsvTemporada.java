package csv_parsing.ler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Year;
import java.util.ArrayList;

import model.Equipe;
import model.Temporada;

public class LerCsvTemporada {

    public Temporada ler(Year ano) {
        ArrayList<Equipe> equipes = new ArrayList<Equipe>();
        String line;
        String[] dados;
        Equipe auxEquipe;

        try {

            BufferedReader br = new BufferedReader(new FileReader("codigo\\db\\temporada" + ano + ".csv"));
            line = br.readLine();
            // Tabela tabela = temporada.getTabela();

            while (line != null) {
                dados = line.split(",");

                // Criando equipes com os nomes do arquivo gerado e adicionando no ArrayList de
                // equipes
                if (!dados[2].equals("null")) {
                    for (int i = 2; i < dados.length; i++) {
                        auxEquipe = new Equipe(dados[i]);
                        equipes.add(auxEquipe);
                    }
                }

                line = br.readLine();
            }

            br.close();

            return new Temporada(ano, null, equipes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
