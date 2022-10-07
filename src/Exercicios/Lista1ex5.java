package Exercicios;

import java.util.Scanner;

public class Lista1ex5 {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        double salMin = 0;
        double salUser = 0;

        // Println Pula uma linha
        System.out.println("Digite o valor do Salário Minimo Atual: ");
        salMin = Double.parseDouble(in.nextLine());

        // Print Fica na mesma linha
        System.out.print("Digite o valor do seu Salário: ");
        salUser = in.nextDouble();


        // Printf permite formatar o texto adicionando primeiro as condições (escapes) e depois os argumentos em ordem)
        System.out.printf("\nVocê recebe %.2f Salários minimos", (salUser/salMin));


        //Nota: Quando usado in.nextLine() o input de double não pode ter ","
        //Nota2: Quando usado in.nextDouble() o input de double não pode ter "."

    }
}
