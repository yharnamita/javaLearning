package exercicios;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio17 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n = Utility.lerIntervaloInt(sc, "Quantos alunos serao digitados? ", 1 , 50);

       Aluno[] alunos = new Aluno[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Aluno " + (i + 1) + ":");

            String nome = Utility.lerNome(sc, "Nome: ");
            double n1 = Utility.lerIntervaloDouble(sc, "Nota 1: ", 0.0, 10.0);
            double n2 = Utility.lerIntervaloDouble(sc, "Nota 2: ", 0.0, 10.0);
            
            alunos[i] = new Aluno(nome, n1, n2);
        }

        System.out.println("Alunos aprovados:");


        for (int i = 0; i < alunos.length; i++) {
        	Aluno a = alunos[i];

            if (a.estaAprovado()) {
                System.out.println(a.getNome());
            }
        }

        sc.close();
    }
    
    static class Aluno {
    	
    	private String nome;
    	private double nota1;
    	private double nota2;
    	
    	public Aluno (String nome, double nota1, double nota2) {
    		this.nome = nome;
    		this.nota1 = nota1;
    		this.nota2 = nota2;
    	}
    	
    	public double media() {
    		return (nota1 + nota2) / 2.0;
    	}
    	
    	public boolean estaAprovado() {
    		return media() >= 6.0;
    	}
    	
    	public String getNome() {
    		return nome;
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
