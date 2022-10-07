package Exercicios;

import javax.swing.*;

public class Lista1ex1 {
    public static void main(String[] args){

        int anos;
        int meses;
        int dias;
        int totalDias;

        JOptionPane.showMessageDialog(null,"Digite sua idade exata (Anos, meses e dias)!!");

        anos = Integer.parseInt(JOptionPane.showInputDialog("Quantos Anos?: "));
        meses = Integer.parseInt(JOptionPane.showInputDialog("Quantos Meses?: "));
        dias = Integer.parseInt(JOptionPane.showInputDialog("Quantos Dias?: "));

        totalDias = anos*365 + meses*30 + dias;

        JOptionPane.showMessageDialog(null, "Sua Idade Total em dias é de: "+ totalDias);

    }
}
