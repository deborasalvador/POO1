package atividades;
import java.util.Scanner;
import java.io.*;

public class VetoreMatrizL1E01 {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int tamanho = lerTamanhoValido();
        int[][] matriz = new int[tamanho][tamanho];
        
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Digitar valores manualmente");
        System.out.println("2 - Carregar de arquivo");
        int opcao = teclado.nextInt();
        
        if (opcao == 2) {
            carregarArquivo(matriz, tamanho);
        } else {
            preencherMatriz(matriz, tamanho);
        }
        
        Estatisticas stats = calcularEstatisticas(matriz, tamanho);
        exibirResultados(matriz, tamanho, stats);
        
        System.out.print("\nDeseja salvar em arquivo? (s/n): ");
        if (teclado.next().toLowerCase().charAt(0) == 's') {
            salvarArquivo(matriz, tamanho, stats);
        }
        
        teclado.close();
    }
    
    private static int lerTamanhoValido() {
        int tamanho;
        do {
            System.out.print("Digite um valor ímpar entre 3 e 11: ");
            tamanho = teclado.nextInt();
        } while (tamanho < 3 || tamanho > 11 || tamanho % 2 == 0);
        return tamanho;
    }
    
    private static void preencherMatriz(int[][] matriz, int tamanho) {
        System.out.println("Digite os valores da matriz:");
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.printf("Posição [%d][%d]: ", i, j);
                matriz[i][j] = teclado.nextInt();
            }
        }
    }
    
    private static class Estatisticas {
        int soma, maior, menor, pares, impares, diagPrincipal, diagSecundaria;
        double media;
        
        Estatisticas(int soma, int maior, int menor, int pares, int impares, 
                    int diagPrincipal, int diagSecundaria, double media) {
            this.soma = soma;
            this.maior = maior;
            this.menor = menor;
            this.pares = pares;
            this.impares = impares;
            this.diagPrincipal = diagPrincipal;
            this.diagSecundaria = diagSecundaria;
            this.media = media;
        }
    }
    
    private static Estatisticas calcularEstatisticas(int[][] matriz, int tamanho) {
        int soma = 0, maior = matriz[0][0], menor = matriz[0][0];
        int pares = 0, impares = 0, diagPrincipal = 0, diagSecundaria = 0;
        
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                int valor = matriz[i][j];
                soma += valor;
                
                if (valor > maior) maior = valor;
                if (valor < menor) menor = valor;
                if (valor % 2 == 0) pares++; else impares++;
                if (i == j) diagPrincipal += valor;
                if (i + j == tamanho - 1) diagSecundaria += valor;
            }
        }
        
        double media = (double) soma / (tamanho * tamanho);
        return new Estatisticas(soma, maior, menor, pares, impares, diagPrincipal, diagSecundaria, media);
    }
    
    private static void exibirResultados(int[][] matriz, int tamanho, Estatisticas stats) {
        System.out.println("\n=== RESULTADOS ===");
        System.out.println("Soma dos elementos: " + stats.soma);
        System.out.printf("Média: %.2f%n", stats.media);
        System.out.println("Maior valor: " + stats.maior);
        System.out.println("Menor valor: " + stats.menor);
        System.out.println("Números pares: " + stats.pares);
        System.out.println("Números ímpares: " + stats.impares);
        System.out.println("Soma diagonal principal: " + stats.diagPrincipal);
        System.out.println("Soma diagonal secundária: " + stats.diagSecundaria);
        
        System.out.println("\nMatriz:");
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.printf("%4d ", matriz[i][j]);
            }
            System.out.println();
        }
    }
    
    private static void salvarArquivo(int[][] matriz, int tamanho, Estatisticas stats) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("matriz.txt"))) {
            pw.println(tamanho);
            for (int i = 0; i < tamanho; i++) {
                for (int j = 0; j < tamanho; j++) {
                    pw.print(matriz[i][j] + " ");
                }
                pw.println();
            }
            pw.println("ESTATISTICAS:");
            pw.println("Soma: " + stats.soma);
            pw.printf("Media: %.2f%n", stats.media);
            pw.println("Maior: " + stats.maior);
            pw.println("Menor: " + stats.menor);
            pw.println("Pares: " + stats.pares);
            pw.println("Impares: " + stats.impares);
            pw.println("Diagonal principal: " + stats.diagPrincipal);
            pw.println("Diagonal secundaria: " + stats.diagSecundaria);
            System.out.println("Arquivo salvo como 'matriz.txt'");
        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }
    
    private static void carregarArquivo(int[][] matriz, int tamanho) {
        try (Scanner arquivo = new Scanner(new File("matriz.txt"))) {
            int tamanhoArquivo = arquivo.nextInt();
            if (tamanhoArquivo != tamanho) {
                System.out.println("Tamanho incompatível no arquivo. Digite os valores manualmente:");
                preencherMatriz(matriz, tamanho);
                return;
            }
            
            for (int i = 0; i < tamanho; i++) {
                for (int j = 0; j < tamanho; j++) {
                    matriz[i][j] = arquivo.nextInt();
                }
            }
            System.out.println("Matriz carregada do arquivo!");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Digite os valores manualmente:");
            preencherMatriz(matriz, tamanho);
        }
    }
}