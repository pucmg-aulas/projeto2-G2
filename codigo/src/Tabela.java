import java.util.ArrayList;

public class Tabela {
    private ArrayList<Jogo> jogos;

    public Tabela(ArrayList<Jogo> jogos) {
        this.jogos = jogos;
    }

    public ArrayList<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(ArrayList<Jogo> jogos) {
        this.jogos = jogos;
    }
}
