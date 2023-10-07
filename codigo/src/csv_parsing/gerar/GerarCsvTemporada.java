package csv_parsing.gerar;

import java.io.FileReader;
import java.io.FileWriter;
import java.time.Year;
import java.util.ArrayList;

import model.Temporada;
import model.Tabela;
import model.Equipe;

import java.io.BufferedReader;
import java.io.File;

public class GerarCsvTemporada {

    public void gerar(Temporada temporada, Year ano) {
        ArrayList<Equipe> equipes = temporada.getEquipes();
        Tabela tabela = temporada.getTabela; 
        
        try {
            FileWriter fw = new FileWriter(new File("../db/" + "temporada" + ano + ".csv")); // fileWriter apontando para o path onde estão os dados 
            
            fw.write (ano.toString() + "," + equipes.get(0).getNome()+ "," + equipes.get(1).getNome()+ ";" + equipes.get(2).getNome()+ ";" + equipes.get(3).getNome()+ ";" + equipes.get(4).getNome()+ ";" + equipes.get(5).getNome()+ ";" + equipes.get(6).getNome()+ ";" + equipes.get(7).getNome()+ "\n")
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}