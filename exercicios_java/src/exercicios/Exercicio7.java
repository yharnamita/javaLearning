package exercicios;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio7 {
	public static void main(String[] args) {
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);
	
	int menu =-1;
	while (menu !=0) {
		 System.out.println("\n=== ESCOLHA A OPERAÇÃO ===");
         System.out.println("1 - Divisores de um numero");
         System.out.println("2 - Fatorial");
         System.out.println("0 - Sair");
         System.out.print("Opção: ");
        
		
		try{
        	 menu = sc.nextInt();
         
        	 switch (menu) {
         		case 1: divisores(sc); break;
         		case 2: fatorial(sc); break;
         		case 0: System.out.println("\n=== ENCERRAMOS AQUI, TENHA UM BOM DIA ==="); break;
         		default: System.out.println("\n=== OPÇÃO INVÁLIDA ===");
        	 }
         } catch (Exception e) {
        	 System.out.println("\n=== DIGITE APENAS NÚMEROS ===");
        	 sc.next(); //limpar entrada inválida
         }
		
	}	
	sc.close();
}
	
	//método try/catch para ler números int
			static int lerIntSeguro(Scanner sc, String mensagem) {
			while (true) {
				System.out.print(mensagem);
				try {
					return sc.nextInt();	
				} catch (Exception e) {
					System.out.println("\n=== DIGITE APENAS NÚMEROS ===");
					sc.next();
				}
			}
		}

	
	static void fatorial(Scanner sc) {
	
	System.out.println("\n=== FATORIAL ===");
	System.out.println("Um numero fatorado é ");
	
	int entrada = lerIntSeguro(sc,"\nDigite um número para fatorar: ");
	int fat = 1;
	
	for (int i=1; i<=entrada; i++) {
		fat = fat * i;
	}
	
	System.out.println(fat);
	
		}
	
	
	static void divisores(Scanner sc) {
		
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			if (n % i == 0) {
				System.out.println(i);
			}
		}
		}
			
	}

 
