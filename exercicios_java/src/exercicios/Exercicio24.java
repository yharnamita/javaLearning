package exercicios;

import java.util.Scanner;

public class Exercicio24 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = Utility.lerIntervaloInt(sc, "Digite o valor de N: ", 1, 100);

		Matriz matriz = new Matriz(n);

		System.out.println("\nDigite os valores da matriz:");

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {

				int valor = Utility.lerIntSeguro(sc, "Posicao [" + i + "][" + j + "]: ");

				matriz.setValor(i, j, valor);
			}
		}

		System.out.println("\nDiagonal principal:");
		matriz.mostrarDiagonal();

		System.out.println("\nQuantidade de negativos: " + matriz.contarNegativos());

		sc.close();
	}

	// ================= CLASSE MATRIZ =================

	static class Matriz {

		private int[][] dados;
		private int ordem;

		public Matriz(int ordem) {

			this.ordem = ordem;
			this.dados = new int[ordem][ordem];
		}

		public void setValor(int i, int j, int valor) {

			dados[i][j] = valor;
		}

		public void mostrarDiagonal() {

			for (int i = 0; i < ordem; i++) {

				System.out.print(dados[i][i] + " ");
			}

			System.out.println();
		}

		public int contarNegativos() {

			int cont = 0;

			for (int i = 0; i < ordem; i++) {

				for (int j = 0; j < ordem; j++) {

					if (dados[i][j] < 0) {
						cont++;
					}
				}
			}

			return cont;
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
