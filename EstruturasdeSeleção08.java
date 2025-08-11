package atividades;

import java.util.Scanner;

public class EstruturasdeSeleção08 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Insira as duas notas do aluno:");
		float num1=teclado.nextFloat();
		float num2=teclado.nextFloat();
		if ((num1+num2)/2>=7) {
		System.out.println("Aprovado.");
		} else {
			System.out.println("Reprovado");
		}
		teclado.close();
	}

}