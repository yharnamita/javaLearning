package exercicios;
import java.util.Scanner;


//Esse exercicio gera um menu onde o usuario pode cadastrar uma senha de acesso e testar se ela funcionou


public class Exercicio04{

	static Integer senha = null; //variavel senha
	
	public static void main(String[] args) {
		
		//menu
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
				System.out.println("\n=== DIGITE APENAS NÚMEROS ===");
				sc.next();
			}
		}
	}
	
			//Cadastro de senha
			static void cadastrarSenha(Scanner sc) {
				
			senha = lerIntSeguro(sc, "\nCadastre uma Senha numérica: ");
			System.out.println("\n=== SENHA CADASTRADA COM SUCESSO ===");
				
			}
			
			//verificação da senha
			static void verificarSenha(Scanner sc) {
				
			if (senha == null) {
				System.out.println("\n=== VOCÊ NÃO CADASTROU UMA SENHA ===");
				return;
			}
			
			int acesso = lerIntSeguro(sc, "\nDigite a sua senha: ");
			
			if (acesso == senha) {
				System.out.println("\n=== ACESSO PERMITIDO ===");
				
			} else {
				System.out.println("\n=== SENHA INCORRETA ===");
			}
			
			
		}
	}
