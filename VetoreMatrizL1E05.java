package atividades;
import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class VetoreMatrizL1E05 {
    private static Scanner teclado = new Scanner(System.in);
    private static Random rand = new Random();
    
    private static class Loteria {
        int[] numerosSorteados = new int[6];
        int[][] cartelas;
        int[] acertos;
        
        Loteria(int numCartelas) {
            cartelas = new int[numCartelas][6];
            acertos = new int[numCartelas];
        }
        
        void gerarNumeros(int[] numeros) {
            boolean[] usado = new boolean[61]; // 1 a 60
            for (int i = 0; i < 6; i++) {
                int num;
                do {
                    num = rand.nextInt(60) + 1;
                } while (usado[num]);
                usado[num] = true;
                numeros[i] = num;
            }
        }
        
        int contarAcertos(int[] cartela) {
            int count = 0;
            for (int numCartela : cartela) {
                for (int numSorteado : numerosSorteados) {
                    if (numCartela == numSorteado) {
                        count++;
                        break;
                    }
                }
            }
            return count;
        }
        
        void calcularAcertos() {
            for (int i = 0; i < cartelas.length; i++) {
                acertos[i] = contarAcertos(cartelas[i]);
            }
        }
    }

    public static void main(String[] args) {
        System.out.print("Quantas cartelas deseja: ");
        int numCartelas = teclado.nextInt();
        
        Loteria loteria = new Loteria(numCartelas);
        
        System.out.println("1 - Gerar cartelas  2 - Carregar arquivo");
        int opcao = teclado.nextInt();
        
        if (opcao == 2) {
            carregarDados(loteria);
        } else {
            loteria.gerarNumeros(loteria.numerosSorteados);
            for (int i = 0; i < numCartelas; i++) {
                loteria.gerarNumeros(loteria.cartelas[i]);
            }
        }
        
        loteria.calcularAcertos();
        exibirResultados(loteria);
        
        System.out.print("\nSalvar dados? (s/n): ");
        if (teclado.next().charAt(0) == 's') {
            salvarDados(loteria);
        }
        
        teclado.close();
    }
    
    private static void exibirResultados(Loteria loteria) {
        System.out.println("\n=== LOTERIA ===");
        System.out.print("Números sorteados: ");
        Arrays.sort(loteria.numerosSorteados);
        for (int num : loteria.numerosSorteados) {
            System.out.print(num + " ");
        }
        
        System.out.println("\n\nCartelas:");
        for (int i = 0; i < loteria.cartelas.length; i++) {
            Arrays.sort(loteria.cartelas[i]);
            System.out.printf("Cartela %d: ", i+1);
            for (int num : loteria.cartelas[i]) {
                System.out.print(num + " ");
            }
            System.out.println("- Acertos: " + loteria.acertos[i]);
        }
    }
    
    private static void salvarDados(Loteria loteria) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("loteria.txt"))) {
            pw.println(loteria.cartelas.length);
            
            // Números sorteados
            for (int i = 0; i < 6; i++) {
                pw.print(loteria.numerosSorteados[i] + (i < 5 ? ";" : "\n"));
            }
            
            // Cartelas
            for (int i = 0; i < loteria.cartelas.length; i++) {
                for (int j = 0; j < 6; j++) {
                    pw.print(loteria.cartelas[i][j] + (j < 5 ? ";" : ""));
                }
                pw.println(";" + loteria.acertos[i]);
            }
            
            System.out.println("Dados salvos em 'loteria.txt'");
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    private static void carregarDados(Loteria loteria) {
        try (Scanner arquivo = new Scanner(new File("loteria.txt"))) {
            int qtd = arquivo.nextInt();
            arquivo.nextLine();
            
            if (qtd != loteria.cartelas.length) {
                System.out.println("Quantidade incompatível. Gerando aleatoriamente...");
                gerarDadosAleatorios(loteria);
                return;
            }
            
            // Carregar sorteados
            String[] dadosSorteados = arquivo.nextLine().split(";");
            for (int i = 0; i < 6; i++) {
                loteria.numerosSorteados[i] = Integer.parseInt(dadosSorteados[i]);
            }
            
            // Carregar cartelas
            for (int i = 0; i < loteria.cartelas.length; i++) {
                String[] dados = arquivo.nextLine().split(";");
                for (int j = 0; j < 6; j++) {
                    loteria.cartelas[i][j] = Integer.parseInt(dados[j]);
                }
            }
            
            System.out.println("Dados carregados!");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Gerando aleatoriamente...");
            gerarDadosAleatorios(loteria);
        }
    }
    
    private static void gerarDadosAleatorios(Loteria loteria) {
        loteria.gerarNumeros(loteria.numerosSorteados);
        for (int i = 0; i < loteria.cartelas.length; i++) {
            loteria.gerarNumeros(loteria.cartelas[i]);
        }
    }
}