package exercicios;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio17 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos alunos serao digitados? ");
        int n = sc.nextInt();
        sc.nextLine(); // limpar buffer

        String[] nomes = new String[n];
        double[] nota1 = new double[n];
        double[] nota2 = new double[n];

        // leitura dos dados
        for (int i = 0; i < n; i++) {
            System.out.println("Digite nome, primeira e segunda nota do " + (i + 1) + "o aluno:");

            nomes[i] = sc.nextLine();
            nota1[i] = sc.nextDouble();
            nota2[i] = sc.nextDouble();
            sc.nextLine(); // limpar buffer
        }

        System.out.println("Alunos aprovados:");

        // verificação dos aprovados
        for (int i = 0; i < n; i++) {
            double media = (nota1[i] + nota2[i]) / 2.0;

            if (media >= 6.0) {
                System.out.println(nomes[i]);
            }
        }

        sc.close();
    }
}
