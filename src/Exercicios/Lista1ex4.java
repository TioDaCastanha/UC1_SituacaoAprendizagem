package Exercicios;

import java.util.Scanner; //Biblioteca Scanner (leitor dados)

public class Lista1ex4 {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in); //Inicializando leitor dados

        int ipi = 0;
        String codigo1 = "";
        float valor1 = 0;
        int quantidade1 = 0;
        String codigo2 = "";
        float valor2 = 0;
        int quantidade2 = 0;
        float total = 0;

        System.out.println("Digite a Porcentagem do IPI: ");
        ipi = Integer.parseInt(in.nextLine());
        System.out.println("Digite o Código do Produto 1: ");
        codigo1 = in.nextLine();
        System.out.println("Digite o Código do produto 2: ");
        codigo2 = in.nextLine();
        System.out.println("Digite o valor do "+ codigo1+": ");
        valor1 = Float.parseFloat(in.nextLine());
        System.out.println("Digite a quatidade do "+ codigo1+": ");
        quantidade1 = Integer.parseInt(in.nextLine());
        System.out.println("Digite o valor do "+ codigo2+": ");
        valor2 = Float.parseFloat(in.nextLine());
        System.out.println("Digite a quantidade do "+ codigo2+": ");
        quantidade2 = Integer.parseInt(in.nextLine());

        total = (valor1*quantidade1 + valor2*quantidade2)*((float) ipi/100 +1);

        System.out.printf("Valor a ser pago será de: %.2f", total);


    }
}
