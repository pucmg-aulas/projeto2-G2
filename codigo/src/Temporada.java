import java.time.Year;
import java.util.ArrayList;

public class Temporada {
    private Year ano;
    private Tabela tabela;
    private ArrayList<Equipe> equipes;


    public Temporada(int ano, int tabela) {
        this.ano = ano;
        this.tabela = tabela;
        equipes = new ArrayList<Equipe>();
    }

    public Year getAno() {
        return ano;
    }

    public void setAno(Year ano) {
        this.ano = ano;
    }

    public Tabela getTabela() {
        return tabela;
    }

    public void setTabela(Tabela tabela) {
        this.tabela = tabela;
    }

    public ArrayList<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(ArrayList<Equipe> equipes) {
        this.equipes = equipes;
    }


    public Equipe buscarEquipe(String nome){

    }

    public void cadastrarJogo(Jogo novoJogo){

    }
    public void cadastrarEquipe(Equipe novaEquipe){
        
    }


}
