package atividades;

import java.util.Scanner;

public class EstruturasdeSeleção03 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Insira uma letra:");
		char letra = teclado.next().charAt(0);
		if (letra == 'F' || letra == 'f') {
		System.out.println("Feminino.");
		} else if (letra == 'M' || letra == 'm') {
		System.out.println("Masculino.");
		} else {
			System.out.println("Letra inserida diferente de F e M");
		}
		teclado.close();
	}

}