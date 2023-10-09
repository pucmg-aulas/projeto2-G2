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

    /**
     * Construtor para criar uma nova instância de Temporada com o ano, a tabela e a lista de equipes especificados.
     *
     * @param ano     O ano da temporada.
     * @param tabela  A tabela da temporada.
     * @param equipes A lista de equipes participantes.
     */
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
     * Cadastra um novo jogo na temporada.
     *
     * @param scanner O scanner para entrada de dados.
     */
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

    /**
     * Remove um jogo da temporada.
     *
     * @param scanner O scanner para entrada de dados.
     */
    public void removerJogo(Scanner scanner) {

    }

    /**
     * Cadastra uma nova equipe na temporada.
     *
     * @param scanner     O scanner para entrada de dados.
     * @param novaEquipe  A equipe a ser cadastrada.
     */
    public void cadastrarEquipe(Scanner scanner, Equipe novaEquipe) {
        String nome;
        System.out.println("Informe o nome da equipe");
        nome = scanner.nextLine();
        Equipe equipe = new Equipe(nome);
        equipes.add(equipe);
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
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        System.out.println("Bem-vindo ao Sistema de Gerenciamento de Ligas Desportivas!\n");

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
                    gerar();
                    break;
                case 2:
                    System.out.println("--------------------------------Equipes--------------------------------\n");
                    do {
                        System.out.println("Escolha uma opção:\n");
                        System.out.println("1. Listar equipes");
                        System.out.println("2. Adicionar equipe");
                        System.out.println("3. Excluir equipe");
                        System.out.println("4. Sair");
                        System.out.println("Selecione a opção desejada (digite o número correspondente):");
                        opcao = scanner.nextInt();
                        ArrayList<Equipe> equipes = new ArrayList<Equipe>();

                        switch (opcao) {
                            case 1:
                                listarEquipes();
                                break;
                            case 2:
                                cadastrarEquipe(scanner, equipes);
                                break;
                            case 3:
                                removerEquipe(scanner, equipes);
                                break;
                        }
                    } while (opcao != 4);
                    break;
                case 3:
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
                                listarJogos();
                                break;
                            case 2:
                                cadastrarJogo(scanner);
                                System.out.println("Jogo cadastrado!");
                                break;
                            case 3:
                                removerJogo();
                                System.out.println("Jogo removido!");
                                break;
                        }

                    } while (opcao != 4);
                    break;
            }
        } while (opcao != 4);

        scanner.close();
    }
}
