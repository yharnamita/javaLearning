package exercicios;
import java.util.Locale;
import java.util.Scanner;

//nao entendi pq esse exercicio pediu so a media das mulheres mas ok

public class Exercicio18{
	
	public static void main(String[] args){
		
	Locale.setDefault(Locale.US);	
	Scanner sc = new Scanner (System.in);
		
		int n = Utility.lerIntervaloInt(sc, "Quantas pessoas serão verificadas?: ", 1, Integer.MAX_VALUE);
		
		Pessoa[] pessoas = new Pessoa[n];
		
		for (int i = 0; i < n; i++) {

		    System.out.println("Dados da " + (i + 1) + "a pessoa:");

		    double altura = Utility.lerIntervaloDouble(sc, "Altura: ", 0.5, 3.0);

		    char genero;

		    while (true) {
		        String g = Utility.evitarLinhaVazia(sc, "Genero (M/F): ").toUpperCase();
		        genero = g.charAt(0);

		        if (genero == 'M' || genero == 'F') {
		            break;
		        }

		        System.out.println("=== Digite APENAS M OU F ===");
		    }

		    pessoas[i] = new Pessoa(altura, genero);
		}

		
		double menorAltura = pessoas[0].getAltura();
        double maiorAltura = pessoas[0].getAltura();

        double somaAlturaMulheres = 0.0;
        int qtdMulheres = 0;
        int qtdHomens = 0;

        for (Pessoa p : pessoas) {

            if (p.getAltura() < menorAltura) {
                menorAltura = p.getAltura();
            }

            if (p.getAltura() > maiorAltura) {
                maiorAltura = p.getAltura();
            }

            if (p.isMulher()) {
                somaAlturaMulheres += p.getAltura();
                qtdMulheres++;
            }

            if (p.isHomem()) {
                qtdHomens++;
            }
        }

        double mediaMulheres = somaAlturaMulheres / qtdMulheres;

        System.out.printf("Menor altura = %.2f%n", menorAltura);
        System.out.printf("Maior altura = %.2f%n", maiorAltura);
        System.out.printf("Media das alturas das mulheres = %.2f%n", mediaMulheres);
        System.out.println("Numero de homens = " + qtdHomens);

        sc.close();
		
	}
	
static class Pessoa {
		private double altura;
		private char genero;
		
		 public Pessoa(double altura, char genero) {
			 
			 genero = Character.toUpperCase(genero);
			 
			 if (genero != 'M' && genero != 'F') {
				 throw new IllegalArgumentException("=== ENTRADA INVALIDA ===");
			 }
			 
		        this.altura = altura;
		        this.genero = genero;
		    }

		public double getAltura() {
			return altura;
		}

		public char getGenero() {
			return genero;
		}
		
		public boolean isMulher() {
	        return genero == 'F';
	    }

	    public boolean isHomem() {
	        return genero == 'M';
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
    	
    		
    		// método para ler Sim ou Nao
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
