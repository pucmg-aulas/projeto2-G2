package csv_parsing.ler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Year;

import model.Tabela;

public class LerCsvTabela {
    public Tabela ler(Year ano) {
        Tabela result;
        String dados;

        try {
            
            BufferedReader br = new BufferedReader(new FileReader(".../db/tabela"+ano+".csv"));
            dados = br.readLine();
            do{
                
            } while(dados != "\0");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
