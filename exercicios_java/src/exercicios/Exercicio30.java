package exercicios;

import java.util.Scanner;

public class Exercicio30 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Labirinto lab = new Labirinto();

		lab.jogar(sc);

		sc.close();
	}

	// ================= LABIRINTO =================

	static class Labirinto {

		private char[][] mapa = {

				{ '#', '#', '#', '#', '#', '#', '#' }, 
				{ '#', 'P', '.', '.', '#', '.', '#' },
				{ '#', '#', '#', '.', '#', '.', '#' }, 
				{ '#', '.', '.', '.', '.', '.', '#' },
				{ '#', '.', '#', '#', '#', '.', '#' }, 
				{ '#', '.', '.', '.', '#', 'S', '#' },
				{ '#', '#', '#', '#', '#', '#', '#' } 
				
		};

		private int jogadorL = 1;
		private int jogadorC = 1;

		public void jogar(Scanner sc) {

			System.out.println("=== LABIRINTO ===");
			System.out.println("Use W A S D\n");

			while (true) {

				mostrar();

				System.out.print("Mover: ");

				String mov = sc.nextLine().toUpperCase();

				if (mov.isEmpty())
					continue;

				char c = mov.charAt(0);

				if (mover(c)) {

					System.out.println("\n=== VOCE VENCEU! ===");
					break;
				}
			}
		}

		private void mostrar() {

			System.out.println();

			for (int i = 0; i < mapa.length; i++) {

				for (int j = 0; j < mapa[i].length; j++) {

					System.out.print(mapa[i][j] + " ");
				}

				System.out.println();
			}
		}

		private boolean mover(char c) {

			int nl = jogadorL;
			int nc = jogadorC;

			switch (c) {

			case 'W':
				nl--;
				break;
			case 'S':
				nl++;
				break;
			case 'A':
				nc--;
				break;
			case 'D':
				nc++;
				break;

			default:
				System.out.println("Use W A S D");
				return false;
			}

			if (mapa[nl][nc] == '#') {

				System.out.println("Parede!");
				return false;
			}

			if (mapa[nl][nc] == 'S') {

				return true;
			}

			mapa[jogadorL][jogadorC] = '.';

			jogadorL = nl;
			jogadorC = nc;

			mapa[jogadorL][jogadorC] = 'P';

			return false;
		}
	}
}
