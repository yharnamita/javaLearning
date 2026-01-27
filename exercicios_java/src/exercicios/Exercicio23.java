package exercicios;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;

public class Exercicio23 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Funcionario> funcionarios = new ArrayList<>();

		int n = Utility.lerIntSeguro(sc, "Quantos funcionarios serao cadastrados? ");

		for (int i = 1; i <= n; i++) {

			System.out.println("\nFuncionario #" + i);

			int id;

			while (true) {
				id = Utility.lerIntSeguro(sc, "ID: ");

				if (existeId(funcionarios, id)) {
					System.out.println("=== ID JA EXISTE. DIGITE OUTRO ===");
				} else {
					break;
				}
			}

			String nome = Utility.lerNome(sc, "Nome: ");

			double salario = Utility.lerIntervaloDouble(sc, "Salario: ", 0.01, Double.MAX_VALUE);

			funcionarios.add(new Funcionario(id, nome, salario));
		}

		int idBusca = Utility.lerIntSeguro(sc, "\nDigite o ID do funcionario para aumento: ");

		Funcionario func = buscarFuncionario(funcionarios, idBusca);

		if (func == null) {

			System.out.println("=== ESTE ID NAO EXISTE ===");

		} else {

			double porcentagem = Utility.lerIntervaloDouble(sc, "Digite a porcentagem de aumento: ", 0.0, 100.0);

			func.aumentarSalario(porcentagem);
		}

		System.out.println("\n=== LISTA ATUALIZADA ===");

		for (Funcionario f : funcionarios) {
			System.out.println(f);
		}

		sc.close();
	}

	// ================= FUNCOES AUXILIARES =================

	static boolean existeId(List<Funcionario> lista, int id) {

		for (Funcionario f : lista) {
			if (f.getId() == id) {
				return true;
			}
		}

		return false;
	}

	static Funcionario buscarFuncionario(List<Funcionario> lista, int id) {

		for (Funcionario f : lista) {
			if (f.getId() == id) {
				return f;
			}
		}

		return null;
	}

	// ================= CLASSE FUNCIONARIO =================

	static class Funcionario {

		private int id;
		private String nome;
		private double salario;

		public Funcionario(int id, String nome, double salario) {

			this.id = id;
			this.nome = nome;
			this.salario = salario;
		}

		public int getId() {
			return id;
		}

		public double getSalario() {
			return salario;
		}

		// Encapsulamento: só aumenta por método
		public void aumentarSalario(double porcentagem) {

			salario += salario * porcentagem / 100.0;
		}

		@Override
		public String toString() {

			return id + ", " + nome + ", " + String.format("%.2f", salario);
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
