package atividades;

import java.util.Scanner;

public class EstruturasdeSeleção16 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Insira as duas notas do aluno:");
		float num1=teclado.nextFloat();
		float num2=teclado.nextFloat();
		if ((num1+num2)/2>=0 && (num1+num2)/2<=3) {
		System.out.println("Reprovado.");
		} else if ((num1+num2)/2>3 && (num1+num2)/2<=6.9) {
			System.out.println("Em Exame.");
		} else if ((num1+num2)/2>=7 && (num1+num2)/2<=10) {
			System.out.println("Aprovado.");
		} else {
			System.out.println("Insira valores validos");
		}
		teclado.close();
	}

}