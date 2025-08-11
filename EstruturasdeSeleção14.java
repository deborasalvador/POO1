package atividades;

import java.util.Scanner;

public class EstruturasdeSeleção14 {

		public static void main(String[] args) {
			Scanner teclado = new Scanner(System.in);
			System.out.print("Insira um numero:");
			int num1=teclado.nextInt();
			if (num1==7) {
			System.out.println("Sabado.");
			} else if (num1==1) {
			System.out.println("Domingo.");
			} else if (num1==2) {
			System.out.println("Segunda-Feira.");
			} else if (num1==3) {
			System.out.println("Terca-Feira.");
			} else if (num1==4) {
			System.out.println("Quarta-Feira.");
			} else if (num1==5) {
			System.out.println("Quinta-Feira.");
			} else if (num1==6) {
			System.out.println("Sexta-Feira.");
			} else {
				System.out.println("Valor invalido.");
			}
			teclado.close();
		}

	}
