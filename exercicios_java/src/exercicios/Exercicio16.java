package exercicios;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio16 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int n = Utility.lerIntervaloInt(sc, "Quantos valores vai ter cada vetor? ", 1, Integer.MAX_VALUE);

		int[] vetorA = new int[n];
		int[] vetorB = new int[n];
		int[] vetorC = new int[n];

		System.out.println("Digite os valores do vetor A:");
		for (int i = 0; i < n; i++) {
			vetorA[i] = Utility.lerIntSeguro(sc, "");
		}

		System.out.println("Digite os valores do vetor B:");
		for (int i = 0; i < n; i++) {
			vetorB[i] = Utility.lerIntSeguro(sc, "");
		}

		// soma dos vetores A e B gerando C
		for (int i = 0; i < n; i++) {
			vetorC[i] = vetorA[i] + vetorB[i];
		}

		System.out.println("VETOR RESULTANTE:");
		for (int i = 0; i < n; i++) {
			System.out.println(vetorC[i]);
		}

		sc.close();
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
    				System.out.println("===O NOME NÃO PODE CONTER NUMEROS OU SIMBOLOS");
    			}
    		}
    	
    		
    		// método para ler SN
    		static String lerSN(Scanner sc, String mensagem) {

    			while (true) {

    				String texto = evitarLinhaVazia(sc, mensagem).toUpperCase();

    				char c = texto.charAt(0);

    				if (c == 'S' || c == 'N') {
    					return String.valueOf(c);

    				}

    				System.out.println("Digite apenas S ou N");
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
    	
    		
    	// =========================== DOUBLE (E FLOAT) =================================	
    		
    	// método try/catch para ler números float
    	static float lerFloatSeguro(Scanner sc, String mensagem) {
    		while (true) {
    			String texto = evitarLinhaVazia(sc, mensagem);
    			try {
    				return Float.parseFloat(texto);
    			} catch (NumberFormatException e) {
    				System.out.println("===APENAS NÚMEROS===");

    			}
    		}
    	}

    	
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
