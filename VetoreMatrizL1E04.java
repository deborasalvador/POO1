package atividades;
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class VetoreMatrizL1E04 {
    private static Scanner teclado = new Scanner(System.in);
    
    private static class Atleta {
        String nome;
        double[] saltos = new double[5];
        double media;
        
        Atleta(String nome, double[] saltos) {
            this.nome = nome;
            this.saltos = saltos.clone();
            this.media = calcularMedia();
        }
        
        private double calcularMedia() {
            double[] temp = saltos.clone();
            Arrays.sort(temp);
            double soma = 0;
            for (int i = 1; i < 5; i++) { // Remove menor salto
                soma += temp[i];
            }
            return soma / 4;
        }
    }
    
    public static void main(String[] args) {
        System.out.print("Número de atletas: ");
        int n = teclado.nextInt();
        teclado.nextLine();
        
        Atleta[] atletas = new Atleta[n];
        
        System.out.println("1 - Digitar dados  2 - Carregar arquivo");
        int opcao = teclado.nextInt();
        teclado.nextLine();
        
        if (opcao == 2) {
            carregarDados(atletas, n);
        } else {
            digitarDados(atletas, n);
        }
        
        int[] posicoes = encontrarCampeaoEUltimo(atletas);
        exibirResultados(atletas, posicoes[0], posicoes[1]);
        
        System.out.print("\nSalvar dados? (s/n): ");
        if (teclado.next().charAt(0) == 's') {
            salvarDados(atletas, posicoes[0], posicoes[1]);
        }
        
        teclado.close();
    }
    
    private static void digitarDados(Atleta[] atletas, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("\nNome do atleta " + (i+1) + ": ");
            String nome = teclado.nextLine();
            
            double[] saltos = new double[5];
            for (int j = 0; j < 5; j++) {
                System.out.print("Salto " + (j+1) + " (metros): ");
                saltos[j] = teclado.nextDouble();
            }
            teclado.nextLine();
            
            atletas[i] = new Atleta(nome, saltos);
            System.out.printf("Média: %.2f metros\n", atletas[i].media);
        }
    }
    
    private static int[] encontrarCampeaoEUltimo(Atleta[] atletas) {
        int campeao = 0, ultimo = 0;
        for (int i = 1; i < atletas.length; i++) {
            if (atletas[i].media > atletas[campeao].media) campeao = i;
            if (atletas[i].media < atletas[ultimo].media) ultimo = i;
        }
        return new int[]{campeao, ultimo};
    }
    
    private static void exibirResultados(Atleta[] atletas, int campeao, int ultimo) {
        System.out.println("\n=== RESULTADOS OLIMPÍADAS IFC ===");
        
        for (Atleta atleta : atletas) {
            System.out.printf("\n%s:", atleta.nome);
            for (double salto : atleta.saltos) {
                System.out.printf(" %.2f", salto);
            }
            System.out.printf(" | Média: %.2f metros", atleta.media);
        }
        
        System.out.printf("\n\nCampeão: %s - %.2f metros\n", 
                         atletas[campeao].nome, atletas[campeao].media);
        System.out.printf("Último lugar: %s - %.2f metros\n", 
                         atletas[ultimo].nome, atletas[ultimo].media);
    }
    
    private static void salvarDados(Atleta[] atletas, int campeao, int ultimo) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("saltos.txt"))) {
            pw.println(atletas.length);
            
            for (Atleta atleta : atletas) {
                pw.print(atleta.nome + ";");
                for (int i = 0; i < 5; i++) {
                    pw.print(atleta.saltos[i] + (i < 4 ? ";" : ""));
                }
                pw.println();
            }
            
            pw.println("RESULTADOS:");
            pw.printf("Campeao: %s - %.2f metros\n", 
                     atletas[campeao].nome, atletas[campeao].media);
            pw.printf("Ultimo: %s - %.2f metros\n", 
                     atletas[ultimo].nome, atletas[ultimo].media);
            
            System.out.println("Dados salvos em 'saltos.txt'");
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    private static void carregarDados(Atleta[] atletas, int n) {
        try (Scanner arquivo = new Scanner(new File("saltos.txt"))) {
            int qtd = arquivo.nextInt();
            arquivo.nextLine();
            
            if (qtd != n) {
                System.out.println("Quantidade incompatível. Digite os dados:");
                digitarDados(atletas, n);
                return;
            }
            
            for (int i = 0; i < n; i++) {
                String[] dados = arquivo.nextLine().split(";");
                String nome = dados[0];
                double[] saltos = new double[5];
                for (int j = 0; j < 5; j++) {
                    saltos[j] = Double.parseDouble(dados[j+1]);
                }
                atletas[i] = new Atleta(nome, saltos);
            }
            
            System.out.println("Dados carregados!");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Digite os dados:");
            digitarDados(atletas, n);
        }
    }
}