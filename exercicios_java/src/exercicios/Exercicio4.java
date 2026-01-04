package exercicios;
import java.util.Scanner;

public class Exercicio4{

	static Integer senha = null;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int menu =-1;
		while (menu !=0) {
			 System.out.println("\n=== ESCOLHA A OPERAÇÃO ===");
	         System.out.println("1 - Cadastro de Senha");
	         System.out.println("2 - Verificar Senha");
	         System.out.println("0 - Sair");
	         System.out.print("Opção: ");
	        
			
			try{
	        	 menu = sc.nextInt();
	         
	        	 switch (menu) {
	         		case 1: cadastrarSenha(sc); break;
	         		case 2: verificarSenha(sc); break;
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
	
			static void cadastrarSenha(Scanner sc) {
				
			senha = lerIntSeguro(sc, "Cadastre uma Senha numérica: ");
			System.out.println("===Senha Cadastrada com sucesso===");
				
			}
			
			static void verificarSenha(Scanner sc) {
				
			if (senha == null) {
				System.out.println("===Você não cadastrou uma senha===");
				return;
			}
			
			int acesso = lerIntSeguro(sc, "Digite a sua senha: ");
			
			if (acesso == senha) {
				System.out.println("===ACESSO PERMITIDO===");
				
			} else {
				System.out.println("===SENHA INCORRETA===");
			}
			
			
		}
	}
