package Exercicios;

import javax.swing.*;

public class Lista1ex7 {
    public static void main(String[] args){

        float k, re, ra, f, c;

        c = Float.parseFloat(JOptionPane.showInputDialog("Informe Temperatura em Celsius: "));

        //Conversão em Kelvin
        k = c + (float)273.15;
        //Conversão em Farenheit
        f = c * (float)1.8 + 32;
        //Conversão em Réaumur
        re = c * (float)0.8;
        //Conversão em Rankine
        ra = c * (float)1.8 + (float)(32 + 459.67);

        JOptionPane.showMessageDialog(null, String.format("---Conversão de Temperaturas---\n---Kelvin =    %.2f---\n---Farenheit = %.2f---\n---Réamur =    %.2f---\n---Rankine = %.2f---", k, f, re, ra));

    }
}
