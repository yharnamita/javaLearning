package exercicios;

//CADASTRO E VERIFICACAO DE PRECO DE PECAS COM POO

import java.util.Locale;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio03{

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("===Digite as caracteristicas da peça que você quer===");
		
		pecas(sc);
		
		sc.close();
		
	}

		//método try/catch para ler números int
				static int lerIntSeguro(Scanner sc, String mensagem) {
					while (true) {
						System.out.print(mensagem);
						try {
							return sc.nextInt();	
						} catch (Exception e) {
							System.out.println("===APENAS NÚMEROS===");
							sc.next();
						}
					}
				}
				
				//método try/catch para ler números double
				static double lerDoubleSeguro(Scanner sc, String mensagem) {
					while (true) {
						System.out.print(mensagem);
						try {
							return sc.nextDouble();	
						} catch (Exception e) {
							System.out.println("===APENAS NÚMEROS===");
							sc.next();
						}
					}
				}

				//método para ler S ou N
				static String lerSN (Scanner sc) {

					while (true) {
						
						String resp = sc.nextLine().trim().toUpperCase();
						
						if (resp.isEmpty()) {
				            continue;
						}
								
						char c = resp. charAt(0);
						
						if (c == 'S' || c == 'N') {
				            return String.valueOf(c);
						
					        }
						
						 System.out.println("Digite apenas S ou N");
				} 
			}
				
				
		static void pecas(Scanner sc) {

		ArrayList<Peca> lista = new ArrayList<>();
		String resp;
		
		do {
			Peca p = new Peca();
			
		while (true) {
			p.lerDados(sc);
			sc.nextLine();
			p.mostrarResumo();
			
			System.out.print("Essa peça que você queria? >=) (S/N): ");
            String conf = lerSN(sc);

            if (conf.equals("S")) {
                break; // sai do loop
            }

            System.out.println("===Vamos digitar os dados novamente.\n===");
        }
			
			lista.add(p);
			System.out.print("===Deseja adicionar outra peça?=== (S/N): ");
			resp = lerSN(sc);
			
		} while (resp.equals("S"));
		
		double total = 0;
		for (Peca p : lista) {
			total += p.calcularTotal();
		}
		
		System.out.printf("===Valor total a pagar: R$ %.2f%n===", total);
		
		}
		


	static class Peca {
	
	int codigo;
	int quantidade;
	double valorUnitario;
	
	void lerDados(Scanner sc) {
		codigo = Exercicio03.lerIntSeguro(sc, "Numero de Identificação: ");
		quantidade = Exercicio03.lerIntSeguro(sc, "Quantidade da peça: ");
		valorUnitario = Exercicio03.lerDoubleSeguro(sc, "Valor unitário: ");
	}
	
	void mostrarResumo() {
	    System.out.println("=== RESUMO DA PEÇA ===");
	    System.out.println("Código: " + codigo);
	    System.out.println("Quantidade: " + quantidade);
	    System.out.printf("Valor unitário: R$ %.2f%n", valorUnitario);
	}
	
	double calcularTotal() {
		return quantidade *valorUnitario;
	}
}
}

