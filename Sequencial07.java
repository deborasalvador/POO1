package atividades;

import java.util.Scanner;

public class Sequencial07 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Valor do lado para a area do quadrado:");
		float num1=teclado.nextFloat();
		System.out.println((num1*num1));
		teclado.close();
	}

}
