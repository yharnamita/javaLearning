package exercicios;
import java.util.Locale;
import java.util.Scanner;

//EXERCICIO COM VETORES

public class Exercicio13 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos numeros voce vai digitar? ");
        int n = sc.nextInt();

        // garante que n não seja maior que 10
        if (n > 10) {
            n = 10;
        }

        int[] vetor = new int[n];

        // leitura dos números
        for (int i = 0; i < n; i++) {
            System.out.print("Digite um numero: ");
            vetor[i] = sc.nextInt();
        }

        System.out.println();
        System.out.println("NUMEROS NEGATIVOS:");

        // impressão dos negativos
        for (int i = 0; i < n; i++) {
            if (vetor[i] < 0) {
                System.out.println(vetor[i]);
            }
        }

        sc.close();
    }
}
