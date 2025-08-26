package atividades;
import java.util.Scanner;
import java.io.*;

public class VetoreMatrizL1E02 {
	 private static final int MAX_PRODUTOS = 10;
	    private static final int MAX_SUPERMERCADOS = 10;
	    private static final String ARQUIVO = "precos.txt";
	    private Scanner scanner = new Scanner(System.in);
	    
	    private double[][] precos;
	    private String[] nomesProdutos;
	    private String[] nomesSupermercados;
	    private int numProdutos = 0;
	    private int numSupermercados = 0;
	    
	    public VetoreMatrizL1E02() {
	        precos = new double[MAX_PRODUTOS][MAX_SUPERMERCADOS];
	        nomesProdutos = new String[MAX_PRODUTOS];
	        nomesSupermercados = new String[MAX_SUPERMERCADOS];
	    }
	    
	    private void configurarDimensoes() {
	        System.out.print("Número de produtos (1-" + MAX_PRODUTOS + "): ");
	        numProdutos = Math.min(scanner.nextInt(), MAX_PRODUTOS);
	        scanner.nextLine();
	        
	        System.out.print("Número de supermercados (1-" + MAX_SUPERMERCADOS + "): ");
	        numSupermercados = Math.min(scanner.nextInt(), MAX_SUPERMERCADOS);
	        scanner.nextLine();
	    }
	    
	    private void definirNomes() {
	        System.out.println("\nNomes dos produtos:");
	        for (int i = 0; i < numProdutos; i++) {
	            System.out.print((i + 1) + ". ");
	            nomesProdutos[i] = scanner.nextLine();
	        }
	        
	        System.out.println("\nNomes dos supermercados:");
	        for (int i = 0; i < numSupermercados; i++) {
	            System.out.print((i + 1) + ". ");
	            nomesSupermercados[i] = scanner.nextLine();
	        }
	    }
	    
	    private void coletarPrecos() {
	        System.out.println("\nColeta de preços");
	        for (int p = 0; p < numProdutos; p++) {
	            System.out.println("\n" + nomesProdutos[p] + ":");
	            for (int s = 0; s < numSupermercados; s++) {
	                while (true) {
	                    System.out.print("  " + nomesSupermercados[s] + " (0 para pular): R$ ");
	                    double preco = scanner.nextDouble();
	                    if (preco >= 0) {
	                        precos[p][s] = preco;
	                        break;
	                    }
	                    System.out.println("Preço deve ser maior ou igual a zero.");
	                }
	            }
	        }
	    }
	    
	    private void exibirTabela() {
	        System.out.println("\nTabela de preços");
	        System.out.printf("%-15s", "Produto");
	        for (int s = 0; s < numSupermercados; s++) {
	            System.out.printf("%-15s", nomesSupermercados[s]);
	        }
	        System.out.println();
	        System.out.println("-".repeat(15 + numSupermercados * 15));
	        
	        for (int p = 0; p < numProdutos; p++) {
	            System.out.printf("%-15s", nomesProdutos[p]);
	            for (int s = 0; s < numSupermercados; s++) {
	                if (precos[p][s] > 0) {
	                    System.out.printf("R$ %-11.2f", precos[p][s]);
	                } else {
	                    System.out.printf("%-15s", "N/A");
	                }
	            }
	            System.out.println();
	        }
	    }
	    
	    private void calcularEstatisticas() {
	        System.out.println("\nMédia de preços por produto:");
	        for (int p = 0; p < numProdutos; p++) {
	            double soma = 0;
	            int count = 0;
	            for (int s = 0; s < numSupermercados; s++) {
	                if (precos[p][s] > 0) {
	                    soma += precos[p][s];
	                    count++;
	                }
	            }
	            if (count > 0) {
	                System.out.printf("%-15s R$ %.2f\n", nomesProdutos[p], soma / count);
	            }
	        }
	        
	        System.out.println("\nTotal por supermercado:");
	        double[] totais = new double[numSupermercados];
	        for (int s = 0; s < numSupermercados; s++) {
	            for (int p = 0; p < numProdutos; p++) {
	                totais[s] += precos[p][s];
	            }
	            System.out.printf("%-15s R$ %.2f\n", nomesSupermercados[s], totais[s]);
	        }
	        
	        // Encontrar mais barato e mais caro
	        int maisBarato = 0, maisCaro = 0;
	        for (int s = 1; s < numSupermercados; s++) {
	            if (totais[s] < totais[maisBarato] && totais[s] > 0) maisBarato = s;
	            if (totais[s] > totais[maisCaro]) maisCaro = s;
	        }
	        
	        if (totais[maisBarato] > 0) {
	            System.out.println("\nComparação:");
	            System.out.printf("Mais barato: %-15s R$ %.2f\n", nomesSupermercados[maisBarato], totais[maisBarato]);
	            System.out.printf("Mais caro:   %-15s R$ %.2f\n", nomesSupermercados[maisCaro], totais[maisCaro]);
	            System.out.printf("Diferença:   R$ %.2f\n", totais[maisCaro] - totais[maisBarato]);
	        }
	    }
	    
	    private void salvarDados() {
	        try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO))) {
	            writer.println(numProdutos + "," + numSupermercados);
	            
	            writer.print("PRODUTOS,");
	            for (int p = 0; p < numProdutos; p++) {
	                writer.print(nomesProdutos[p]);
	                if (p < numProdutos - 1) writer.print(",");
	            }
	            writer.println();
	            
	            writer.print("SUPERMERCADOS,");
	            for (int s = 0; s < numSupermercados; s++) {
	                writer.print(nomesSupermercados[s]);
	                if (s < numSupermercados - 1) writer.print(",");
	            }
	            writer.println();
	            
	            for (int p = 0; p < numProdutos; p++) {
	                for (int s = 0; s < numSupermercados; s++) {
	                    writer.print(precos[p][s]);
	                    if (s < numSupermercados - 1) writer.print(",");
	                }
	                writer.println();
	            }
	            System.out.println("\nDados salvos com sucesso!");
	        } catch (IOException e) {
	            System.err.println("Erro ao salvar: " + e.getMessage());
	        }
	    }
	    
	    private boolean carregarDados() {
	        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
	            String[] dimensoes = reader.readLine().split(",");
	            numProdutos = Integer.parseInt(dimensoes[0]);
	            numSupermercados = Integer.parseInt(dimensoes[1]);
	            
	            String[] produtos = reader.readLine().split(",");
	            for (int p = 1; p < produtos.length && p <= numProdutos; p++) {
	                nomesProdutos[p-1] = produtos[p];
	            }
	            
	            String[] supermercados = reader.readLine().split(",");
	            for (int s = 1; s < supermercados.length && s <= numSupermercados; s++) {
	                nomesSupermercados[s-1] = supermercados[s];
	            }
	            
	            for (int p = 0; p < numProdutos; p++) {
	                String[] linha = reader.readLine().split(",");
	                for (int s = 0; s < numSupermercados && s < linha.length; s++) {
	                    precos[p][s] = Double.parseDouble(linha[s]);
	                }
	            }
	            
	            System.out.println("Dados carregados com sucesso!");
	            return true;
	        } catch (Exception e) {
	            System.out.println("Arquivo não encontrado ou inválido.");
	            return false;
	        }
	    }
	    
	    private void menu() {
	        while (true) {
	            System.out.println("\n--- Sistema de Comparação de Preços ---");
	            System.out.println("1. Carregar dados existentes");
	            System.out.println("2. Inserir novos dados");
	            System.out.println("3. Exibir relatório");
	            System.out.println("4. Salvar dados");
	            System.out.println("0. Sair");
	            System.out.print("Opção: ");
	            
	            int opcao = scanner.nextInt();
	            scanner.nextLine();
	            
	            switch (opcao) {
	                case 1:
	                    carregarDados();
	                    break;
	                case 2:
	                    configurarDimensoes();
	                    definirNomes();
	                    coletarPrecos();
	                    break;
	                case 3:
	                    if (numProdutos > 0 && numSupermercados > 0) {
	                        exibirTabela();
	                        calcularEstatisticas();
	                    } else {
	                        System.out.println("Nenhum dado disponível.");
	                    }
	                    break;
	                case 4:
	                    if (numProdutos > 0 && numSupermercados > 0) {
	                        salvarDados();
	                    } else {
	                        System.out.println("Nenhum dado para salvar.");
	                    }
	                    break;
	                case 0:
	                    System.out.println("Saindo...");
	                    scanner.close();
	                    return;
	                default:
	                    System.out.println("Opção inválida.");
	            }
	        }
	    }
	    
	    public static void main(String[] args) {
	        new VetoreMatrizL1E02().menu();
	    }
	}