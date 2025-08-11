package atividades;

import java.util.Scanner;

public class EstruturasdeSeleção17 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Insira as duas notas do aluno:");
		float num1=teclado.nextFloat();
		float num2=teclado.nextFloat();
		float media=(num1+num2)/2;
		if (media>9 && media<=10) {
		System.out.println("1ªNota:"+num1+" 2ªNota:"+num2+" Media:"+media+" *A* APROVADO.");
		} else if (media>7.5 && media<=9) {
			System.out.println("1ªNota:"+num1+" 2ªNota:"+num2+" Media:"+media+" *B* APROVADO.");
		} else if (media>6 && media<=7.5) {
			System.out.println("1ªNota:"+num1+" 2ªNota:"+num2+" Media:"+media+" *C* APROVADO.");
		} else if (media>4 && media<=6) {
			System.out.println("1ªNota:"+num1+" 2ªNota:"+num2+" Media:"+media+" *D* REPROVADO.");
		}else if (media>=0 && media<=4) {
			System.out.println("1ªNota:"+num1+" 2ªNota:"+num2+" Media:"+media+" *E* REPROVADO.");
		} else {
			System.out.println("Insira valores validos");
		}
		teclado.close();
	}

}