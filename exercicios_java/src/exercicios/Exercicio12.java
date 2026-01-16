package exercicios;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio12{
	
	 public static void main(String[] args) {
	        Locale.setDefault(Locale.US);
	        Scanner sc = new Scanner(System.in);

	        int numero = Utility.lerIntPositivo(sc, "Informe o número da conta: ");
	        String titular = Utility.lerNome(sc, "Informe o nome do titular: ");
	        
	        String resp = Utility.lerSN(sc, "Haverá depósito inicial (S/N)? ");

	        Conta conta;

	        if (resp.equals("S")) {
	        	double depositoInicial = Utility.lerDoublePositivo(sc, "Informe o valor do depósito inicial: ", 0.0, Double.MAX_VALUE);
	           
	            conta = new Conta(numero, titular, depositoInicial);
	        } else {
	            conta = new Conta(numero, titular);
	        }

	        System.out.println("\nDados da conta:");
	        System.out.println(conta);

	        double valorDeposito = Utility.lerDoublePositivo(sc, "\nInforme um valor para depósito: ", 0.0, Double.MAX_VALUE);
	        conta.deposito(valorDeposito);

	        System.out.println("Dados atualizados:");
	        System.out.println(conta);

	        double valorSaque = Utility.lerDoublePositivo(sc, "\nInforme um valor para saque: ", 0.0, Double.MAX_VALUE);
	        conta.saque(valorSaque);

	        System.out.println("Dados atualizados:");
	        System.out.println(conta);

	        sc.close();
	    }
}
			
		//==================================================================================================	
			
			class Conta {
				private int numero;
				private String titular;
				private double saldo;
				
				public Conta(int numero, String titular) {
					
					this.numero = numero;
					this.titular = titular;
				}
				
				public Conta(int numero, String titular, double depositoInicial) {
					
					this.numero = numero;
					this.titular = titular;
					this.saldo = depositoInicial;
				
			}

				public String getTitular() {
					return titular;
				}

				public void setTitular(String titular) {
					this.titular = titular;
				}

				public int getNumero() {
					return numero;
				}

				public double getSaldo() {
					return saldo;
				}

				public void deposito(double valor) {
			        saldo += valor;
			    }

			    public void saque(double valor) {
			        saldo -= valor + 5.0;
			    }
			    
			   @Override
			   public String toString() {
			        return "Conta "
			             + numero
			             + ", Titular: "
			             + titular
			             + ", Saldo: R$ "
			             + String.format("%.2f", saldo);
			    }
			}
			   
			 //=====================================================================================================	
				
				 class Utility{
					
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
					
					static int lerIntPositivo(Scanner sc, String mensagem) {
					    while (true) {
					        int valor = lerIntSeguro(sc, mensagem);
					        if (valor > 0) {
					            return valor;
					        }
					        System.out.println("=== O VALOR DEVE SER POSITIVO ===");
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
	

				
		
		