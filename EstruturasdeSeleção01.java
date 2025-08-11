package atividades;

import java.util.Scanner;

public class EstruturasdeSeleção01 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Insira dois numeros:");
		float num1=teclado.nextFloat();
		float num2=teclado.nextFloat();
		if (num1>num2) {
		System.out.println(num1);
		} else if (num2>num1) {
		System.out.println(num2);
		} else {
			System.out.println("Numeros iguais");
		}
		teclado.close();
	}

}
