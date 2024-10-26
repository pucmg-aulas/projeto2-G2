package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tabela {
    // Eu usaria a interface List como o tipo do OBJ para ser mais 
    // adequado aos pricipios SOLID.
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

    public void cadastrarJogo(Jogo novoJogo) {
        jogos.add(novoJogo);
    }

    /**
     * Remove um jogo da lista de jogos com base na data e nas equipes.
     *
     * @param data     A data do jogo a ser removido.
     * @param equipeA  O nome da primeira equipe do jogo a ser removido.
     * @param equipeB  O nome da segunda equipe do jogo a ser removido.
     */
    public void removerJogo(LocalDate data, String equipeA, String equipeB) {
        int tamJogos = jogos.size();
        Jogo auxJogo;

        for (int i = 0; i < tamJogos; i++) {
            auxJogo = jogos.get(i);
            if (auxJogo.getData().equals(data) && auxJogo.getEquipeA().getNome().compareTo(equipeA) == 0
                    && auxJogo.getEquipeA().getNome().compareTo(equipeB) == 0) {
                jogos.remove(i);
                System.out.println("\nJogo removido com sucesso");
            } else {
                System.out.println("\nErro: Jogo inexistente");
            }
        }
    }

    // Faria o uso de um expreção Lambda para melhor legibilidade, no
    // caso a espreção foreach
    /**
     * Lista todos os jogos na lista de jogos e exibe o placar de cada jogo.
     */
    public void listarJogos() {
        int tamJogos = jogos.size();

        for (int i = 0; i < tamJogos; i++) {
            System.out.println("---------Jogos---------");
            jogos.get(i).exibirPlacar();
            System.out.println("-----------------------");
        }
    }

    /**
     * Busca os jogos de determinada equipe.
     * 
     * @param equipe
     * @return {@code ArrayList} contendo os jogos daquela equipe.
     */

    private ArrayList<Jogo> buscarJogosEquipe(String equipe) {
        int numJogos = jogos.size(); // quantidade de jogos registrados na tabela
        ArrayList<Jogo> result = new ArrayList<Jogo>();
        Jogo aux_jogo;

        for (int i = 0; i < numJogos; i++) {
            aux_jogo = jogos.get(i);
            // colocaria as 3 condições em variavies para reduzir o tamanho do if
            if (aux_jogo.getPlacar() != null && (aux_jogo.getEquipeA().getNome().compareTo(equipe) == 0
                    || aux_jogo.getEquipeB().getNome().compareTo(equipe) == 0)) {
                result.add(aux_jogo);
            }
        }

        return result;
    }

    /**
     * Calcula a quantidade de jogos em que a equipe venceu.
     * 
     * @param jogosEquipe
     * @param equipe
     * @return Um valor do tipo {@code inteiro}, com a quantidade de jogos ganhos.
     */

    private int vitoriasEquipe(ArrayList<Jogo> jogosEquipe, String equipe) {
        int result = 0;
        int numJogos = jogosEquipe.size();
        Jogo aux_jogo;

        // Percorreria o vetor com uma lambda como reduce 
        // e usaria um ternario para fazer a verificação
        // assim vc diminui o tambanho do codigo e aumenta 
        // a legibilidade
        for (int i = 0; i < numJogos; i++) {
            aux_jogo = jogosEquipe.get(i);

            int posEquipe = aux_jogo.qualEquipe(equipe);
            if (aux_jogo.getPlacar().vencedorDoJogo() == posEquipe) {
                result = result + 1;
            }
        }

        return result;
    }

    /**
     * Calcula a quantidade de jogos em que a equipe foi derrotada.
     * 
     * @param jogosEquipe
     * @param equipe
     * @return Um valor do tipo {@code inteiro}, com a quantidade de jogos perdidos.
     */

    private int derrotasEquipe(ArrayList<Jogo> jogosEquipe, String equipe) {
        int result = 0;
        int numJogos = jogosEquipe.size();
        Jogo aux_jogo;

        for (int i = 0; i < numJogos; i++) {
            aux_jogo = jogosEquipe.get(i);

            int posEquipe = aux_jogo.qualEquipe(equipe);
            if (aux_jogo.getPlacar().vencedorDoJogo() != posEquipe) {
                result = result + 1;
            }
        }

        return result;
    }

    /**
     * Calcula a quantidade de pontos que aquela equipe tem de acordo com os
     * resultados de seus jogos.
     * 
     * @param jogosEquipe
     * @param equipe
     * @return Um valor do tipo {@code int} que representa a soma dos pontos.
     */

    private int pontosEquipe(ArrayList<Jogo> jogosEquipe, String equipe) {
        return (vitoriasEquipe(jogosEquipe, equipe) * 2) + (derrotasEquipe(jogosEquipe, equipe));
    }

    /**
     * Calcula o total de pontos marcados a favor da equipe em todos os jogos
     * disputados.
     * 
     * @param jogosEquipe
     * @param equipe
     * @return Um valor do tipo {@code inteiro}, representando a soma dos pontos.
     */

    private int marcadosFavor(ArrayList<Jogo> jogosEquipe, String equipe) {
        int result = 0;
        int numJogos = jogosEquipe.size();
        Jogo aux_jogo;
        Placar aux_placar;
        int posEquipe = 3; // posicao da equipe no array que representa os pontos de um quarto especifico
                           // do jogo (a = 0 OU b = 1)

        for (int i = 0; i < numJogos; i++) {
            aux_jogo = jogosEquipe.get(i);
            aux_placar = aux_jogo.getPlacar();

            if (aux_jogo.qualEquipe(equipe) == 'A') {
                posEquipe = 0;
            } else if (aux_jogo.qualEquipe(equipe) == 'B') {
                posEquipe = 1;
            }

            result = result + aux_placar.totalPontos(posEquipe);
        }

        return result;
    }

    /**
     * Calcula o total de pontos sofridos pela equipe em todos os jogos disputados.
     * 
     * @param jogosEquipe
     * @param equipe
     * @return Um valor do tipo {@code inteiro}, representando a soma dos pontos.
     */

    private int marcadosContra(ArrayList<Jogo> jogosEquipe, String equipe) {
        int result = 0;
        int numJogos = jogosEquipe.size();
        Jogo aux_jogo;
        Placar aux_placar;
        int posEquipeContra = 3; // posicao da equipe no array que representa os pontos de um quarto especifico
                                 // do jogo (a = 0 OU b = 1)

        for (int i = 0; i < numJogos; i++) {
            aux_jogo = jogosEquipe.get(i);
            aux_placar = aux_jogo.getPlacar();

            if (aux_jogo.qualEquipe(equipe) == 'A') {
                posEquipeContra = 1;
            } else if (aux_jogo.qualEquipe(equipe) == 'B') {
                posEquipeContra = 0;
            }

            result = result + aux_placar.totalPontos(posEquipeContra);
        }

        return result;
    }

    /**
     * Calcula a diferença entre os pontos marcados a favor e os pontos marcados
     * contra a equipe em todos os seus jogos.
     * 
     * @param jogosEquipe
     * @param equipe
     * @return Um valor do tipo {@code inteiro} representando a subtração entre
     *         pontos marcados a favor e pontos marcados contra.
     */

    private int difMarcados(ArrayList<Jogo> jogosEquipe, String equipe) {
        return marcadosFavor(jogosEquipe, equipe) - marcadosContra(jogosEquipe, equipe);
    }

    /**
     * Ordena as equipes da que mais pontuou, para a que menos pontuou.
     * 
     * @param nomesEquipes
     * @return Retorna um array do tipo {@code String} com os nomes das equipes
     *         ordenados.
     */

    private String[] ordenarEquipes(String[] nomesEquipes) {
        String[] result = nomesEquipes;
        String aux_nomeEquipe;
        for (int i = 0; i < result.length; i++) {
            if (i != result.length - 1) {
                if (pontosEquipe(buscarJogosEquipe(result[i]),
                        result[i]) < pontosEquipe(buscarJogosEquipe(result[i + 1]), result[i + 1])) {
                    aux_nomeEquipe = result[i + 1];
                    result[i + 1] = result[i];
                    result[i] = aux_nomeEquipe;
                    i = 0;
                }
            }
        }

        return result;
    }

    public String formataNome(String nomeEquipe) {
        if (nomeEquipe.length() < 20) {
            int numChar = nomeEquipe.length();
            if (numChar % 2 == 0) {
                int space = (20 - numChar) / 2; 
                String espacos = " ".repeat(space); 
                String resultado = espacos + nomeEquipe + espacos;
                return resultado;
            }else{
                int space = (20 - numChar - 1) / 2; 
                String espacos = " ".repeat(space); 
                String resultado = espacos + nomeEquipe + espacos + " ";
                return resultado;
            }
        }
        
        return null;
    }

    /**
     * Gera a tabela de classificação do campeonato com todas as informações das
     * equipes.
     * 
     * @param nomesEquipes
     * @return Retorna uma {@code String} com a tabela completa.
     */

    public String gerar(String[] nomesEquipes) {
        String tabela = "|---------------------------------------------------------------------------------------------------------|\n| Posicao |                 Equipe                 |  PTS  |  J   |  V   |  D   |  MF   |  MC   |   DPTS  |\n|---------------------------------------------------------------------------------------------------------|";

        String[] equipesOrdenadas = ordenarEquipes(nomesEquipes);
        ArrayList<Jogo> aux_jogosEquipe;

        for (int i = 0; i < equipesOrdenadas.length; i++) {
            aux_jogosEquipe = buscarJogosEquipe(equipesOrdenadas[i]);

            tabela = tabela.concat("\n|    " + (i+1) + "    |          " + formataNome(equipesOrdenadas[i]) + "          |   "
                    + String.format("%02d", pontosEquipe(aux_jogosEquipe, equipesOrdenadas[i])) + "  |  "
                    + String.format("%02d", aux_jogosEquipe.size()) + "  |  "
                    + String.format("%02d", vitoriasEquipe(aux_jogosEquipe, equipesOrdenadas[i])) + "  |  "
                    + String.format("%02d", derrotasEquipe(aux_jogosEquipe, equipesOrdenadas[i])) + "  |  "
                    + String.format("%02d", marcadosFavor(aux_jogosEquipe, equipesOrdenadas[i])) + "  |  "
                    + String.format("%02d", marcadosContra(aux_jogosEquipe, equipesOrdenadas[i])) + "  |    "
                    + String.format("%02d", difMarcados(aux_jogosEquipe, equipesOrdenadas[i])) + "   |");
        }

        return tabela;
    }
}
