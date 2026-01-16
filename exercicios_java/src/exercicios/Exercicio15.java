package exercicios;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio15 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas pessoas voce vai digitar? ");
        int n = sc.nextInt();

        String[] nomes = new String[n];
        int[] idades = new int[n];

        // leitura dos dados
        for (int i = 0; i < n; i++) {
            System.out.println("Dados da " + (i + 1) + "a pessoa:");
            System.out.print("Nome: ");
            nomes[i] = sc.next();

            System.out.print("Idade: ");
            idades[i] = sc.nextInt();
        }

        // encontrar a pessoa mais velha
        int maiorIdade = idades[0];
        int posicaoMaisVelha = 0;

        for (int i = 1; i < n; i++) {
            if (idades[i] > maiorIdade) {
                maiorIdade = idades[i];
                posicaoMaisVelha = i;
            }
        }

        System.out.println();
        System.out.println("PESSOA MAIS VELHA: " + nomes[posicaoMaisVelha]);

        sc.close();
    }
}
