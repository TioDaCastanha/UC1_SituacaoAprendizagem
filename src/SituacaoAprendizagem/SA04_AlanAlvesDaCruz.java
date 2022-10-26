package SituacaoAprendizagem;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;

public class SA04_AlanAlvesDaCruz {
    public static void main(String[] args){

        //Lista para armazenar os nomes
        List<String> lista = new ArrayList<>();
        List<Integer> listaIdade = new ArrayList<>();
        List<Integer> indexListBusca = new ArrayList<>();
        List<Integer> indexListExcluir = new ArrayList<>();
        String nome, opcao;
        int idade, controlador;

        //Inicio do laço de repetição
        do {
            //Lista de opções do Cadastro de Usuários
            opcao = JOptionPane.showInputDialog("------- Cadastro Usuários -------" +
                "\nSelecione uma das opções a seguir:" +
                "\n1 - Cadastrar Novo Usuário" +
                "\n2 - Lista de Usuários Cadastrados" +
                "\n3 - Buscar Usuário Cadastrado." +
                "\n4 - Excluir Usuário Cadastrado."+
                "\n5 - Sair." +
                "\n-------------------------------------------\n");

            //Tratamento das opções
            switch (opcao){

                //Cadastro Usuário
                case "1":

                    controlador = Integer.parseInt(JOptionPane.showInputDialog("Quantos usuários deseja Cadastrar?"));

                    for (int i =0; i < controlador; i++) {
                        nome = JOptionPane.showInputDialog("Informe o nome do Usuário:").toUpperCase();
                        idade = Integer.parseInt(JOptionPane.showInputDialog("Informe a Idade do Usuário:"));
                        lista.add(nome);
                        listaIdade.add(idade);
                    }
                    break;

                //Listar Usuários
                case "2":

                    System.out.println("------- Lista Usuários -------");
                    for (int i = 0; i < lista.size(); i++){
                        System.out.printf("%s --- %d Anos\n", lista.get(i), listaIdade.get(i));
                    }
                    System.out.print("------------------------------");

                    //Criar espaço entre as exibições da lista
                    pulaLinha();

                    break;

                //Buscar Usuários
                case "3":

                    System.out.println("------ Buscar Usuários ------");
                    indexListBusca = buscar(lista);
                    pulaLinha();

                    break;

                //Excluir Usuários
                case "4":

                    System.out.println("------ Excluir Usuários ------");
                    indexListExcluir = excluir(lista);

                    //Inicia a Remoção das posições escolhidas durante a função buscar
                    if (indexListExcluir.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nenhum Usuário Deletado!");

                    }else{
                        for(int i = 0; i < indexListExcluir.size(); i++){
                            lista.remove((int)indexListExcluir.get(i));
                            listaIdade.remove((int)indexListExcluir.get(i));
                        }
                        System.out.println("------ Excluir Encerrado ------");
                        JOptionPane.showMessageDialog(null, "Usuários Deletados com Sucesso!!");
                    }

                    pulaLinha();

                    break;

                //Encerrar Programa
                case "5":
                    JOptionPane.showMessageDialog(null, "------ Programa Encerrado ------");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!! Por favor Selecione uma das Opções!!");
            }

          //Laço finaliza ao se digitar a opção 3
        } while (!opcao.equals("5"));
    }


    //FUNÇÕES PARA A SA04 - ETAPAS 1 e 2


    //Função buscar nome
    public static List<Integer> buscar(List<String> list){
        String nome = JOptionPane.showInputDialog("informe o nome que deseja buscar").toUpperCase();
        List<Integer> indexList = new ArrayList<>();

        //Verifica se a lista contem o nome informado
        //Loop para percorrer lista
        for (int i = 0; i < list.size(); i++) {
            //Encontrado nome vai adicionar a lista de indice
            if (list.get(i).contains(nome)) {
                indexList.add(i);
                System.out.print(list.get(i) + " Encontrado na posição " + i + " da Lista.\n");
            }
        }

        //Verifica se a lista está vazia
        if(indexList.isEmpty()){
            //Se estiver vazio retorna que nome não foi encontrado
            System.out.print("Nome " + nome + " Não Encontrado!!");
            System.out.print("\n------ Busca Encerrada ------");

        }else{
            System.out.println("------ Busca Encerrada ------");

        }

        //Retorno da lista de indices
        return indexList;
    }


    //Função Excluir Usuário
    public static List<Integer> excluir(List<String> list){
        List<Integer> indexList = new ArrayList<>();
        List<Integer> buscaIndex;
        String resposta;
        int i = 0;

        //Utiliza a função buscar para exibir os usuários que se deseja excluir
        buscaIndex = buscar(list);

        resposta = JOptionPane.showInputDialog("Deseja excluir os Usuários Listados Sim/Não?").toLowerCase(Locale.ROOT);

        //Estrutura de repetição para iniciar a exclusão baseada na quantidade de posições retornada pelo buscar()
        do {
            switch(resposta){
                case "sim":

                    //Limita a quantidade de vezes que deseja excluir considerado o tamanho da busca
                    if(buscaIndex.size() > i){
                        indexList.add(Integer.parseInt(JOptionPane.showInputDialog("Informe a posição do Usuário que deseja excluir:")));
                        resposta = JOptionPane.showInputDialog("Deseja excluir mais algum usuário Sim/Não?").toLowerCase(Locale.ROOT);
                        i++;
                    } else {
                        JOptionPane.showMessageDialog(null,"Sem mais Opções!! Voltando ao Menu inicial.");
                        resposta = "nao";
                    }

                    break;

                case "não":
                    System.out.println("------ Excluir Encerrado ------");
                    break;

                case "nao":
                    System.out.println("------ Excluir Encerrado ------");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!! tente Novamente");
                    break;
            }

        //Laço finaliza ao digitar não
        }while(resposta.contains("sim"));

        return indexList;
    }

    //Adiciona espaços no console
    public static void pulaLinha(){
        System.out.println();
        System.out.println();
    }

}

