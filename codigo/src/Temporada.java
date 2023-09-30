import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class Temporada {
    private Year ano;
    private Tabela tabela;
    private ArrayList<Equipe> equipes;

    public Temporada(Year ano, Tabela tabela) {
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

    public Equipe buscarEquipe(String nome) {

    }

    public void cadastrarJogo(Jogo novoJogo) {

    }

    public void cadastrarEquipe(Equipe novaEquipe) {

    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        System.out.println("Bem-vindo ao Sistema de Gerenciamento de Ligas Desportivas!\n");
        do{
            System.out.println("Escolha uma opção:\n");
            System.out.println("1. Cadastrar Partida");
            System.out.println("2. Buscar Equipe");
            System.out.println("3. Listar Todas as Partidas");
            System.out.println("4. Gerar Tabela de Classificação");
            System.out.println("5. Equipe com o Melhor Ataque");
            System.out.println("6. Equipe com a Melhor Defesa");
            System.out.println("7. Sair\n");
            System.out.println("Selecione a opção desejada (digite o número correspondente):");
            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    cadastrarJogo(jogo);
                    break;
                case 2:
                    buscarJogosEquipe(equipe);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                
                    

                
            }
            
        } while (opcao != 7);

        

        scanner.close();

    }

}
