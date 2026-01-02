package exercicios;
import java.util.Locale;
import java.util.Scanner;

public class exercicio1 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int menu =-1;
		
		while (menu!=0) {
			System.out.println("=== ESCOLHA A OPERAÇÃO");
			System.out.println("1 - Random info");
			System.out.println("2 - Área do Terreno");
	        System.out.println("3 - Soma de Dois Valores");
	        System.out.println("4 - Área do Círculo");
	        System.out.println("5 - Diferença");
	        System.out.println("6 - Funcionário");
	        System.out.println("7 - Peças (POO)");
	        System.out.println("0 - Sair");
	        System.out.print("Opção: ");
	    
	        try {
	        	menu = sc.nextInt();
	        	
	        	   switch (menu) {
	   	        case 1: info(); break;
	   	        case 2: calcArea(sc); break;
	   	        case 3: soma(sc); break;
	   	        case 4: areacirculo(sc); break;
	   	        case 5: diferenca(sc); break;
	   	        case 6: funcionario(sc); break;
	   	        case 7: pecas(sc); break;
	   	        case 0: System.out.println("\n=== ENCERRAMOS AQUI, TENHA UM BOM DIA ==="); break;
	   	        default: System.out.println("\n=== OPÇÃO INVÁLIDA ===");
	   	        }
	        } catch(Exception e) {
	        	System.out.println("\n===DIGITE APENAS NÚMEROS===");
	        	sc.next();
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
		
		//random info - declaração de variaveis
		
				static void info() {
				String product1 = "Computer";
				String product2 = "Office desk";
				
				int age = 30;
				int code = 5290;
				char gender = 'F';
				
				double price1 = 2100.0;
				double price2 = 650.50;
				double measure = 53.234567;
				System.out.println("Products:");
				System.out.printf("%s, which price is $%.2f%n", product1, price1 );
				System.out.printf("%s, which price is $%.2f%n%n", product2, price2 );
				
				System.out.printf("Record: %d, code %d and gender: %c%n%n", age, code, gender);
				
				System.out.printf("Measure with eight decimal places: %.8f%n", measure);
				System.out.printf("Rouded (three decimal places): %.3f%n%n", measure);
			
				}
		
		//AREA
		
				static void calcArea(Scanner sc) {
	
				double larg = lerDoubleSeguro(sc, "Digite a Largura: ");
				double comp = lerDoubleSeguro(sc, "Digite o comprimento: ");
				double metro = lerDoubleSeguro(sc,"Digite o valor do metro: ");
	
				double area = larg * comp;
				double valor = area * metro;

				System.out.printf("AREA = %.2f%nPRECO = %.2f%n%n%n", area, valor);
		}

		
		//Soma;
		
				static void soma(Scanner sc) {
				
				int soma1 = lerIntSeguro(sc, "Escreva o primeiro valor da soma: ");
				int soma2 = lerIntSeguro(sc, "Escreva o segundo valor da soma: ");
		
				int somaresult = soma1 + soma2;

				System.out.printf("SOMA = %d%n%n", somaresult);
		
				}
		
		//Raio Circunferencia;
		static void areacirculo(Scanner sc) {
		double areacirc, pi;
		pi = 3.14159;
		
		double raio = lerDoubleSeguro(sc, "Digite o raio da circunferencia: ");
		
		areacirc = pi * (raio*raio);
		System.out.printf("Area do circulo: %.4f%n%n", areacirc);
		}
		
		//Diferença;
		
		static void diferenca(Scanner sc) {
			
		System.out.printf("A diferença é igual a A x B - C x D%n%n");
	
		int A = lerIntSeguro(sc, "Digite A: ");
		int B = lerIntSeguro(sc, "Digite B: ");
		int C = lerIntSeguro(sc, "Digite C: ");
		int D = lerIntSeguro(sc,"Digite D: ");
		
		int DIF = (A * B - C * D);
		
		System.out.printf("DIFERENCA = %d%n%n", DIF);	
		
		}
		
		//Funcionário;
		static void funcionario(Scanner sc) {
		
		int numero = lerIntSeguro(sc, "Digite o numero de identificação do funcionario: ");
		double horas = lerDoubleSeguro(sc, "Digite as horas de trabalho: ");
		double minimo = lerDoubleSeguro(sc, "Digite o salario por hora: ");
		double salar = minimo * horas;
		
		System.out.printf("O funcionário de NUMBER = %d%n Recebe SALARY de = U$%.2f%n%n", numero, salar);	
		}
		
		//Peças - POO;
		
		static void pecas(Scanner sc) {
		Peca peca1 = new Peca();
		Peca peca2 = new Peca();
		
		System.out.println("===Digite as caracteristicas da peça 1===%n");
		peca1.codigo = lerIntSeguro(sc, "Numero de Identificação: ");
		peca1.quantidade = lerIntSeguro(sc,"Quantidade solicitada: ");
		peca1.valorUnitario = lerDoubleSeguro(sc, "Valor Unitário da Peça: ");
		
		String resp;
		do {
		
		System.out.println("Deseja adcionar uma segunda peça? (S/N): ");
		resp = sc.next().toUpperCase();
		
		} while (!resp.equals("S") && !resp.equals("N"));
		
		if (resp.equals("S")) {
			
		System.out.println("===Digite as caracteristicas da peça 2===%n");
		peca2.codigo = lerIntSeguro(sc, "Numero de Identificação: ");
		peca2.quantidade = lerIntSeguro(sc,"Quantidade solicitada: ");
		peca2.valorUnitario = lerDoubleSeguro(sc, "Valor Unitário da Peça: ");
		
		} else {
			peca2.quantidade = 0;
			peca2.valorUnitario = 0.0;
		}
		
		double total = peca1.calcularTotal() + peca2.calcularTotal();
		
		System.out.printf("Valor a pagar: R$%.2f%n", total);	
		
	}

}

class Peca {
	
	int codigo;
	int quantidade;
	double valorUnitario;
	
	double calcularTotal() {
		return quantidade *valorUnitario;
	}
}

