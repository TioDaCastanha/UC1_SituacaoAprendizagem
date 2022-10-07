package SituacaoAprendizagem;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class SA03_AlanAlvesDaCruz {
    public static void main(String[] args){

        //Lista para armazenar os nomes
        List<String> lista = new ArrayList<>();
        String nome, opcao;
        int idade;

        //Inicio do laço de repetição
        do {
            //Lista de opções do Cadastro de Usuários
            opcao = JOptionPane.showInputDialog("------- Cadastro Usuários -------" +
                "\nSelecione uma das opções a seguir:" +
                "\n1 - Cadastrar Novo Usuário" +
                "\n2 - Lista de Usuários Cadastrados" +
                "\n3 - Sair." +
                "\n-------------------------------------------\n");

            //Tratamento das opções
            switch (opcao){
                case "1":
                    nome = JOptionPane.showInputDialog("Informe o nome do Usuário:");
                    idade = Integer.parseInt(JOptionPane.showInputDialog("Informe a Idade do Usuário:"));
                    lista.add(nome);
                    break;

                case "2":
                    //Imprime os nomes e informa ao usuário
                    JOptionPane.showMessageDialog(null, lista);
                    break;

                case "3":
                    JOptionPane.showMessageDialog(null, "------ Programa Encerrado ------");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!! Por favor Selecione uma das Opções!!");
            }
          //Laço finaliza ao se digitar a opção 3
        } while (!opcao.equals("3"));
    }


}

