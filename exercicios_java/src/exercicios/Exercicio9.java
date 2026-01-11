package exercicios;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio9{
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== FICHA DE FUNCIONARIO ===");
		
		infoFunc(sc);
		
		sc.close();		
	}

	//============================================================================================
	
			static void infoFunc(Scanner sc) {
				
				String resp;
				
			do {
			
				Empregado clt = new Empregado();

				clt.lerDados(sc);
				
				System.out.println("Empregado: " + clt);
				
				String desejaAbono = Utility.lerSN(sc, "\nDeseja uma porcentagem de abono?: (S/N)\n");
			
					if (desejaAbono.equals("S")) {
						double porcentagem = Utility.lerDoubleSeguro(sc, "Qual a porcentagem do abono?: \n");
						clt.abono(porcentagem);
						
						System.out.println("Resumo pós abono: ");
						System.out.println("Empregado: " + clt);
						
					}else {
						System.out.println("\nSem abono aplicado");
			
			}
				
				resp = Utility.lerSN(sc, "\nDeseja cadastrar outro empregado? (S/N)\n");
					
			} while (resp.equals("S"));
	
				System.out.println("\n=== ENCERRAMOS AQUI, TENHA UM BOM DIA ===\n");
		}
		
			
		//==================================================================================================	
			
			static class Empregado {
				
				String nome;
				double salario;
				double roubo;
				
				void lerDados(Scanner sc) {
					
		
					nome = Utility.evitarLinhaVazia(sc, "Qual o nome do empregado?: \n" );
					salario = Utility.lerDoubleSeguro(sc, "Qual o salario bruto do empregado?: \n");
					roubo = Utility.lerDoubleSeguro(sc, "Quanto é descontado do imposto?: \n");
				}
				
				double liquidez() {
					return salario - roubo;
				}
				
				void abono(double porcentagem) {
					salario += salario * porcentagem / 100;
				}
				public String toString() {
					return nome + ", Salário Liquido: $ " + String.format("%.2f", liquidez());
				}
			}

			
		//=====================================================================================================	
			
			static class Utility{
				
				//método try/catch para ler números int
				static int lerIntSeguro(Scanner sc, String mensagem) {
					while (true) {
						String texto = evitarLinhaVazia(sc, mensagem);
						try {
							return Integer.parseInt(texto);	
						} catch (NumberFormatException e) {
							System.out.println("===APENAS NÚMEROS INTEIROS===");
							sc.next();
						}
					}
				}
				
				//método try/catch para ler números float
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
				
				//método try/catch para ler números double
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
				
				
				//metodo para evitar leitura vazia na string
				static String evitarLinhaVazia(Scanner sc, String mensagem) {

					while(true) {
					System.out.print(mensagem);
					String texto = sc.nextLine().trim();
					
						if (texto.isEmpty()) {
							System.out.println("=== DIGITE ALGUMA COISA ====");
							continue;
						}
			
					return texto;
				}
			}				
				
				//método para ler SN
				static String lerSN (Scanner sc, String mensagem) {
					
				
					while (true) {
						
						String texto = evitarLinhaVazia(sc, mensagem).toUpperCase();
						
								
						char c = texto.charAt(0);
						
						if (c == 'S' || c == 'N') {
				            return String.valueOf(c);
						
					        }
						
						 System.out.println("Digite apenas S ou N");
				} 
			}
				
			}
}