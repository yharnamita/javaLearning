package exercicios;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio15 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n = Utility.lerIntervaloInt(sc, "Quantas pessoas voce vai digitar? ", 1, Integer.MAX_VALUE);

        Pessoa[] pessoas = new Pessoa[n];
        

        for (int i = 0; i < n; i++) {
            System.out.println("Dados da " + (i + 1) + "a pessoa:");
            
            String nome = Utility.lerNome(sc, "Nome: ");
         
            int idade = Utility.lerIntervaloInt(sc, "Idade: ", 1, Integer.MAX_VALUE);
            
            pessoas[i] = new Pessoa(nome, idade);
        }

        Pessoa maisVelha = pessoas[0];  // encontrar a pessoa mais velha
        
        for (int i = 1; i < n; i++) {
            if (pessoas[i].getIdade() > maisVelha.getIdade()) {
                maisVelha = pessoas[i];
            }
        }

        System.out.println();
        System.out.println("PESSOA MAIS VELHA: " + maisVelha.getNome());

        sc.close();
    }
    
    static class Pessoa{
    	private String nome;
    	private int idade;
    	
    	public Pessoa(String nome, int idade) {
    		this.nome = nome;
    		this.idade = idade;
    	}

		public String getNome() {
			return nome;
		}

		public int getIdade() {
			return idade;
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
