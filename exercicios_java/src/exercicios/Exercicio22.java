package exercicios;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Exercicio22 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Produto> produtos = new ArrayList<>();

		int n = Utility.lerIntSeguro(sc, "Quantos produtos deseja cadastrar? ");

		for (int i = 1; i <= n; i++) {

			System.out.println("\nProduto #" + i);

			int codigo;

			while (true) {

				codigo = Utility.lerIntSeguro(sc, "Codigo: ");

				if (existeCodigo(produtos, codigo)) {
					System.out.println("=== CODIGO JA EXISTE ===");
				} else {
					break;
				}
			}

			String nome = Utility.lerNome(sc, "Nome: ");

			double preco = Utility.lerIntervaloDouble(sc, "Preco: ", 0.01, Double.MAX_VALUE);

			produtos.add(new Produto(codigo, nome, preco));
		}

		double soma = 0;

		for (Produto p : produtos) {
			soma += p.getPreco();
		}

		double media = soma / produtos.size();

		System.out.println("\n=== LISTA DE PRODUTOS ===");

		for (Produto p : produtos) {
			System.out.println(p);
		}

		System.out.printf("\nPreco medio: %.2f\n", media);

		sc.close();
	}

	// ================= AUXILIAR =================

	static boolean existeCodigo(List<Produto> lista, int codigo) {

		for (Produto p : lista) {

			if (p.getCodigo() == codigo) {
				return true;
			}
		}

		return false;
	}

	// ================= CLASSE PRODUTO =================

	static class Produto {

		private int codigo;
		private String nome;
		private double preco;

		public Produto(int codigo, String nome, double preco) {

			this.codigo = codigo;
			this.nome = nome;
			this.preco = preco;
		}

		public int getCodigo() {
			return codigo;
		}

		public double getPreco() {
			return preco;
		}

		@Override
		public String toString() {

			return codigo + " - " + nome + " - R$ " + String.format("%.2f", preco);
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

		static double lerDoubleSeguro(Scanner sc, String mensagem) {

			while (true) {

				String texto = evitarLinhaVazia(sc, mensagem);

				try {
					return Double.parseDouble(texto);

				} catch (NumberFormatException e) {
					System.out.println("=== APENAS NUMEROS ===");
				}
			}
		}

		static double lerIntervaloDouble(Scanner sc, String mensagem, double min, double max) {

			while (true) {

				double valor = lerDoubleSeguro(sc, mensagem);

				if (valor < min || valor > max) {

					if (max == Double.MAX_VALUE) {

						System.out.printf("=== O VALOR DEVE SER MAIOR OU IGUAL A: %.2f ===%n", min);

					} else {

						System.out.printf("=== O VALOR DEVE ESTAR ENTRE %.2f E %.2f ===%n", min, max);
					}

				} else {

					return valor;
				}
			}
		}

		static String lerNome(Scanner sc, String mensagem) {

			while (true) {

				String nome = evitarLinhaVazia(sc, mensagem);

				if (nome.matches("[A-Za-zÀ-ÿ ']+")) {
					return nome;
				}

				System.out.println("=== O NOME NAO PODE CONTER NUMEROS OU SIMBOLOS ===");
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
