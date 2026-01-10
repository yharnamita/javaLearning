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

	//=================================================================================
	
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
	
	//====================================================================================
	
	//metodo para evitar leitura vazia na string
	static String evitarStringVazia(Scanner sc, String mensagem) {

		String texto;
		
		do {
			System.out.println(mensagem);
			texto =  sc.nextLine().trim();
			
			if (texto.isEmpty()) {
				System.out.println("=== DIGITE ALGUMA COISA ====");
			}
		} while (texto.isEmpty());
		
		return texto;
	}
	
	//=====================================================================================
	
	//método para ler SN
	static String lerSN (Scanner sc, String mensagem) {
		
		String resp;
		do { 
			System.out.println(mensagem);
			resp = sc.next().toUpperCase();
			
			if (!resp.equals("S") && !resp.equals("N")) {
	            System.out.println("Digite apenas S ou N");
	        }
			
		} while (!resp.equals("S") && !resp.equals("N"));
		return resp;
	}
			
	//============================================================================================
	
			static void infoFunc(Scanner sc) {
				
				String resp;
				
			do {
			
				Empregado clt = new Empregado();

				clt.lerDados(sc);
				
				System.out.println("Empregado: " + clt);
				
				String desejaAbono = lerSN(sc, "\nDeseja uma porcentagem de abono?: (S/N)");
			
					if (desejaAbono.equals("S")) {
						double porcentagem = lerDoubleSeguro(sc, "Qual a porcentagem do abono?: ");
						clt.abono(porcentagem);
					}else {
						System.out.println("\nObrigado, Encerramos por aqui");
					return;
			}
			
				System.out.println("Empregado: " + clt);
				
				System.out.println("\nDeseja Cadastrar outro empregado? (S/N)");
				resp = sc.next().toUpperCase();
				sc.nextLine();
				
			} while (resp.equals("S"));
	
				System.out.println("\n=== ENCERRAMOS AQUI, TENHA UM BOM DIA ===\n");
		}
		
			
		//==================================================================================================	
			
			static class Empregado {
				
				String nome;
				double salario;
				double roubo;
				
				void lerDados(Scanner sc) {
					
		
					nome = Exercicio9.evitarStringVazia(sc, "Qual o nome do empregado?: " );
					salario = Exercicio9.lerDoubleSeguro(sc, "Qual o salario bruto do empregado?: \n");
					roubo = Exercicio9.lerDoubleSeguro(sc, "Quanto é descontado do imposto?: \n");
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
}