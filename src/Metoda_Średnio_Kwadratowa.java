import java.util.Scanner;

public class Metoda_Średnio_Kwadratowa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        System.out.print("N: ");
        n = input.nextInt();

        var tab = new double[2][n];

        for (int i=0; i<n; i++) {
            System.out.print("X:" + (i+1) + ": ");
            tab[0][i] = input.nextDouble();

            System.out.print("Y:" + (i+1) + ": ");
            tab[1][i] = input.nextDouble();
        }

        for (int i=0;i<2;i++) {
            for (int j=0;j<n;j++) {
                System.out.print(tab[i][j] + "  \t");
            }
            System.out.println();
        }

        System.out.println();

        double[][] evaluates = new double[n][7];

        for (int i=0;i<n;i++) {
            evaluates[i][0] = tab[0][i];
            evaluates[i][1] = tab[1][i];
            evaluates[i][2] = Math.pow(evaluates[i][0], 0);
            evaluates[i][3] = Math.pow(evaluates[i][0], 1);
            evaluates[i][4] = Math.pow(evaluates[i][0], 2);
            evaluates[i][5] = evaluates[i][1]*evaluates[i][2];
            evaluates[i][6] = evaluates[i][1]*evaluates[i][3];
        }

        double s0 = 0, s1 = 0, s2 = 0, t0 = 0, t1 = 0;
        for (int i=0; i<n; i++) {
            s0 += evaluates[i][2];
            s1 += evaluates[i][3];
            s2 += evaluates[i][4];
            t0 += evaluates[i][5];
            t1 += evaluates[i][6];
        }

        double pierwszyWiersz[] = { s0, s1, t0 };
        double drugiWiersz[] = { s1, s2, t1 };


        double wspolczynnik = (-1.0)*pierwszyWiersz[0]/drugiWiersz[0];
        for (int i=0;i<3; i++) drugiWiersz[i] *= wspolczynnik;

        double[] sum = new double[2];
        sum[0] = pierwszyWiersz[1] + drugiWiersz[1];
        sum[1] = pierwszyWiersz[2] + drugiWiersz[2];

        double first = sum[1]/sum[0];
        double second = (-pierwszyWiersz[1]*first + pierwszyWiersz[2])/pierwszyWiersz[0];

        System.out.println("y = " + first + "x + " + second);
    }
}
