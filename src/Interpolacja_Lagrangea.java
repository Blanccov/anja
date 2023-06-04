import java.util.Scanner;

public class Interpolacja_Lagrangea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        System.out.print("Wartość n: ");
        n = input.nextInt();

        var tab = new double[2][n];

        for (int i=0; i<n; i++) {
            System.out.print("x" + (i+1) + ": ");
            tab[0][i] = input.nextDouble();

            System.out.print("y" + (i+1) + ": ");
            tab[1][i] = input.nextDouble();
        }

        System.out.println();
        System.out.println("Tabelka");

        for (int i=0;i<2;i++) {
            for (int j=0;j<n;j++) {
                System.out.print(tab[i][j] + "  \t");
            }
            System.out.println();
        }

        System.out.println();

        String wzor = "";

        for (int i=0;i<n;i++) {
            if (i==0) wzor += tab[1][i] + "*(";
            else wzor += " + " + tab[1][i] + "*(";


            String licznik = "";
            double mianownik = 1;
            for (int j=0;j<n;j++) {
                if (j==i) continue;

                if (j==0 || (i==0 && j==1)) licznik += "(x-(" + tab[0][j] + "))";
                else licznik += "*(x- (" + tab[0][j] + "))";
                mianownik *= (tab[0][i] - tab[0][j]);
            }

            wzor += "(" + licznik + ")" + "/(" + mianownik + ")";
            wzor += ")";
        }

        System.out.println(wzor);
    }
}
