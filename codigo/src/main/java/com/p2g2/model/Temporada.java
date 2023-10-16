package main.java.com.p2g2.model;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

import main.java.com.p2g2.csv_parsing.gerar.GerarCsvTabela;
import main.java.com.p2g2.csv_parsing.gerar.GerarCsvTemporada;
import main.java.com.p2g2.csv_parsing.ler.LerCsvTabela;
import main.java.com.p2g2.csv_parsing.ler.LerCsvTemporada;

public class Temporada {
    private Year ano;
    private Tabela tabela;
    private ArrayList<Equipe> equipes;

    public Temporada() {
        this.ano = null;
        this.tabela = new Tabela(new ArrayList<Jogo>());
        this.equipes = new ArrayList<Equipe>();
    }

    public Temporada(Year ano, Tabela tabela, ArrayList<Equipe> equipes) {
        this.ano = ano;
        this.tabela = tabela;
        this.equipes = equipes;
    }

    /**
     * Analisa uma string de data no formato "dd/MM/yyyy" e a converte em um objeto LocalDate.
     *
     * @param data A string de data no formato "dd/MM/yyyy".
     * @return O objeto LocalDate representando a data.
     */
    private LocalDate parseData(String data) {
        String auxData[];

        auxData = data.split("/");

        return LocalDate.of(Integer.parseInt(auxData[2]), Month.of(Integer.parseInt(auxData[1])),
                Integer.parseInt(auxData[0]));
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

    /**
     * Busca uma equipe pelo nome na lista de equipes da temporada.
     *
     * @param nome O nome da equipe a ser buscada.
     * @return A equipe encontrada ou null se não encontrada.
     */
    public Equipe buscarEquipe(String nome) {
        for (int i = 0; i < equipes.size(); i++) {
            if (equipes.get(i).getNome().equals(nome)) {
                return equipes.get(i);
            }
        }
        return null;
    }

    /**
     * Cadastra uma nova equipe na temporada.
     *
     * @param scanner     O scanner para entrada de dados.
     * @param novaEquipe  A equipe a ser cadastrada.
     */
    public void cadastrarEquipe(Scanner scanner) {
        String nome;
        System.out.println("Informe o nome da equipe");
        scanner.nextLine();
        nome = scanner.nextLine();
        equipes.add(new Equipe(nome));
    }

    /**
     * Remove uma equipe da temporada.
     *
     * @param scanner O scanner para entrada de dados.
     */
    public void removerEquipe(Scanner scanner) {
        String auxEquipe;
        int tamEquipes = equipes.size();
        System.out.println("Informe o nome da equipe que deseja remover");
        auxEquipe = scanner.nextLine();
        for (int i = 0; i < tamEquipes; i++) {
            if (equipes.get(i).getNome().equals(auxEquipe)) {
                equipes.remove(i);
                System.out.println("Equipe " + auxEquipe + " removida com sucesso");
            }
        }
    }

    /**
     * Exibe o menu de opções do sistema.
     */
    public void submenuEquipes(Scanner scanner) {
        int opcao, tamEquipes;
        System.out.println("--------------------------------Equipes--------------------------------\n");
        do {
            System.out.println("Escolha uma opção:\n");
            System.out.println("1. Listar equipes");
            System.out.println("2. Adicionar equipe");
            System.out.println("3. Excluir equipe");
            System.out.println("4. Sair");
            System.out.println("Selecione a opção desejada (digite o número correspondente):");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    tamEquipes = equipes.size();
                    System.out.println("\nEquipes:");
                    for (int i = 0; i < tamEquipes; i++) {
                        System.out.println("- " + equipes.get(i).getNome());
                    }

                    break;
                case 2:
                    cadastrarEquipe(scanner);
                    break;
                case 3:
                    removerEquipe(scanner);
                    break;
            }
        } while (opcao != 4);
    }

    public void submenuJogos(Scanner scanner) {
        int opcao;
        System.out.println("--------------------------------Jogos--------------------------------\n");
        do {
            System.out.println("Escolha uma opção:\n");
            System.out.println("1. Listar jogos");
            System.out.println("2. Adicionar jogo");
            System.out.println("3. Excluir jogo");
            System.out.println("4. Sair");
            System.out.println("Selecione a opção desejada (digite o número correspondente):");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    tabela.listarJogos();
                    break;
                case 2:
                    String nomeA;
                    String nomeB;
                    LocalDate data;
                    System.out.println("Informe o nome da equipe A");
                    scanner.nextLine();
                    nomeA = scanner.nextLine();
                    System.out.println("Informe o nome da equipe B");
                    nomeB = scanner.nextLine();
                    System.out.println("Informe a data do jogo");
                    data = parseData(scanner.nextLine());

                    if (data.compareTo(LocalDate.now()) <= 0) {
                        Placar placar = new Placar();
                        System.out.println("Pontuacao " + nomeA + " 1o quarto: ");
                        placar.Q1[0] = scanner.nextInt();
                        System.out.println("Pontuacao " + nomeB + " 1o quarto: ");
                        placar.Q1[1] = scanner.nextInt();
                        System.out.println("Pontuacao " + nomeA + " 2o quarto: ");
                        placar.Q2[0] = scanner.nextInt();
                        System.out.println("Pontuacao " + nomeB + " 2o quarto: ");
                        placar.Q2[1] = scanner.nextInt();
                        System.out.println("Pontuacao " + nomeA + " 3o quarto: ");
                        placar.Q3[0] = scanner.nextInt();
                        System.out.println("Pontuacao " + nomeB + " 3o quarto: ");
                        placar.Q3[1] = scanner.nextInt();
                        System.out.println("Pontuacao " + nomeA + " 4o quarto: ");
                        placar.Q4[0] = scanner.nextInt();
                        System.out.println("Pontuacao " + nomeB + " 4o quarto: ");
                        placar.Q4[1] = scanner.nextInt();

                        if (placar.totalPontos(0) == placar.totalPontos(1)) {
                            System.out.println("Pontuacao " + nomeA + " Prorrogacao: ");
                            placar.OT[0] = scanner.nextInt();
                            System.out.println("Pontuacao " + nomeB + " Prorrogacao: ");
                            placar.OT[1] = scanner.nextInt();
                        }

                        tabela.cadastrarJogo(new Jogo(data, new Equipe(nomeA), new Equipe(nomeB), placar));
                    }
                    break;
                case 3:
                    System.out.println("Informe o nome da equipe A");
                    nomeA = scanner.nextLine();
                    System.out.println("Informe o nome da equipe B");
                    nomeB = scanner.nextLine();
                    System.out.println("Informe a data do jogo");
                    data = parseData(scanner.nextLine());
                    tabela.removerJogo(data, nomeA, nomeB);
                    break;
            }

        } while (opcao != 4);
    }

    public void menu(Scanner scanner) {
        String[] nomesEquipes;
        int tamEquipes;
        int opcao = 0;
        System.out.println("-Temporada " + ano + "-\n");

        do {
            System.out.println("Escolha uma opção:\n");
            System.out.println("1. Gerar tabela");
            System.out.println("2. Equipes");
            System.out.println("3. Jogos");
            System.out.println("4. Sair");
            System.out.println("Selecione a opção desejada (digite o número correspondente):");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    tamEquipes = equipes.size();
                    nomesEquipes = new String[tamEquipes];
                    for (int i = 0; i < tamEquipes; i++) {
                        nomesEquipes[i] = equipes.get(i).getNome();
                    }
                    System.out.println(tabela.gerar(nomesEquipes)); 
                    break;
                case 2:
                    submenuEquipes(scanner);
                    break;
                case 3:
                    submenuJogos(scanner);
                    break;
            }
        } while (opcao != 4);

        scanner.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Temporada temporada;
        GerarCsvTemporada gerarTemporada = new GerarCsvTemporada();
        GerarCsvTabela gerarTabela = new GerarCsvTabela();
        int opcao;

        System.out.println("Bem vindo ao gerenciador de Ligas Desportivas!\n");

        System.out.println("1. Carregar Temporada");
        System.out.println("2. Nova Temporada");
        System.out.println("Escolha uma opcao: ");
        opcao = scanner.nextInt();

        if (opcao == 1) {
            LerCsvTemporada lerTemporada = new LerCsvTemporada();
            LerCsvTabela lerTabela = new LerCsvTabela();
            System.out.println("Entre com o ano da temporada: ");
            temporada = lerTemporada.ler(Year.of(scanner.nextInt()));
            temporada.tabela = lerTabela.ler(temporada.getAno());
            temporada.menu(scanner);
            gerarTabela.gerar(temporada.getTabela(), temporada.getAno());
            gerarTemporada.gerar(temporada, temporada.getAno());
        } else if (opcao == 2) {
            temporada = new Temporada();
            System.out.println("Entre com o ano da temporada: ");
            temporada.setAno(Year.of(scanner.nextInt()));
            temporada.menu(scanner);
            gerarTabela.gerar(temporada.getTabela(), temporada.getAno());
            gerarTemporada.gerar(temporada, temporada.getAno());
        }

        scanner.close();
    }
}
