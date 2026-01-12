package exercicios;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio11{
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== COMPRAR DOLLAR (+IOF) ===");
		
		calcConverse(sc);
		
		sc.close();		
	}

	//============================================================================================
	
			static void calcConverse(Scanner sc) {
				
				String resp;
				
			do {
			
				ConversorDollar conversao = new ConversorDollar();

				conversao.lerDados(sc);
				conversao.calculoIOF(6);
				
				System.out.printf("Com o IOF, a quantidade a ser paga em reais é: R$ %.2f%n", conversao.valorReal);
				
				resp = Utility.lerSN(sc, "\nDeseja consultar outro valor? (S/N)\n");
					
			} while (resp.equals("S"));
	
				System.out.println("\n=== ENCERRAMOS AQUI, TENHA UM BOM DIA ===\n");
		}
		
			
		//==================================================================================================	
			
			static class ConversorDollar {
				
				double dolar;
				double compra;
				double valorReal;
				
				void lerDados(Scanner sc) {
					
					dolar = Utility.lerDoublePositivo(sc, "Qual o valor do dolar?: \n", 0.0, Double.MAX_VALUE);
					compra = Utility.lerDoublePositivo(sc, "Quantos dolares você quer comprar?: \n", 0.0, Double.MAX_VALUE);

				}
				
				void calculoIOF(double porcentagem) {
					double total = compra * dolar;
					valorReal = total + total * (porcentagem/100);
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
				
				//metodo para definição de valor minimo e maximo em doubles
				static double lerDoublePositivo(Scanner sc, String mensagem, double min, double max) {
					while(true) {
						double valor = lerDoubleSeguro(sc, mensagem);
						
						if (valor < min || valor > max) {
							
							if(max == Double.MAX_VALUE) {
							System.out.printf("=== O VALOR DEVE SER MAIOR OU IGUAL A: %.2f ===%n", min);	
							
							} else {
							System.out.printf("=== O VALOR DEVE ESTAR ENTRE %.2f E %.2f ===%n", min, max);
							}
							
						} else {
							return valor;
						}
					}
				}
				
				//metodo para impedir numero e especiais no nome
				static String lerNome(Scanner sc, String mensagem) {
					while (true) {
						String nome = evitarLinhaVazia(sc, mensagem);
						
						//regex
						if(nome.matches("[A-Za-zÀ-ÿ ']+")) {
							return nome;
						}
						System.out.println("===O NOME NÃO PODE CONTER NUMEROS OU SIMBOLOS");
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