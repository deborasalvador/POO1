package atividades;

import java.util.Scanner;

public class EstruturasdeSeleção15 {

		public static void main(String[] args) {
			Scanner teclado = new Scanner(System.in);
			System.out.print("Insira o preço de custo do produto:");
			float num1=teclado.nextFloat();
			System.out.print("Insira o codigo de origem do produto:");
			int numc=teclado.nextInt();
			if (numc==1) {
			System.out.println("Preço: "+num1+" Origem: Sul.");
			} else if (numc==2) {
			System.out.println("Preço: "+num1+" Origem: Norte.");
			} else if (numc==3) {
			System.out.println("Preço: "+num1+" Origem: Leste.");
			} else if (numc==4) {
			System.out.println("Preço: "+num1+" Origem: Oeste.");
			} else if (numc==5 || numc==6) {
			System.out.println("Preço: "+num1+" Origem: Nordeste.");
			} else if (numc==8) {
			System.out.println("Preço: "+num1+" Origem: Centro-Oeste.");
			} else {
				System.out.println("Preço: "+num1+" Origem: Produto Importado.");
			}
			teclado.close();
		}

	}
