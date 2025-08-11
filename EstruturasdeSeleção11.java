package atividades;

import java.util.Scanner;

public class EstruturasdeSeleção11 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Em qual turno você estuda?[M-Matutino, V-Vespertino, N-Noturno]:");
		char letra = teclado.next().charAt(0);
		if (letra == 'M' || letra == 'm') {
		System.out.println("Bom Dia.");
		} else if (letra == 'V' || letra == 'v') {
		System.out.println("Boa Tarde.");
		} else if (letra == 'N' || letra == 'n') {
			System.out.println("Boa Noite.");
		} else {
			System.out.println("Letras inserida diferentes de M,V e N.");
		}
		teclado.close();
	}

}	