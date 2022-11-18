package SituacaoAprendizagem;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SA06_AlanAlvesDaCruz_BubbleSort {

    static List<Integer> lista = new ArrayList<>();
    static Random random = new Random();

    public static void main(String[] args) {

        String opcao;

        //Estrutura de repetição para manter o programa persistente até que seja escolhida a opção para encerrar
        do {
            opcao = JOptionPane.showInputDialog
                    ("------ BUBBLE SORT ------\n" +
                            "Escolha uma opção abaixo: \n" +
                            "1 - Criar Lista -\n" +
                            "2 - Mostrar Lista -\n" +
                            "3 - Ordenar -\n" +
                            "4 - Encerrar -\n" +
                            "---------------------------------------");

            switch (opcao) {
                //Preenche Lista
                case "1":

                    preencherLista(random.nextInt(20));
                    break;

                //Exibe Lista
                case "2":
                    System.out.println(lista);
                    System.out.println();
                    break;

                //Ordena Lista
                case "3":
                    ordenarLista();
                    break;

                //Encerra o Programa
                case "4":
                    JOptionPane.showMessageDialog(null, "Encerrando Programa!!");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!!");
            }
        }while(!opcao.equalsIgnoreCase("4"));

    }

    //Procedimento para preencher lista com valores aleatórios
    public static void preencherLista(int size) {
        //Limpa Lista
        lista = new ArrayList<>();

        for (int i = 0; i < size; i++){
            lista.add(random.nextInt(101));
        }

        JOptionPane.showMessageDialog(null,"Lista Preenchida com Sucesso!!");
    }

    //Procedimento para ordenar valores BubbleSort
    public static void ordenarLista() {
        int troca;

        //Loop para verificar todas as posições
        for(int i = 0; i < lista.size(); i++) {

            //Loop para percorrer a lista e procurar o menor valor
            for (int k = 1; k < lista.size(); k++) {

                //Verifica se o valor na posição atual é menor que o da anterior
                if(lista.get(k - 1) > lista.get(k)){

                    //Efetua a troca do valor na posição atual da lista pelo anterior.
                    troca = lista.get(k - 1);
                    lista.set(k - 1, lista.get(k));
                    lista.set(k, troca);
                }
            }
        }

        JOptionPane.showMessageDialog(null,"Lista Ordenada com Sucesso!!");
    }
}
