package SituacaoAprendizagem;

import javax.swing.*;
import java.util.Arrays;
import java.util.Random;

public class SA06_AlanAlvesDaCruz_MergeSort {

    static Random random = new Random();

    public static void main(String[] args) {

        String opcao;
        int[] lista = new int[random.nextInt(21)];

        //Estrutura de repetição para manter o programa persistente até que seja escolhida a opção para encerrar
        do {
            opcao = JOptionPane.showInputDialog
                    ("------ MERGE SORT ------\n" +
                            "Escolha uma opção abaixo: \n" +
                            "1 - Criar Lista -\n" +
                            "2 - Mostrar Lista -\n" +
                            "3 - Ordenar -\n" +
                            "4 - Encerrar -\n" +
                            "---------------------------------------");

            switch (opcao) {
                //Preenche Lista
                case "1":

                    preencherLista(lista, lista.length);
                    break;

                //Exibe Lista
                case "2":

                    System.out.println(Arrays.toString(lista));
                    System.out.println();
                    break;

                //Ordena Lista
                case "3":

                    mergeSort(lista, 0, lista.length );
                    JOptionPane.showMessageDialog(null, "Lista Ordenada com Sucesso!!");
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

    static void mergeSort(int[] lista, int inicio, int fim){
        //verifica se tem elementos dentro do vetor
        if (inicio < fim - 1){
            //Guarda o meio do vetor
            int meio = (fim + inicio)/2;

            //chama recursivamente para valores do inicio até o meio
            mergeSort(lista, inicio, meio);

            //chama recursivamente para valores do meio até o fim
            mergeSort(lista, meio, fim);

            //Metodo para ordenar a lista
            ordenar(lista, inicio, meio, fim);
        }
    }

    static void ordenar (int[] lista, int inicio, int meio, int fim){
        int[] novaLista = new int [fim - inicio]; //lista auxiliar
        int indiceLeft = inicio;
        int indiceRight = meio;
        int cont = 0;

        //Estrutura para percorrer a lista enquanto ouver posições para serem verificadas em ambos os lados.
        while(indiceLeft < meio && indiceRight < fim){

            //Verifica qual valor vai ser ordenado
            if(lista[indiceLeft] <= lista[indiceRight]){
                novaLista[cont] = lista[indiceLeft];
                cont++;
                indiceLeft++;
            }else {
                novaLista[cont] = lista[indiceRight];
                cont++;
                indiceRight++;
            }
        }

        //Adiciona os valores que faltaram a lista auxiliar
        while (indiceLeft < meio) {
            novaLista[cont] = lista[indiceLeft];
            cont++;
            indiceLeft++;
        }


        while(indiceRight < fim){
            novaLista[cont] = lista[indiceRight];
            cont++;
            indiceRight++;
        }

        //Repetição para preencher a lista principal
        for(cont = 0, indiceLeft = inicio; indiceLeft < fim; indiceLeft++, cont++){
            lista[indiceLeft] = novaLista[cont];
        }

    }

    public static void preencherLista(int[] lista, int size) {

        for (int i = 0; i < size; i++){
            lista[i] = random.nextInt(101);
        }

        JOptionPane.showMessageDialog(null,"Lista Preenchida com Sucesso!!");
    }
}
