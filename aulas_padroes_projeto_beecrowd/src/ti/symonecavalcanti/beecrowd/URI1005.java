package ti.symonecavalcanti.beecrowd;

import java.util.Scanner;

public class URI1005 {
    public static void main(String[] args) {

        Scanner num = new Scanner(System.in);

        double nota1 = num.nextDouble();
        double nota2 = num.nextDouble();

        double peso1 = 3.5;
        double peso2 = 7.5;

        double media = ((nota1 * peso1) + (nota2 * peso2)) / (peso1 + peso2);

        System.out.printf("MEDIA = %.5f\n" , media);
    }
}
