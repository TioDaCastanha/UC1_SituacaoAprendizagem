package SituacaoAprendizagem;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class SA04_AlanAlvesDaCruz {
    public static void main(String[] args){

        //Lista para armazenar os nomes
        List<String> lista = new ArrayList<>();
        List<Integer> listaIdade = new ArrayList<>();
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
                "\n4 - Sair." +
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
                    System.out.println(buscar(lista));
                    pulaLinha();

                    break;

                //Encerrar Programa
                case "4":
                    JOptionPane.showMessageDialog(null, "------ Programa Encerrado ------");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!! Por favor Selecione uma das Opções!!");
            }

          //Laço finaliza ao se digitar a opção 3
        } while (!opcao.equals("4"));
    }


    //FUNÇÕES PARA A SA04 - ETAPAS 1 e 2


    //Função buscar nome
    public static String buscar(List<String> list){
        String nome = JOptionPane.showInputDialog("informe o nome que deseja buscar").toUpperCase();
        String concat = "";

        //Verifica se a lista contem o nome informado
            //Loop para percorrer lista
            for (int i = 0; i < list.size(); i++) {
                //Encontrado nome vai adicionar ao concatenador
                if (list.get(i).contains(nome)) {
                    concat += list.get(i) + " Encontrado na posição " + i + " da Lista.\n";
                }
            }

        //Verifica se o concatenador está vazio
        if(concat.isBlank()){
            //Se estiver vazio retorna que nome não foi encontrado
            concat += "Nome " + nome + " Não Encontrado!!\n------ Busca Encerrada ------";

        //Se não estiver adiciona o busca encerrada.
        } else {
            concat += "------ Busca Encerrada ------";
        }

        //Retorno do concatenador
        return concat;
    }

    //Adiciona espaços no console
    public static void pulaLinha(){
        System.out.println();
        System.out.println();
    }

}
