package atividades;

import java.util.Scanner;

public class EstruturasdeSeleção06 {

		public static void main(String[] args) {
			Scanner teclado = new Scanner(System.in);
			System.out.print("Insira um numero:");
			int num1=teclado.nextInt();
			if (num1%2==0) {
			System.out.println((num1-1));
			}  else {
				System.out.println((num1+1));
			}
			teclado.close();
		}

	}