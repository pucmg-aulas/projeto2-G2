package model;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class Temporada {
    private Year ano;
    private Tabela tabela;
    private ArrayList<Equipe> equipes;

    public Temporada(Year ano, Tabela tabela, ArrayList<Equipe> equipes){
        this.ano = ano;
        this.tabela = tabela;
        this.equipes = equipes;
    }

    private LocalDate parseData(String data) {
        String auxData[];

        auxData = data.split("/");

        return LocalDate.of(Integer.parseInt(auxData[2]), Month.of(Integer.parseInt(auxData[1])), Integer.parseInt(auxData[0]));
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
        for(int i = 0;i<equipes.size();i++){
            if(equipes.get(i).getNome().equals(nome)){
                return equipes.get(i);
            }
        }
            return null;
    }

    public void cadastrarJogo(Scanner scanner) {
        String nomeA;
        String nomeB;
        LocalDate data;
        System.out.println("Informe o nome da equipe A");
        nomeA = scanner.nextLine();
        System.out.println("Informe o nome da equipe B");
        nomeB = scanner.nextLine();
        System.out.println("Informe a data do jogo");
        data = parseData(scanner.nextLine());

    }
    public void removerJogo(Scanner scanner){

    }

    public void cadastrarEquipe(Scanner scanner, Equipe novaEquipe) {
        String nome;
        System.out.println("Informe o nome da equipe");
        nome = scanner.nextLine();
        Equipe equipe = new Equipe(nome);
        equipes.add(equipe);
    }

    public void removerEquipe(Scanner scanner){
        String auxEquipe;
        int tamEquipes = equipes.size();
        System.out.println("Informe o nome da equipe que deseja remover");
        auxEquipe = scanner.nextLine();
        for(int i = 0; i < tamEquipes; i++){
            if(equipes.get(i).getNome().equals(auxEquipe)){
                equipes.remove(i);
                System.out.println("Equipe " + auxEquipe + " removida com sucesso");
            }
        }
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
                    
                    break;
                case 2:
                    
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
