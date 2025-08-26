package atividades;
import java.util.Scanner;
public class VetoreMatrizL2E11 {

	public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Insira as entradas, separando-as por ponto e vírgula(;): ");
        String[] vetorPalavra = entrada.nextLine().split(";");

        System.out.println("Palavras digitadas: ");
        for(String palavra : vetorPalavra){
            System.out.println(palavra);
        }

        entrada.close();
    }
}