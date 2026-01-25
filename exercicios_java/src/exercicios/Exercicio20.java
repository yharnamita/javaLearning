package exercicios;

import java.util.Scanner;
import java.util.Locale;

public class Exercicio20 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int n = Utility.lerIntervaloInt(sc, "Quantas pessoas serão digitadas?: ", 1, Integer.MAX_VALUE);

		Pessoa[] pessoas = new Pessoa[n];

		for (int i = 0; i < n; i++) {
			
			System.out.println("\nDados da " + (i + 1) + "a pessoa:");
			
			String nome = Utility.lerNome(sc, "Nome: ");
			
			int idade = Utility.lerIntervaloInt(sc, "Idade: ", 1, Integer.MAX_VALUE);
	
			double altura = Utility.lerIntervaloDouble(sc, "Altura: ", 0.0, Double.MAX_VALUE);
	
			pessoas[i] = new Pessoa(nome, idade, altura);
		}

		double media = mediaAlturas(pessoas);
		
		double porcentagem = calcularMenores16(pessoas);
		
		
		System.out.printf("\nAltura media: %.2f%n", media);
		System.out.printf("Pessoas com menos de 16 anos: %.1f%%%n", porcentagem);
		
		System.out.println("\nNomes dos menores de 16:");
		
		for (Pessoa p : pessoas) {
			if(p.menorDe16()) {
				System.out.println(p.getNome());
			}
		}
		
		sc.close();
	}

	static double mediaAlturas(Pessoa[] pessoas) {
		double soma = 0;
		for (Pessoa p : pessoas) {
			soma += p.getAltura();
		}

		return soma / pessoas.length;
	}

	static double calcularMenores16(Pessoa[] pessoas) {

		int cont = 0;

		for (Pessoa p : pessoas) {
			if (p.menorDe16()) {
				cont++;
			}
		}

		return cont * 100.0 / pessoas.length;
	}

	static class Pessoa {
		private String nome;
		private int idade;
		private double altura;

		public Pessoa(String nome, int idade, double altura) {
			this.nome = nome;
			this.idade = idade;
			this.altura = altura;
		}

		public boolean menorDe16() {
			return idade < 16;
		}

		public String getNome() {
			return nome;
		}

		public double getAltura() {
			return altura;
		}
	}

	
static class Utility {
    	
    	//======================================= STRING ========================================

    	// metodo para evitar leitura vazia na string
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
    	
    	
    		// metodo para impedir numero e especiais no nome
    		static String lerNome(Scanner sc, String mensagem) {
    			while (true) {
    				String nome = evitarLinhaVazia(sc, mensagem);

    				// regex - permite espaço, acentos, apostrofo
    				if (nome.matches("[A-Za-zÀ-ÿ ']+")) {
    					return nome;
    				}
    				System.out.println("=== O NOME NÃO PODE CONTER NUMEROS OU SIMBOLOS ===");
    			}
    		}
    	

    	// ============================ INT ==================================
    		
    	// método try/catch para ler números int
    	static int lerIntSeguro(Scanner sc, String mensagem) {
    		while (true) {
    			String texto = evitarLinhaVazia(sc, mensagem);
    			try {
    				return Integer.parseInt(texto);
    			} catch (NumberFormatException e) {
    				System.out.println("===APENAS NÚMEROS INTEIROS===");

    			}
    		}
    	}

    	
    	// metodo para definição de valor minimo e maximo em int
    		static int lerIntervaloInt(Scanner sc, String mensagem, int min, int max) {
    			while (true) {
    				int valor = lerIntSeguro(sc, mensagem);

    				if (valor < min || valor > max) {
    					if (max == Integer.MAX_VALUE) {
    						System.out.printf("=== O VALOR DEVE SER MAIOR OU IGUAL A: %d ===%n", min);
    					} else {
    						System.out.printf("=== O VALOR DEVE ESTAR ENTRE %d E %d ===%n", min, max);
    					}

    				} else {
    					return valor;

    				}

    			}
    		}
    	
    		
    	// =========================== DOUBLE =================================	
    		
    	
    	// método try/catch para ler números double
    	static double lerDoubleSeguro(Scanner sc, String mensagem) {
    		while (true) {
    			String texto = evitarLinhaVazia(sc, mensagem);
    			try {
    				return Double.parseDouble(texto);
    			} catch (NumberFormatException e) {
    				System.out.println("===APENAS NÚMEROS===");

    			}
    		}
    	}


    	// metodo para definição de valor minimo e maximo em doubles
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

    }
	
	
}