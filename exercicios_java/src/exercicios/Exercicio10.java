package exercicios;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio10{
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== NOTAS DE ALUNO ===");
		
		calcNotas(sc);
		
		sc.close();		
	}

	//============================================================================================
	
			static void calcNotas(Scanner sc) {
				
				String resp;
				
			do {
			
				Estudante aluno = new Estudante();

				aluno.lerDados(sc);
				
				System.out.printf("Nota Final: %.2f%n", aluno.mediaFinal());
				
			
					if (aluno.mediaFinal() < 60) {
					
						System.out.println("REPROVADO");
						System.out.printf("Faltam %.2f pontos para passar%n", aluno.pontosFaltantes());
						
					}else {
						System.out.println("\nAPROVADO");
			
			}
				
				resp = Utility.lerSN(sc, "\nDeseja consultar a média de outro aluno? (S/N)\n");
					
			} while (resp.equals("S"));
	
				System.out.println("\n=== ENCERRAMOS AQUI, TENHA UM BOM DIA ===\n");
		}
		
			
		//==================================================================================================	
			
			static class Estudante {
				
				String nome;
				double nota1;
				double nota2;
				double nota3;
				
				void lerDados(Scanner sc) {
					
					nome = Utility.lerNome(sc, "Qual o nome do aluno?: \n" );
					nota1 = lerNota(sc, "Qual a nota do primeiro trimestre dele: \n");
					nota2 = lerNota(sc, "Qual a nota do segundo trimestre dele: \n");
					nota3 = lerNota(sc, "Qual a nota do terceiro trimestre dele: \n");
				}
				
				double mediaFinal() {
					return (nota1 + nota2 + nota3) / 3;
				}
				
				double pontosFaltantes(){
					if(mediaFinal() < 60.00) {
						return 60.00 - mediaFinal();
					} else
						return 0.0;
				}
				
				double lerNota(Scanner sc, String mensagem) {
					while (true) {
						double nota = Utility.lerDoubleSeguro(sc,mensagem);
						
						if (nota < 0 || nota > 100 ) {
							System.out.println("=== A NOTA DEVE ESTAR ENTRE 0 E 100 ===");
							
						}else {
							return nota;
						}
					}
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