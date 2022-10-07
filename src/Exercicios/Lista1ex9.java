package Exercicios;

import java.util.Scanner;

public class Lista1ex9 {
    public static void main(String[] args){
        int  num = 0;

        Scanner in = new Scanner(System.in);

        System.out.println("------Tabuada------");
        System.out.println("");
        System.out.print("Informe um número: ");
        num = in.nextInt();

        /*
        System.out.println(num+ " x 1 = "+(num*1));
        System.out.println(num+ " x 2 = "+(num*2));
        System.out.println(num+ " x 3 = "+(num*3));
        System.out.println(num+ " x 4 = "+(num*4));
        System.out.println(num+ " x 5 = "+(num*5));
        System.out.println(num+ " x 6 = "+(num*6));
        System.out.println(num+ " x 7 = "+(num*7));
        System.out.println(num+ " x 8 = "+(num*8));
        System.out.println(num+ " x 9 = "+(num*9));
        System.out.println(num+ " x 10 = "+(num*10));
         */

        for (int i = 1; i <= 10; i++){
            System.out.printf("%d x %d = %d\n", num, i, num*i );
        }

    }
}
