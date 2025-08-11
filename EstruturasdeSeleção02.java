package atividades;

import java.util.Scanner;

public class EstruturasdeSeleção02 {

		public static void main(String[] args) {
			Scanner teclado = new Scanner(System.in);
			System.out.print("Insira um numero:");
			float num1=teclado.nextFloat();
			if (num1>0) {
			System.out.println("Positivo.");
			} else if (num1<0) {
			System.out.println("Negativo.");
			} else {
				System.out.println("Zero.");
			}
			teclado.close();
		}

	}
