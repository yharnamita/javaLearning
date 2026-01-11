package exercicios;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio07 {
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

	//metodo para fatoriais
	static void fatorial(Scanner sc) {
	
	System.out.println("\n=== FATORIAL ===");
	System.out.println("Um numero fatorado é um número que é decomposto para multiplicar seus fatores");
	System.out.println("Exemplo: 4 = 4x3x2x1 = 24");
	
	int entrada = lerIntSeguro(sc,"\nDigite um número para fatorar: ");
	
	//na matematica, so se pode fatorar numeros positivos
	if (entrada < 0) {
		System.out.println("\n=== Não existe fatorial de número negativo ===");
		return;
	}
	
	int resultado = entrada;
	
	// O fatorial de 0 sempre sera 1
	if (entrada == 0) {
	    resultado = 1;
	    System.out.printf("%nO fatorial de %d = %d%n", entrada, resultado);
	    return;
	}
	
	System.out.println("\nCalculo: ");
	
	for (int deco = entrada - 1; deco >= 1; deco--) {
		System.out.println(resultado + " x " + deco + " = " + (resultado * deco));
		resultado = resultado * deco;
	}
	
	System.out.printf("%nResultado final: %d%n", resultado);
	
		}
	
	
	static void divisores(Scanner sc) {
		
		
	//divisores de numeros positivos
	System.out.println("\n=== DIVISORES ===");
		
	int numero;
		
	while(true){	
		numero = lerIntSeguro(sc, "\nDigite um número positivo para calcular todos os seus divisores: ");
		
			if (numero < 0) {
			System.out.println("\nVamos focar na positividade por hora, ok?");

			} else {
					break;
			}
	}
	
		if (numero == 0) {
		    System.out.println("\nResultado indefinido");
		    return;  
		} 
		
		System.out.printf("%nOs divisores de %d são: %n", numero);
		
		for (int divid = 1; divid <= numero; divid++) {
			if (numero % divid == 0) {
				
				System.out.println(divid);
			}
		}
	}
			
}