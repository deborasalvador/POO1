package atividades;

import java.util.Scanner;

public class Sequencial06 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Valor do raio para a area do circulo:");
		float num1=teclado.nextFloat();
		System.out.println(((num1*num1)*3.14));
		teclado.close();
	}

}
