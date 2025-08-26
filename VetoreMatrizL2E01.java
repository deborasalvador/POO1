package atividades;

import java.util.Scanner;

public class VetoreMatrizL2E01 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        final int TAM_VETOR = 5;

        int[] numeros = new int[TAM_VETOR];

        for(int contador = 0; contador < TAM_VETOR; contador++){
            System.out.print("Digite o " + (contador+1) + "° número do vetor: ");
            numeros[contador] = teclado.nextInt();
        }

        for(int n : numeros){
            System.out.println(n);
        }
    }
}