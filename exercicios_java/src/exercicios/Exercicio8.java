package exercicios;
import java.util.Locale;
import java.util.Scanner;


public class Exercicio8{
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== CALCULO DE RETANGULOS ===");
		System.out.println("\nCalcule a area, o perimetro e a diagonal de um retangulo\n");
		
		calcRetangulo(sc);
		
		
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
	
	//método para ler SN
	static String lerSN (Scanner sc) {
		
		String resp;
		do { 
			System.out.println("\nDeseja inserir valores de outro retangulo? (S/N)");
			resp = sc.next().toUpperCase();
			
			if (!resp.equals("S") && !resp.equals("N")) {
	            System.out.println("Digite apenas S ou N");
	        }
			
		} while (!resp.equals("S") && !resp.equals("N"));
		return resp;
	}
			
	//============================================================================================
	
			static void calcRetangulo(Scanner sc) {
				
		
				
			do {
			
				Retangulo r = new Retangulo(); 
			
				r.lerDados(sc);
			
			
				System.out.printf("%nArea do retangulo = %.2f%n", r.area());
				System.out.printf("Perimetro do retangulo = %.2f%n", r.perimetro());
				System.out.printf("Diagonal do retangulo = %.2f%n", r.diagonal());
				
		
			} while (lerSN(sc).equals("S"));
	
				System.out.println("\n=== ENCERRAMOS AQUI, TENHA UM BOM DIA ===\n");
		}
		
			
		//==================================================================================================	
			
			static class Retangulo {
				
				double base;
				double altura;
				
				void lerDados(Scanner sc) {
					base = Exercicio8.lerDoubleSeguro(sc, "Valor da base: ");
					altura = Exercicio8.lerDoubleSeguro(sc, "Valor da altura: ");
				}
				
				double area() {
					return base * altura;
				}
				
				double perimetro() {
					return 2 * (base + altura);
				}
				double diagonal() {
					return Math.sqrt(base * base + altura * altura);
				}
			}
			
}