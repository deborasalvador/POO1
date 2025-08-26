package atividades;
import java.io.*;
import java.util.Scanner;

public class VetoreMatrizL1E03 {
    private static Scanner teclado = new Scanner(System.in);
    
    private static class Aluno {
        String nome;
        double nota1, nota2, media;
        
        Aluno(String nome, double nota1, double nota2) {
            this.nome = nome;
            this.nota1 = nota1;
            this.nota2 = nota2;
            this.media = (nota1 + nota2) / 2;
        }
    }
    
    public static void main(String[] args) {
        System.out.print("Número de alunos: ");
        int n = teclado.nextInt();
        teclado.nextLine();
        
        Aluno[] alunos = new Aluno[n];
        
        System.out.println("\nEscolha:");
        System.out.println("1 - Digitar dados");
        System.out.println("2 - Carregar arquivo");
        int opcao = teclado.nextInt();
        teclado.nextLine();
        
        if (opcao == 2) {
            carregarDados(alunos, n);
        } else {
            digitarDados(alunos, n);
        }
        
        Estatisticas stats = calcularEstatisticas(alunos);
        exibirRelatorio(alunos, stats);
        
        System.out.print("\nSalvar em arquivo? (s/n): ");
        if (teclado.next().toLowerCase().charAt(0) == 's') {
            salvarDados(alunos, stats);
        }
        
        teclado.close();
    }
    
    private static class Estatisticas {
        double maiorNota, menorNota, maiorMedia, menorMedia, mediaGeral;
        String alunoMaiorNota, alunoMenorNota, alunoMaiorMedia, alunoMenorMedia;
        
        Estatisticas(double maiorNota, double menorNota, double maiorMedia, double menorMedia,
                    double mediaGeral, String alunoMaiorNota, String alunoMenorNota,
                    String alunoMaiorMedia, String alunoMenorMedia) {
            this.maiorNota = maiorNota;
            this.menorNota = menorNota;
            this.maiorMedia = maiorMedia;
            this.menorMedia = menorMedia;
            this.mediaGeral = mediaGeral;
            this.alunoMaiorNota = alunoMaiorNota;
            this.alunoMenorNota = alunoMenorNota;
            this.alunoMaiorMedia = alunoMaiorMedia;
            this.alunoMenorMedia = alunoMenorMedia;
        }
    }
    
    private static void digitarDados(Aluno[] alunos, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("\nNome do aluno " + (i+1) + ": ");
            String nome = teclado.nextLine();
            System.out.print("Nota 1: ");
            double nota1 = teclado.nextDouble();
            System.out.print("Nota 2: ");
            double nota2 = teclado.nextDouble();
            teclado.nextLine();
            alunos[i] = new Aluno(nome, nota1, nota2);
        }
    }
    
    private static Estatisticas calcularEstatisticas(Aluno[] alunos) {
        int n = alunos.length;
        double maiorNota = alunos[0].nota1, menorNota = alunos[0].nota1;
        double maiorMedia = alunos[0].media, menorMedia = alunos[0].media;
        String alunoMaiorNota = alunos[0].nome, alunoMenorNota = alunos[0].nome;
        String alunoMaiorMedia = alunos[0].nome, alunoMenorMedia = alunos[0].nome;
        double somaMedias = 0;
        
        for (Aluno aluno : alunos) {
            somaMedias += aluno.media;
            
            // Verificar maior/menor nota
            if (aluno.nota1 > maiorNota) {
                maiorNota = aluno.nota1;
                alunoMaiorNota = aluno.nome;
            }
            if (aluno.nota2 > maiorNota) {
                maiorNota = aluno.nota2;
                alunoMaiorNota = aluno.nome;
            }
            if (aluno.nota1 < menorNota) {
                menorNota = aluno.nota1;
                alunoMenorNota = aluno.nome;
            }
            if (aluno.nota2 < menorNota) {
                menorNota = aluno.nota2;
                alunoMenorNota = aluno.nome;
            }
            
            // Verificar maior/menor média
            if (aluno.media > maiorMedia) {
                maiorMedia = aluno.media;
                alunoMaiorMedia = aluno.nome;
            }
            if (aluno.media < menorMedia) {
                menorMedia = aluno.media;
                alunoMenorMedia = aluno.nome;
            }
        }
        
        double mediaGeral = somaMedias / n;
        return new Estatisticas(maiorNota, menorNota, maiorMedia, menorMedia, mediaGeral,
                               alunoMaiorNota, alunoMenorNota, alunoMaiorMedia, alunoMenorMedia);
    }
    
    private static void exibirRelatorio(Aluno[] alunos, Estatisticas stats) {
        System.out.println("\n=== RELATÓRIO DE NOTAS ===");
        
        System.out.println("\nAlunos e Notas:");
        for (Aluno aluno : alunos) {
            System.out.printf("%s: %.1f - %.1f (Média: %.1f)\n", 
                aluno.nome, aluno.nota1, aluno.nota2, aluno.media);
        }
        
        System.out.printf("\nMaior nota: %.1f (%s)\n", stats.maiorNota, stats.alunoMaiorNota);
        System.out.printf("Menor nota: %.1f (%s)\n", stats.menorNota, stats.alunoMenorNota);
        System.out.printf("Maior média: %.1f (%s)\n", stats.maiorMedia, stats.alunoMaiorMedia);
        System.out.printf("Menor média: %.1f (%s)\n", stats.menorMedia, stats.alunoMenorMedia);
        System.out.printf("Média geral: %.1f\n", stats.mediaGeral);
        
        System.out.println("\nAcima da média geral:");
        for (Aluno aluno : alunos) {
            if (aluno.media > stats.mediaGeral) {
                System.out.printf("- %s (%.1f)\n", aluno.nome, aluno.media);
            }
        }
        
        System.out.println("\nAbaixo da média geral:");
        for (Aluno aluno : alunos) {
            if (aluno.media < stats.mediaGeral) {
                System.out.printf("- %s (%.1f)\n", aluno.nome, aluno.media);
            }
        }
    }
    
    private static void salvarDados(Aluno[] alunos, Estatisticas stats) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("notas.txt"))) {
            pw.println(alunos.length);
            
            for (Aluno aluno : alunos) {
                pw.printf("%s;%.1f;%.1f\n", aluno.nome, aluno.nota1, aluno.nota2);
            }
            
            pw.println("RELATORIO:");
            pw.printf("Media geral: %.1f\n", stats.mediaGeral);
            pw.printf("Maior nota: %.1f (%s)\n", stats.maiorNota, stats.alunoMaiorNota);
            pw.printf("Menor nota: %.1f (%s)\n", stats.menorNota, stats.alunoMenorNota);
            pw.printf("Maior media: %.1f (%s)\n", stats.maiorMedia, stats.alunoMaiorMedia);
            pw.printf("Menor media: %.1f (%s)\n", stats.menorMedia, stats.alunoMenorMedia);
            
            System.out.println("Dados salvos em 'notas.txt'");
        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }
    
    private static void carregarDados(Aluno[] alunos, int n) {
        try (Scanner arquivo = new Scanner(new File("notas.txt"))) {
            int qtdArquivo = arquivo.nextInt();
            arquivo.nextLine();
            
            if (qtdArquivo != n) {
                System.out.println("Quantidade incompatível. Digite os dados:");
                digitarDados(alunos, n);
                return;
            }
            
            for (int i = 0; i < n; i++) {
                String linha = arquivo.nextLine();
                String[] dados = linha.split(";");
                String nome = dados[0];
                double nota1 = Double.parseDouble(dados[1]);
                double nota2 = Double.parseDouble(dados[2]);
                alunos[i] = new Aluno(nome, nota1, nota2);
            }
            
            System.out.println("Dados carregados do arquivo!");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Digite os dados:");
            digitarDados(alunos, n);
        }
    }
}