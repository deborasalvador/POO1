package atividades;

import java.util.Scanner;

public class Sequencial08 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Quanto voce ganha por hora:");
		float num1=teclado.nextFloat();
		System.out.print("Quantas horas voce trabalha no mes:");
		float num2=teclado.nextFloat();
		System.out.println((num1*num2));
		teclado.close();
	}

}
