package exercicios;

import java.util.Random;
import java.util.Scanner;

public class Exercicio29{

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Jogo jogo = new Jogo(5, 3);

		jogo.iniciar();

		while (!jogo.terminou()) {

			jogo.mostrar();

			int linha = Utility.lerIntervaloInt(sc, "Linha (0 a 4): ", 0, 4);

			int coluna = Utility.lerIntervaloInt(sc, "Coluna (0 a 4): ", 0, 4);

			jogo.atacar(linha, coluna);
		}

		jogo.mostrar();

		System.out.println("\n=== VOCE VENCEU! ===");

		sc.close();
	}

	// ================= JOGO =================

	static class Jogo {

		private char[][] tabuleiro;
		private boolean[][] navios;

		private int restantes;
		private int tamanho;

		public Jogo(int tamanho, int naviosQtd) {

			this.tamanho = tamanho;

			tabuleiro = new char[tamanho][tamanho];
			navios = new boolean[tamanho][tamanho];

			restantes = naviosQtd;

			inicializar();
			sortearNavios(naviosQtd);
		}

		private void inicializar() {

			for (int i = 0; i < tamanho; i++) {
				for (int j = 0; j < tamanho; j++) {

					tabuleiro[i][j] = '~';
					navios[i][j] = false;
				}
			}
		}

		private void sortearNavios(int qtd) {

			Random r = new Random();

			int colocados = 0;

			while (colocados < qtd) {

				int l = r.nextInt(tamanho);
				int c = r.nextInt(tamanho);

				if (!navios[l][c]) {

					navios[l][c] = true;
					colocados++;
				}
			}
		}

		public void iniciar() {

			System.out.println("=== BATALHA NAVAL ===");
			System.out.println("Destrua " + restantes + " navios!\n");
		}

		public void mostrar() {

			System.out.println();

			System.out.print("  ");
			for (int i = 0; i < tamanho; i++) {
				System.out.print(i + " ");
			}

			System.out.println();

			for (int i = 0; i < tamanho; i++) {

				System.out.print(i + " ");

				for (int j = 0; j < tamanho; j++) {

					System.out.print(tabuleiro[i][j] + " ");
				}

				System.out.println();
			}
		}

		public void atacar(int l, int c) {

			if (tabuleiro[l][c] != '~') {

				System.out.println("=== JA ATACADO ===");
				return;
			}

			if (navios[l][c]) {

				System.out.println("ACERTOU!");
				tabuleiro[l][c] = 'X';
				restantes--;

			} else {

				System.out.println("AGUA!");
				tabuleiro[l][c] = 'O';
			}
		}

		public boolean terminou() {

			return restantes == 0;
		}
	}

	// ================= UTILITY =================

	static class Utility {

		static int lerIntervaloInt(Scanner sc, String msg, int min, int max) {

			while (true) {

				System.out.print(msg);

				try {

					int v = Integer.parseInt(sc.nextLine());

					if (v < min || v > max) {

						System.out.println("Valor invalido.");
					} else {

						return v;
					}

				} catch (Exception e) {

					System.out.println("Digite um numero.");
				}
			}
		}
	}
}
