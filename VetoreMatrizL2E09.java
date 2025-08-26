package atividades;
import java.util.Scanner;
public class VetoreMatrizL2E09 {

	public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        System.out.print("Insira um texto: ");
        String texto = entrada.nextLine();

        String[] vetorTexto = texto.split("");
        for(String caractere : vetorTexto){
            System.out.printf("%s", caractere);
        }
    }
}