package atividades;

import java.util.Scanner;

public class VetoreMatrizL2E02 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);

        final int TAM_VETOR = 10;
        double[] vetor = new double[TAM_VETOR];

        for(int contador = 0; contador < TAM_VETOR; contador++){
            System.out.print("Digite o " + (contador+1) + "° número: ");
            vetor[contador] = teclado.nextDouble();
        }

        for(int contador = TAM_VETOR-1; contador >= 0; contador--){
            System.out.println(vetor[contador]);
        }

    }
}