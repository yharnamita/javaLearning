package exercicios;

import java.util.Scanner;

public class Exercicio27 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Jogo jogo = new Jogo();

		char jogadorAtual = 'X';

		while (!jogo.terminou()) {

			jogo.mostrarTabuleiro();

			System.out.println("\nVez do jogador: " + jogadorAtual);

			int linha = Utility.lerIntervaloInt(sc, "Digite a linha (1 a 3): ", 1, 3) - 1;

			int coluna = Utility.lerIntervaloInt(sc, "Digite a coluna (1 a 3): ", 1, 3) - 1;

			if (jogo.jogar(linha, coluna, jogadorAtual)) {

				if (jogo.verificarVitoria(jogadorAtual)) {

					jogo.mostrarTabuleiro();
					System.out.println("\nJogador " + jogadorAtual + " VENCEU!");
					break;

				} else if (jogo.empate()) {

					jogo.mostrarTabuleiro();
					System.out.println("\nEMPATE!");
					break;
				}

				jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';

			} else {

				System.out.println("=== POSICAO INVALIDA ===");
			}
		}

		sc.close();
	}

	// ================= CLASSE JOGO =================

	static class Jogo {

		private char[][] tabuleiro;

		public Jogo() {

			tabuleiro = new char[3][3];

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					tabuleiro[i][j] = ' ';
				}
			}
		}

		public boolean jogar(int linha, int coluna, char jogador) {

			if (tabuleiro[linha][coluna] == ' ') {

				tabuleiro[linha][coluna] = jogador;
				return true;
			}

			return false;
		}

		public void mostrarTabuleiro() {

			System.out.println("\n  1   2   3");

			for (int i = 0; i < 3; i++) {

				System.out.print((i + 1) + " ");

				for (int j = 0; j < 3; j++) {

					System.out.print(tabuleiro[i][j]);

					if (j < 2)
						System.out.print(" | ");
				}

				System.out.println();

				if (i < 2) {
					System.out.println("  ---------");
				}
			}
		}

		public boolean verificarVitoria(char j) {

			for (int i = 0; i < 3; i++) {

				if (tabuleiro[i][0] == j && tabuleiro[i][1] == j && tabuleiro[i][2] == j) {

					return true;
				}
			}

			// Colunas
			for (int j2 = 0; j2 < 3; j2++) {

				if (tabuleiro[0][j2] == j && tabuleiro[1][j2] == j && tabuleiro[2][j2] == j) {

					return true;
				}
			}

			// Diagonal principal
			if (tabuleiro[0][0] == j && tabuleiro[1][1] == j && tabuleiro[2][2] == j) {

				return true;
			}

			// Diagonal secundaria
			if (tabuleiro[0][2] == j && tabuleiro[1][1] == j && tabuleiro[2][0] == j) {

				return true;
			}

			return false;
		}

		public boolean empate() {

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {

					if (tabuleiro[i][j] == ' ') {
						return false;
					}
				}
			}

			return true;
		}

		public boolean terminou() {

			return false; // controle é feito no main
		}
	}

	// ================= UTILITY =================

	static class Utility {

		static int lerIntSeguro(Scanner sc, String mensagem) {

			while (true) {

				String texto = evitarLinhaVazia(sc, mensagem);

				try {

					return Integer.parseInt(texto);

				} catch (NumberFormatException e) {

					System.out.println("=== APENAS NUMEROS INTEIROS ===");
				}
			}
		}

		static int lerIntervaloInt(Scanner sc, String mensagem, int min, int max) {

			while (true) {

				int valor = lerIntSeguro(sc, mensagem);

				if (valor < min || valor > max) {

					System.out.printf("=== DIGITE UM VALOR ENTRE %d E %d ===%n", min, max);

				} else {

					return valor;
				}
			}
		}

		static String evitarLinhaVazia(Scanner sc, String mensagem) {

			while (true) {

				System.out.print(mensagem);

				String texto = sc.nextLine().trim();

				if (texto.isEmpty()) {

					System.out.println("=== DIGITE ALGUMA COISA ====");
					continue;
				}

				return texto;
			}
		}
	}
}
