package atividades;

import java.util.Scanner;

public class Sequencial02 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Informe um numero");
		float numF=teclado.nextFloat();
		System.out.print("O numero informado foi ["+numF+"].");
		teclado.close();
	}

}
