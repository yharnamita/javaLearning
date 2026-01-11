package exercicios;
import java.util.Locale;
import java.util.Scanner;

/*esse exercicio traz um menu com duas operacoes, a primeira é a identificacao do quadrante no plano cartesiano
e a segunda é uma enquete
*/

public class Exercicio05 {
	public static void main(String[] args) {
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);
	
	int menu =-1;
	while (menu !=0) {
		 System.out.println("\n=== ESCOLHA A OPERAÇÃO ===");
         System.out.println("1 - Plano Cartesiano");
         System.out.println("2 - Enquete");
         System.out.println("0 - Sair");
         System.out.print("Opção: ");
        
		
		try{
        	 menu = sc.nextInt();
         
        	 switch (menu) {
         		case 1: planoCartesiano(sc); break;
         		case 2: enquete(sc); break;
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

	
	//plano cartesiano
	static void planoCartesiano(Scanner sc) {
	
	System.out.println("\n===PLANO CARTESIANO===");
	System.out.println("\nDigite o valor de X e Y, respectivamente");
	System.out.printf("(O código se encerra quando digitar 0)%n");
	
	int x = lerIntSeguro(sc, "\nDIGITE O VALOR DE X: ");
	int y = lerIntSeguro(sc, "DIGITE O VALOR DE Y: ");
	
	while (x != 0 && y !=0) {
		if (x > 0 && y > 0)  {
			System.out.println("\nEsta coordenada pertence ao primeiro quadrante");
		} else if (x < 0 && y > 0) {
			System.out.println("\nEsta coordenada está no segundo quadrante");
		} else if (x < 0 && y < 0) {
			System.out.println("\nEsta coordenada está no terceiro quadrante");
		} else {
			System.out.println("\nEsta ccoordenada está no quarto quadrante");
		}
		
		x = lerIntSeguro(sc, "\nDIGITE O VALOR DE X: ");
		y = lerIntSeguro(sc, "DIGITE O VALOR DE Y: ");	
	}
		System.out.println("\n=== Acabamos aqui, tenha um bom dia ===");
		
		}
	

	// enquete
	
	static void enquete(Scanner sc) {
		
		int opcao1 = 0;
		int opcao2 = 0;
		int opcao3 = 0;
		int escolha;
		
		System.out.println("\n=== ENQUETE ===");
		System.out.println("Escolha uma opção entre 1,2 e 3");
		System.out.println("0 encerra a enquete");
		
		
		do {
			
		escolha = lerIntSeguro(sc, "\nEscolha uma alternativa: ");
		switch (escolha) {
		
 		case 1: opcao1++; break;
 		case 2: opcao2++; break;
 		case 3: opcao3++; break;
 		case 0: System.out.println("\n=== ENCERRANDO ENQUETE... ==="); break;
 		default: System.out.println("\n=== OPÇÃO INVÁLIDA ===");	
		
			}
		} while (escolha != 0);
		
		System.out.println("\n=== RESULTADO ===");
		System.out.printf("%nOpção 1 teve %d votos%n", opcao1);
		System.out.printf("Opção 2 teve %d votos%n", opcao2);
		System.out.printf("Opção 3 teve %d votos%n", opcao3);
		}
			
	}

 
