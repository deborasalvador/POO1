package atividades;

import java.util.Scanner;

public class EstruturasdeSeleção05 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Insira uma letra:");
		char letra = teclado.next().charAt(0);
		if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
		System.out.println("Vogal.");
		} else {
			System.out.println("Consoante.");
		}
		teclado.close();
	}

}