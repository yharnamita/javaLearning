package exercicios;

import java.util.Random;
import java.util.Scanner;

public class Exercicio28 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Campo campo = new Campo(5, 5, 5);

        boolean perdeu = false;

        while (!campo.venceu() && !perdeu) {

            campo.mostrar();

            int linha = Utility.lerIntervaloInt(sc,
                    "Linha (1 a 5): ", 1, 5) - 1;

            int coluna = Utility.lerIntervaloInt(sc,
                    "Coluna (1 a 5): ", 1, 5) - 1;

            if (campo.abrir(linha, coluna)) {

                perdeu = true;

                campo.mostrarCompleto();

                System.out.println("\n BOOM! Voce perdeu!");

            }
        }

        if (campo.venceu()) {

            campo.mostrarCompleto();

            System.out.println("\n PARABENS! VOCE VENCEU!");
        }

        sc.close();
    }

    // ================= CLASSE CAMPO =================

    static class Campo {

        private int linhas;
        private int colunas;
        private int minas;

        private char[][] tabuleiro;
        private boolean[][] aberto;

        public Campo(int linhas, int colunas, int minas) {

            this.linhas = linhas;
            this.colunas = colunas;
            this.minas = minas;

            tabuleiro = new char[linhas][colunas];
            aberto = new boolean[linhas][colunas];

            inicializar();
        }

        private void inicializar() {

            // Inicializa vazio
            for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < colunas; j++) {

                    tabuleiro[i][j] = '0';
                    aberto[i][j] = false;
                }
            }

            sortearMinas();
            calcularNumeros();
        }

        private void sortearMinas() {

            Random rand = new Random();

            int colocadas = 0;

            while (colocadas < minas) {

                int l = rand.nextInt(linhas);
                int c = rand.nextInt(colunas);

                if (tabuleiro[l][c] != '*') {

                    tabuleiro[l][c] = '*';
                    colocadas++;
                }
            }
        }

        private void calcularNumeros() {

            for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < colunas; j++) {

                    if (tabuleiro[i][j] == '*') continue;

                    int cont = contarMinas(i, j);

                    tabuleiro[i][j] = (char) (cont + '0');
                }
            }
        }

        private int contarMinas(int l, int c) {

            int cont = 0;

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {

                    int nl = l + i;
                    int nc = c + j;

                    if (nl >= 0 && nl < linhas &&
                        nc >= 0 && nc < colunas &&
                        tabuleiro[nl][nc] == '*') {

                        cont++;
                    }
                }
            }

            return cont;
        }

        public boolean abrir(int l, int c) {

            if (aberto[l][c]) return false;

            aberto[l][c] = true;

            if (tabuleiro[l][c] == '*') {

                return true; // perdeu
            }

            return false;
        }

        public void mostrar() {

            System.out.println("\n  1 2 3 4 5");

            for (int i = 0; i < linhas; i++) {

                System.out.print((i + 1) + " ");

                for (int j = 0; j < colunas; j++) {

                    if (aberto[i][j]) {

                        System.out.print(tabuleiro[i][j] + " ");

                    } else {

                        System.out.print("# ");
                    }
                }

                System.out.println();
            }
        }

        public void mostrarCompleto() {

            System.out.println("\n  1 2 3 4 5");

            for (int i = 0; i < linhas; i++) {

                System.out.print((i + 1) + " ");

                for (int j = 0; j < colunas; j++) {

                    System.out.print(tabuleiro[i][j] + " ");
                }

                System.out.println();
            }
        }

        public boolean venceu() {

            int fechadas = 0;

            for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < colunas; j++) {

                    if (!aberto[i][j] &&
                        tabuleiro[i][j] != '*') {

                        fechadas++;
                    }
                }
            }

            return fechadas == 0;
        }
    }

    // ================= UTILITY =================

    static class Utility {

        static int lerIntSeguro(Scanner sc, String msg) {

            while (true) {

                String texto = evitarLinhaVazia(sc, msg);

                try {

                    return Integer.parseInt(texto);

                } catch (Exception e) {

                    System.out.println("=== APENAS NUMEROS ===");
                }
            }
        }

        static int lerIntervaloInt(Scanner sc,
                                  String msg,
                                  int min,
                                  int max) {

            while (true) {

                int v = lerIntSeguro(sc, msg);

                if (v < min || v > max) {

                    System.out.printf(
                        "=== ENTRE %d E %d ===%n",
                        min, max
                    );

                } else {

                    return v;
                }
            }
        }

        static String evitarLinhaVazia(Scanner sc,
                                      String msg) {

            while (true) {

                System.out.print(msg);

                String t = sc.nextLine().trim();

                if (!t.isEmpty()) return t;

                System.out.println("=== DIGITE ALGO ===");
            }
        }
    }
}
