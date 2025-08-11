package atividades;

import java.util.Scanner;

public class Sequencial05 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Valor em metros para converter em centimetros:");
		float num1=teclado.nextFloat();
		System.out.println((num1*100));
		teclado.close();
	}

}
