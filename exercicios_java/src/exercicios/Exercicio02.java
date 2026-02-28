package exercicios;

import java.util.Locale;
import java.util.Scanner;

/*
 * COMPILADO DE EXERCICIOS COM OPERACOES BASICAS DE LOGICA DE PROGRAMACAO
 * CHAMADA DE CLASSE, MULTIPLICAÇÃO, DIVISÃO, RESTO
 *  WHILE, SWITCH, IF ELSE, TRY CATCH
 */

public class Exercicio02 {
	public static void main(String[] args) {
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);
	
	//menu
	
	int menu =-1;
	while (menu !=0) {
		 System.out.println("\n=== ESCOLHA A OPERAÇÃO ===");
         System.out.println("1 - Formas Geométricas");
         System.out.println("2 - If/Else Positivo e Negativo");
         System.out.println("3 - Impar ou Par");
         System.out.println("4 - Números Multiplos");
         System.out.println("0 - Sair");
         System.out.print("Opção: ");

         
         try{
        	 menu = sc.nextInt();
         
        	 switch (menu) {
         		case 1: formasgeo(sc); break;
         		case 2: positivonegativo(sc); break;
         		case 3: imparpar(sc); break;
         		case 4: multiplos(sc); break;
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
				System.out.println("===APENAS NÚMEROS===");
				sc.next();
			}
		}
	}
	
	//método try/catch para ler números float
	static float lerFloatSeguro(Scanner sc, String mensagem) {
		while (true) {
			System.out.print(mensagem);
			try {
				return sc.nextFloat();	
			} catch (Exception e) {
				System.out.println("===APENAS NÚMEROS===");
				sc.next();
			}
		}
	}
	
	//formas;
	static void formasgeo(Scanner sc) {

	double tri, circ, trap, quad, ret, pi;
	pi = 3.14159;
	
	float A = lerFloatSeguro(sc, "Digite o valor de A: ");
	float B = lerFloatSeguro(sc, "Digite o valor de B: ");
	float C = lerFloatSeguro(sc, "Digite o valor de C: ");
	
	tri = (A * C) / 2;
	circ = pi * (C * C);
	trap = ((A + B) * C) / 2;
	quad = B * B;
	ret = A * B; 
	
	System.out.printf("TRIANGULO: %.3f%n", tri);
	System.out.printf("CIRCULO: %.3f%n", circ);
	System.out.printf("TRAPEZIO: %.3f%n", trap);
	System.out.printf("QUADRADO: %.3f%n", quad);
	System.out.printf("RETANGULO: %.3f%n%n", ret);
	}
	
	
	//if else;
	static void positivonegativo(Scanner sc) {
		
	int posneg = lerIntSeguro(sc, "Digite um número: ");

			if (posneg < 0 ) {
				System.out.println("negativo");
			} else {
				System.out.println("positivo");
			}
	}
	
	
	//par ou impar
	
	static void imparpar(Scanner sc) {

		int parimpar = lerIntSeguro(sc, "Digite um número: ");
	
			if (parimpar % 2 == 0) {
				System.out.println("PAR");
			} 
			else {
				System.out.println("IMPAR");
			}
	}
	
	//MULTIPLOS
	
	static void multiplos(Scanner sc) {

	int mult1 = lerIntSeguro(sc, "Digite o primeiro número: ");
	int mult2 = lerIntSeguro(sc, "Digite o segundo número: ");
	
	if (mult1 % mult2 == 0 || mult2 % mult1 == 0){
		System.out.println("Sao Multiplos");
	} 
	else {
		System.out.println("NAO SAO MULTIPLOS");
	}
	
}
}