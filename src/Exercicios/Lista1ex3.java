package Exercicios;

import javax.swing.*;

public class Lista1ex3 {
    public static void main(String[] args){

        float saldo = Float.parseFloat(JOptionPane.showInputDialog("Digite seu Saldo: "));
        float reajuste = saldo+(saldo*((float)1/100));

        JOptionPane.showMessageDialog(null,"Seu Saldo com Reajuste é: "+ reajuste+ "R$");
        System.out.println(reajuste);

    }
}
