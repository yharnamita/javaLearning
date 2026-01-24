package exercicios;

import java.util.Scanner;

//EXERCICIO COM THREADS

public class Exercicio19 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String fraseA = Utility.evitarLinhaVazia(sc, "Digite a primeira frase: ");
		String fraseB = Utility.evitarLinhaVazia(sc, "Digite a segunda frase: ");

		Alternador alt = new Alternador(fraseA, fraseB);

		Thread t1 = new Thread(new MensagemTask(alt, true));
		Thread t2 = new Thread(new MensagemTask(alt, false));

		t1.start();
		t2.start();

		Alternador.esperarEnter(sc, "\nPrecione ENTER para parar...\n");

		alt.parar();

		System.out.println("=== ENCERRAMOS AQUI, TENHA UM BOM DIA ===");

		sc.close();
	}

	static class MensagemTask implements Runnable {

		private Alternador alternador;
		private boolean isA;

		public MensagemTask(Alternador alternador, boolean isA) {
			this.alternador = alternador;
			this.isA = isA;
		}

		@Override
		public void run() {

			if (isA) {
				alternador.executarA();
			} else {
				alternador.executarB();
			}

		}
	}

	static class Alternador {

		private boolean vezA = true;
		private boolean ativo = true;

		private String msgA;
		private String msgB;

		public Alternador(String msgA, String msgB) {
			this.msgA = msgA;
			this.msgB = msgB;
		}

		public synchronized void parar() {
			ativo = false;
			notifyAll();
		}

		public void executarA() {
			try {
				while (true) {
					synchronized (this) {
						while (ativo && !vezA) {
							wait();
						}
						if (!ativo)
							break;

						System.out.println(msgA);
						vezA = false;
						notifyAll();
					}
					Thread.sleep(500);
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		public void executarB() {
			try {
				while (true) {
					synchronized (this) {
						while (ativo && vezA) {
							wait();
						}
						if (!ativo)
							break;

						System.out.println(msgB);
						vezA = true;
						notifyAll();
					}
					Thread.sleep(500);
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		static void dormir(long millis) {
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		static void esperarEnter(Scanner sc, String mensagem) {
			System.out.print(mensagem);
			sc.nextLine();
		}

	}

	static class Utility {

		// SOMENTE O NECESSARIO (O EXTRAORDINARIO É DEMAIS)

		// metodo para evitar leitura vazia na string
		static String evitarLinhaVazia(Scanner sc, String mensagem) {

			while (true) {
				System.out.print(mensagem);
				String texto = sc.nextLine().trim();

				if (texto.isEmpty()) {
					System.out.println("=== DIGITE ALGUMA COISA ====");
					continue;
				}

				return texto;
			}
		}

	}

}
