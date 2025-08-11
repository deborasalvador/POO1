package atividades;

import java.util.Scanner;

public class Sequencial04 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Informe as 4 notas bimestrais:");
		float num1=teclado.nextFloat();
		float num2=teclado.nextFloat();
		float num3=teclado.nextFloat();
		float num4=teclado.nextFloat();
		System.out.println(((num1+num2+num3+num4)/4));
		teclado.close();
	}

}
