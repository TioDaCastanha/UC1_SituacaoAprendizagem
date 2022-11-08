package SituacaoAprendizagem;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;


public class SA05_AlanAlvesDaCruz_Fila {

    static Queue<Integer> fila = new LinkedList<>();

    public static void main(String[] args){

        String opcao;

        //Estrutura de repetição para manter o programa persistente até que seja escolhida a opção para encerrar
        do {
            opcao = JOptionPane.showInputDialog
                    ("------ FILA DE VALORES ------\n" +
                            "Escolha uma opção abaixo: \n" +
                            "1 - Enfileirar Valor -\n" +
                            "2 - Desenfileirar Valor -\n" +
                            "3 - Mostrar Fila -\n" +
                            "4 - Limpar Fila -\n" +
                            "5 - Verificar se fila está Vazia -\n" +
                            "6 - Encerrar -\n" +
                            "---------------------------------------");

            switch (opcao) {
                //Adiciona o Valor informado a Fila
                case "1":
                    Enfileirar();
                    break;

                //Remove o Topo Fila e Mostra pro Usuário
                case "2":
                    //Faz a verificação para remover apenas se a Fila não estiver vazia
                    if(Vazia()){
                        JOptionPane.showMessageDialog(null, "A Fila está Vazia");
                    }else {
                        Desenfileirar();
                    }
                    break;

                //Lista elementos da Fila
                case "3":
                    Listar();
                    break;

                //Limpa a Fila
                case "4":
                    if(Vazia()){
                        JOptionPane.showMessageDialog(null, "A Fila ja está Vazia");
                    }else {
                        Limpar();
                    }
                    break;

                //Verifica se a Fila está Vazia
                case "5":
                    if(Vazia()){
                        JOptionPane.showMessageDialog(null, "A Fila está Vazia");
                    }else {
                        JOptionPane.showMessageDialog(null, "Fila Não está vazia");
                    }
                    break;

                //Encerra o Programa
                case "6":
                    JOptionPane.showMessageDialog(null, "Encerrando Programa!!");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!!");
            }
        }while(!opcao.equalsIgnoreCase("6"));

    }

    //Procedimento para Adicionar Itens na Fila
    public static void Enfileirar(){
        fila.add(Integer.parseInt(JOptionPane.showInputDialog("Informe o valor que deseja inserir na fila: ")));
    }

    //Procedimento para Remover Itens na Fila
    public static void Desenfileirar(){
        JOptionPane.showMessageDialog(null,"Valor " + fila.poll() + " Removido da fila");
    }

    //Procedimento para Listar Itens na Fila
    public static void Listar(){
        System.out.println("----------- FILA -----------");
        System.out.println(fila);
        System.out.println("----------------------------");
        System.out.println("\n");
    }

    //Procedimento para Limpar a fila
    public static void Limpar(){
        fila.clear();
        JOptionPane.showMessageDialog(null, "Fila Limpa Com Sucesso!!");
    }

    //Função para Verificar se fila está vazia
    public static boolean Vazia(){
        return fila.isEmpty();
    }
}
