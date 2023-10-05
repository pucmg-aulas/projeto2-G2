package csv_parsing.ler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;

import model.Equipe;
import model.Jogo;
import model.Placar;
import model.Tabela;

public class LerCsvTabela {

    /**
     * Transforma a {@code string} lida no campo de index {@code 0} do arquivo csv para o tipo {@code LocalDate},
     * que será atribuído à Jogo.
     * @param data
     * @return uma data do tipo {@code LocalDate}.
     */

    private LocalDate parseDataJogo(String data) {
        String[] aux;
        aux = data.split("-");

        return LocalDate.of(Integer.parseInt(aux[0]), Month.of(Integer.parseInt(aux[1])), Integer.parseInt(aux[2]));
    }

    /**
     * Faz a conversão dos dados lidos nos campos de index {@code 3 a 12} na linha do arquivo csv para {@code int},
     * e constrói uma instância de {@code Placar} para ser atribuída à {@code Jogo}.
     * @param dados
     * @return uma instância da classe {@code Placar}.
     */

    private Placar montarPlacar(String[] dados) {
        int Q1[] = {Integer.parseInt(dados[3]), Integer.parseInt(dados[4])};
        int Q2[] = {Integer.parseInt(dados[5]), Integer.parseInt(dados[6])};
        int Q3[] = {Integer.parseInt(dados[7]), Integer.parseInt(dados[8])};
        int Q4[] = {Integer.parseInt(dados[9]), Integer.parseInt(dados[10])};
        int OT[] = {Integer.parseInt(dados[11]), Integer.parseInt(dados[12])};

        return new Placar(Q1, Q2, Q3, Q4, OT);
    }

    /**
     * Constrói a Tabela a partir dos dados lidos no arquivo csv armazenado.
     * @param ano
     * @return uma instância da classe {@code Tabela}.
     */

    public Tabela ler(Year ano) {
        ArrayList<Jogo> jogos = new ArrayList<Jogo>();
        String line;
        String[] dados;

        try {
            
            BufferedReader br = new BufferedReader(new FileReader(".../db/tabela"+ano+".csv"));
            line = br.readLine();

            while (line != null) {
                dados = line.split(",");
                jogos.add(new Jogo(parseDataJogo(dados[0]), new Equipe(dados[1]), new Equipe(dados[2]), montarPlacar(dados)));
                line = br.readLine();
            }

            br.close();

            return new Tabela(jogos);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
