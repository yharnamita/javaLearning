package exercicios;

import java.util.Scanner;

public class Exercicio26 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int alunos = Utility.lerIntervaloInt(sc, "Quantidade de alunos: ", 1, 50);
		int provas = Utility.lerIntervaloInt(sc, "Quantidade de provas: ", 1, 10);

		Turma turma = new Turma(alunos, provas);

		System.out.println("\nDigite as notas:");

		for (int i = 0; i < alunos; i++) {

			System.out.println("\nAluno " + (i + 1));

			for (int j = 0; j < provas; j++) {

				double nota = Utility.lerIntervaloDouble(sc, "Prova " + (j + 1) + ": ", 0.0, 10.0);

				turma.setNota(i, j, nota);
			}
		}

		System.out.println("\n=== MEDIAS DOS ALUNOS ===");
		turma.mostrarMediaAlunos();

		System.out.println("\n=== MEDIAS DAS PROVAS ===");
		turma.mostrarMediaProvas();

		turma.mostrarMelhorAluno();

		sc.close();
	}

	// ================= CLASSE TURMA =================

	static class Turma {

		private double[][] notas;
		private int alunos;
		private int provas;

		public Turma(int alunos, int provas) {

			this.alunos = alunos;
			this.provas = provas;

			notas = new double[alunos][provas];
		}

		public void setNota(int aluno, int prova, double nota) {

			notas[aluno][prova] = nota;
		}

		public void mostrarMediaAlunos() {

			for (int i = 0; i < alunos; i++) {

				double soma = 0;

				for (int j = 0; j < provas; j++) {

					soma += notas[i][j];
				}

				double media = soma / provas;

				System.out.printf("Aluno %d: %.2f%n", i + 1, media);
			}
		}

		public void mostrarMediaProvas() {

			for (int j = 0; j < provas; j++) {

				double soma = 0;

				for (int i = 0; i < alunos; i++) {

					soma += notas[i][j];
				}

				double media = soma / alunos;

				System.out.printf("Prova %d: %.2f%n", j + 1, media);
			}
		}

		public void mostrarMelhorAluno() {

			int melhor = 0;
			double maiorMedia = 0;

			for (int i = 0; i < alunos; i++) {

				double soma = 0;

				for (int j = 0; j < provas; j++) {

					soma += notas[i][j];
				}

				double media = soma / provas;

				if (i == 0 || media > maiorMedia) {

					maiorMedia = media;
					melhor = i;
				}
			}

			System.out.printf("%nMelhor aluno: %d (Media: %.2f)%n", melhor + 1, maiorMedia);
		}
	}

	// ================= UTILITY =================

	static class Utility {

		static int lerIntSeguro(Scanner sc, String msg) {

			while (true) {

				String texto = evitarLinhaVazia(sc, msg);

				try {

					return Integer.parseInt(texto);

				} catch (Exception e) {

					System.out.println("=== DIGITE UM INTEIRO ===");
				}
			}
		}

		static int lerIntervaloInt(Scanner sc, String msg, int min, int max) {

			while (true) {

				int valor = lerIntSeguro(sc, msg);

				if (valor < min || valor > max) {

					System.out.printf("=== ENTRE %d E %d ===%n", min, max);

				} else {

					return valor;
				}
			}
		}

		static double lerIntervaloDouble(Scanner sc, String msg, double min, double max) {

			while (true) {

				double valor = lerDoubleSeguro(sc, msg);

				if (valor < min || valor > max) {

					System.out.printf("=== ENTRE %.1f E %.1f ===%n", min, max);

				} else {

					return valor;
				}
			}
		}

		static double lerDoubleSeguro(Scanner sc, String msg) {

			while (true) {

				String texto = evitarLinhaVazia(sc, msg);

				try {

					return Double.parseDouble(texto);

				} catch (Exception e) {

					System.out.println("=== DIGITE UM NUMERO ===");
				}
			}
		}

		static String evitarLinhaVazia(Scanner sc, String msg) {

			while (true) {

				System.out.print(msg);

				String texto = sc.nextLine().trim();

				if (texto.isEmpty()) {

					System.out.println("=== NAO PODE VAZIO ===");
					continue;
				}

				return texto;
			}
		}
	}
}
