package exercicios;
import java.util.Scanner;
import java.util.Locale;

public class Exercicio21{
	public static void main(String[]args) {	
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Aluguel[] quartos = new Aluguel[10];
				
		int n = Utility.lerIntervaloInt(sc, "Quantos quartos serão alugados? ", 1, 10);
		
		for (int i = 1; i<=n; i++) {
		
			System.out.println("\nAluguel #" + (i) + ":");
			
			String nome = Utility.lerNome(sc, "Nome: ");
			
			String email = Utility.evitarLinhaVazia(sc, "Email: ");
			
			int quarto = lerQuarto(sc, quartos);
			
			
			quartos[quarto - 1] = new Aluguel(nome, email);
		}
		
		System.out.println("\nQuartos Ocupados: ");
		for (int i = 0; i < quartos.length; i++) {
			if(quartos[i] != null) {
			System.out.println((i + 1) + ": " + quartos[i]);
			}
		}
		
		sc.close();
		
}
	
	static int lerQuarto(Scanner sc, Aluguel[] quartos) {
		while(true) {
			int q = Utility.lerIntervaloInt(sc, "Quarto (1 ao 10): ", 1, 10);
			
			int indice = q - 1;
			
			if (quartos[indice] != null) {
				
				System.out.println("=== QUARTO JA OCUPADO ===");
			} else {
				return q;
			}
		}
	}
	
	static class Aluguel{
		
		private String nome;
		private String email;
		
		
		public Aluguel(String name, String email) {
			
			this.nome = name;
			this.email = email;
		}


		public String getNome() {
			return nome;
		}


		public String getEmail() {
			return email;
		}

		@Override
		public String toString() {
			return nome + ", " + email;
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
    				System.out.println("===O NOME NÃO PODE CONTER NUMEROS OU SIMBOLOS");
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