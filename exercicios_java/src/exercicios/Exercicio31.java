package exercicios;

import java.util.Random;
import java.util.Scanner;

public class Exercicio31 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Jogo jogo = new Jogo(4, 4);

		jogo.iniciar();

		sc.close();
	}

	// ================= JOGO =================

	static class Jogo {

		private int linhas;
		private int colunas;

		private int[][] tabuleiro;
		private boolean[][] aberto;

		private int tentativas = 0;

		public Jogo(int linhas, int colunas) {

			this.linhas = linhas;
			this.colunas = colunas;

			tabuleiro = new int[linhas][colunas];
			aberto = new boolean[linhas][colunas];

			gerarPares();
		}

		// Cria os pares aleatoriamente
		private void gerarPares() {

			int total = linhas * colunas;
			int pares = total / 2;

			int[] valores = new int[total];

			int k = 0;

			for (int i = 1; i <= pares; i++) {
				valores[k++] = i;
				valores[k++] = i;
			}

			Utility.embaralhar(valores);

			int pos = 0;

			for (int i = 0; i < linhas; i++) {
				for (int j = 0; j < colunas; j++) {
					tabuleiro[i][j] = valores[pos++];
				}
			}
		}

		public void iniciar() {

			while (!jogoCompleto()) {

				mostrarTabuleiro();

				System.out.println("\nTentativas: " + tentativas);

				int l1 = Utility.lerIntervaloInt("Linha 1: ", 0, linhas - 1);
				int c1 = Utility.lerIntervaloInt("Coluna 1: ", 0, colunas - 1);

				int l2 = Utility.lerIntervaloInt("Linha 2: ", 0, linhas - 1);
				int c2 = Utility.lerIntervaloInt("Coluna 2: ", 0, colunas - 1);

				if (aberto[l1][c1] || aberto[l2][c2]) {
					System.out.println("=== POSICAO JA ABERTA ===");
					continue;
				}

				if (l1 == l2 && c1 == c2) {
					System.out.println("=== POSICAO REPETIDA ===");
					continue;
				}

				abrir(l1, c1);
				abrir(l2, c2);

				mostrarTabuleiro();

				tentativas++;

				if (tabuleiro[l1][c1] == tabuleiro[l2][c2]) {

					System.out.println("ACERTOU! =D");

				} else {

					System.out.println("ERROU =(");

					Utility.dormir(1500);

					fechar(l1, c1);
					fechar(l2, c2);
				}
			}

			System.out.println("\nPARABENS! VOCE GANHOU!");
			System.out.println("Tentativas: " + tentativas);
		}

		private void abrir(int l, int c) {
			aberto[l][c] = true;
		}

		private void fechar(int l, int c) {
			aberto[l][c] = false;
		}

		private boolean jogoCompleto() {

			for (int i = 0; i < linhas; i++) {
				for (int j = 0; j < colunas; j++) {

					if (!aberto[i][j]) {
						return false;
					}
				}
			}

			return true;
		}

		private void mostrarTabuleiro() {

			System.out.println("\n=== TABULEIRO ===");

			System.out.print("   ");

			for (int j = 0; j < colunas; j++) {
				System.out.print(j + "  ");
			}

			System.out.println();

			for (int i = 0; i < linhas; i++) {

				System.out.print(i + "  ");

				for (int j = 0; j < colunas; j++) {

					if (aberto[i][j]) {
						System.out.print(tabuleiro[i][j] + "  ");
					} else {
						System.out.print("*  ");
					}
				}

				System.out.println();
			}
		}
	}

	// ================= UTILITY =================

	static class Utility {

		private static Scanner sc = new Scanner(System.in);

		static int lerIntervaloInt(String msg, int min, int max) {

			while (true) {

				System.out.print(msg);

				try {

					int n = Integer.parseInt(sc.nextLine());

					if (n < min || n > max) {
						System.out.printf("Digite entre %d e %d%n", min, max);
					} else {
						return n;
					}

				} catch (Exception e) {
					System.out.println("Digite um numero valido");
				}
			}
		}

		static void dormir(long ms) {

			try {
				Thread.sleep(ms);
			} catch (InterruptedException e) {
			}
		}

		// Embaralha vetor
		static void embaralhar(int[] v) {

			Random r = new Random();

			for (int i = v.length - 1; i > 0; i--) {

				int j = r.nextInt(i + 1);

				int temp = v[i];
				v[i] = v[j];
				v[j] = temp;
			}
		}
	}
}
