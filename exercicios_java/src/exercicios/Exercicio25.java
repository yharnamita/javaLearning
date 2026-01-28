package exercicios;

import java.util.Scanner;

public class Exercicio25 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int m = Utility.lerIntervaloInt(sc, "Digite o numero de linhas: ", 1, 100);
		int n = Utility.lerIntervaloInt(sc, "Digite o numero de colunas: ", 1, 100);

		Matriz matriz = new Matriz(m, n);

		System.out.println("\nDigite os valores da matriz:");

		for (int i = 0; i < m; i++) {

			for (int j = 0; j < n; j++) {

				int valor = Utility.lerIntSeguro(sc, "Posicao [" + i + "][" + j + "]: ");

				matriz.setValor(i, j, valor);
			}
		}

		int x = Utility.lerIntSeguro(sc, "\nDigite o valor X: ");

		System.out.println("\nOcorrencias de " + x + ":");

		matriz.mostrarVizinhos(x);

		sc.close();
	}

	// ================= CLASSE MATRIZ =================

	static class Matriz {

		private int[][] dados;
		private int linhas;
		private int colunas;

		public Matriz(int linhas, int colunas) {

			this.linhas = linhas;
			this.colunas = colunas;

			dados = new int[linhas][colunas];
		}

		public void setValor(int i, int j, int valor) {

			dados[i][j] = valor;
		}

		public void mostrarVizinhos(int x) {

			for (int i = 0; i < linhas; i++) {

				for (int j = 0; j < colunas; j++) {

					if (dados[i][j] == x) {

						System.out.println("\nPosicao " + i + "," + j + ":");

						// Esquerda
						if (j > 0) {
							System.out.println("Esquerda: " + dados[i][j - 1]);
						}

						// Cima
						if (i > 0) {
							System.out.println("Acima: " + dados[i - 1][j]);
						}

						// Direita
						if (j < colunas - 1) {
							System.out.println("Direita: " + dados[i][j + 1]);
						}

						// Baixo
						if (i < linhas - 1) {
							System.out.println("Abaixo: " + dados[i + 1][j]);
						}
					}
				}
			}
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

					System.out.printf("=== O VALOR DEVE ESTAR ENTRE %d E %d ===%n", min, max);

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
