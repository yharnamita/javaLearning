package exercicios;
import java.util.Scanner;

//exercicios com for, uma opeção para encontrar numeros impares e outra para numeros pares

public class Exercicio6{
	
	public static void main(String[] args) {
		
		//menu
		Scanner sc = new Scanner(System.in);
		int menu =-1;
		while (menu !=0) {
			 System.out.println("\n=== ESCOLHA A OPERAÇÃO ===");
	         System.out.println("1 - Consulta de numeros Impares");
	         System.out.println("2 - Consulta de numeros pares");
	         System.out.println("0 - Sair");
	         System.out.print("Opção: ");
	        
			
			try{
	        	 menu = sc.nextInt();
	         
	        	 switch (menu) {
	         		case 1: numerosImp(sc); break;
	         		case 2: numerosPar(sc); break;
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
	
			
			static void numerosImp(Scanner sc) {
				
			System.out.println("Veja todos os números impares em um intervalo de sua escolha");
			
			int inicio = lerIntSeguro(sc, "Digite o número de inicio do intervalo: ");
			int fim = lerIntSeguro(sc, "Digite o número final do intervalo: ");
			
			
		//Para começar sempre do menor numero
			if(inicio > fim) {
				int inverter = inicio;
				inicio = fim;
				fim = inverter;
			}
			
			System.out.println("\nNúmeros ímpares entre " + inicio + " e " + fim + ":");
			
			boolean encontro = false;
			
			for(int var = inicio; var <= fim; var++) {
				
				if (var % 2 != 0) {

					System.out.println(var);
					encontro = true;
				}
			}	
			if (!encontro) {
				System.out.println("nenhum número impar encontrado");
			}
		}
		
			static void numerosPar(Scanner sc) {
				
				System.out.println("Veja todos os números pares em um intervalo de sua escolha");
				
				int inicio = lerIntSeguro(sc, "Digite o número de inicio do intervalo: ");
				int fim = lerIntSeguro(sc, "Digite o número final do intervalo: ");
				
				
				if(inicio > fim) {
					int inverter = inicio;
					inicio = fim;
					fim = inverter;
				}
				
				System.out.println("\nNúmeros pares entre " + inicio + " e " + fim + ":");
				
				boolean encontro = false;
				
				for(int var = inicio; var <= fim; var++) {
					
					if (var % 2 == 0) {

						System.out.println(var);
						encontro = true;
					}
				}	
				if (!encontro) {
					System.out.println("nenhum número par encontrado");
				}
			}
}