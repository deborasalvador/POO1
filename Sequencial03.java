package atividades;

import java.util.Scanner;

public class Sequencial03 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Informe dois numeros:");
		float num1=teclado.nextFloat();
		float num2=teclado.nextFloat();
		System.out.println((num1+num2));
		teclado.close();
	}

}
