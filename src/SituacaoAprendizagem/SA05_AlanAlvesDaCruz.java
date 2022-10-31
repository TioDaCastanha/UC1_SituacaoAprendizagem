package SituacaoAprendizagem;

import javax.swing.*;
import java.util.Stack;

public class SA05_AlanAlvesDaCruz {

    static Stack<Integer> pilha = new Stack<>();

    public static void main(String[] args){

        String opcao;

        //Estrutura de repetição para manter o programa persistente até que seja escolhida a opção para encerrar
        do {
            opcao = JOptionPane.showInputDialog
                    ("------ PILHA DE VALORES ------\n" +
                     "Escolha uma opção abaixo: \n" +
                     "1 - Empilhar Valor -\n" +
                     "2 - Desempilhar Valor -\n" +
                     "3 - Mostrar Pilha -\n" +
                     "4 - Limpar Pilha -\n" +
                     "5 - Verificar se pilha está Vazia -\n" +
                     "6 - Encerrar -\n" +
                     "---------------------------------------");

            switch (opcao) {
                //Adiciona o Valor informado a Pilha
                case "1":
                    Empilhar();
                    break;

                //Remove o Topo Pilha e Mostra pro Usuário
                case "2":
                    //Faz a verificação para remover apenas se a pilha não estiver vazia
                    if(Vazia()){
                        JOptionPane.showMessageDialog(null, "A Pilha está Vazia");
                    }else {
                        Desempilhar();
                    }
                    break;

                //Lista elementos da lista
                case "3":
                    Listar();
                    break;

                //Limpa a Lista
                case "4":
                    if(Vazia()){
                        JOptionPane.showMessageDialog(null, "A Pilha ja está Vazia");
                    }else {
                        Limpar();
                    }
                    break;

                //Verifica se a Lista está Vazia
                case "5":
                    if(Vazia()){
                        JOptionPane.showMessageDialog(null, "A Pilha está Vazia");
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

    //Procedimento para Adicionar Itens na Pilha
    public static void Empilhar(){
        pilha.push(Integer.parseInt(JOptionPane.showInputDialog("Informe o valor que deseja inserir na pilha: ")));
    }

    //Procedimento para Remover Itens na Pilha
    public static void Desempilhar(){
        JOptionPane.showMessageDialog(null,"Valor " + pilha.pop() + " Removido da pilha");
    }

    //Procedimento para Listar Itens na Pilha
    public static void Listar(){
        System.out.println("--PILHA--");
        for(int i = pilha.size() - 1; i > 0 ; i--){
            System.out.println("| "+ pilha.get(i) +" |");
        }
        System.out.println("--------");
    }

    //Procedimento para Limpar a Pilha
    public static void Limpar(){
        pilha.clear();
        JOptionPane.showMessageDialog(null, "Pilha Limpa Com Sucesso!!");
    }

    //Função para Verificar se pilha está vazia
    public static boolean Vazia(){
        return pilha.isEmpty();
    }
}
