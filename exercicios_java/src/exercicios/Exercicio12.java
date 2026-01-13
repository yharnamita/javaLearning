package exercicios;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio12{
	
	 public static void main(String[] args) {
	        Locale.setDefault(Locale.US);
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Informe o número da conta: ");
	        int numero = sc.nextInt();

	        System.out.print("Informe o nome do titular: ");
	        sc.nextLine();
	        String titular = sc.nextLine();

	        System.out.print("Haverá depósito inicial (S/N)? ");
	        char resp = sc.next().toUpperCase().charAt(0);

	        Conta conta;

	        if (resp == 'S') {
	            System.out.print("Informe o valor do depósito inicial: ");
	            double depositoInicial = sc.nextDouble();
	            conta = new Conta(numero, titular, depositoInicial);
	        } else {
	            conta = new Conta(numero, titular);
	        }

	        System.out.println("\nDados da conta:");
	        System.out.println(conta);

	        System.out.print("\nInforme um valor para depósito: ");
	        double valorDeposito = sc.nextDouble();
	        conta.deposito(valorDeposito);

	        System.out.println("Dados atualizados:");
	        System.out.println(conta);

	        System.out.print("\nInforme um valor para saque: ");
	        double valorSaque = sc.nextDouble();
	        conta.saque(valorSaque);

	        System.out.println("Dados atualizados:");
	        System.out.println(conta);

	        sc.close();
	    }
}
			
		//==================================================================================================	
			
			class Conta {
				private int numero;
				private String titular;
				private double saldo;
				
				public Conta(int numero, String titular) {
					
					this.numero = numero;
					this.titular = titular;
					this.saldo = 0.0;
				}
				
				public Conta(int numero, String titular, double depositoInicial) {
					
					this.numero = numero;
					this.titular = titular;
					this.saldo = depositoInicial;
				
			}

				public String getTitular() {
					return titular;
				}

				public void setTitular(String titular) {
					this.titular = titular;
				}

				public int getNumero() {
					return numero;
				}

				public double getSaldo() {
					return saldo;
				}

				public void deposito(double valor) {
			        saldo += valor;
			    }

			    public void saque(double valor) {
			        saldo -= valor + 5.0;
			    }
			    
			   @Override
			   public String toString() {
			        return "Conta "
			             + numero
			             + ", Titular: "
			             + titular
			             + ", Saldo: R$ "
			             + String.format("%.2f", saldo);
			    }
				
		}
		