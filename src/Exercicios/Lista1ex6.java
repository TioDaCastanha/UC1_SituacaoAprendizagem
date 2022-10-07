package Exercicios;

import java.util.Scanner;

public class Lista1ex6 {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int num = 0;

        System.out.print("Digite um numero Inteiro: ");
        num = in.nextInt();

        System.out.printf("\nO Antecessor é o numero: %d\nO numero digitado foi: %d\nO Sucessor é o numero: %d", num-1, num, num+1);

    }
}
