import java.util.Scanner;

public class Metoda_Najmniejszych_Kwadratów {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        System.out.print("N: ");
        n = input.nextInt();

        var tab = new double[2][n];

        for (int i=0; i<n; i++) {
            System.out.print("x:" + (i+1) + ": ");
            tab[0][i] = input.nextDouble();

            System.out.print("y:" + (i+1) + ": ");
            tab[1][i] = input.nextDouble();
        }

        for (int i=0;i<2;i++) {
            for (int j=0;j<n;j++) {
                System.out.print(tab[i][j] + "  \t");
            }
            System.out.println();
        }

        System.out.println();

        var rozwinietyWzor = new double[n][3];

        for (int i=0; i<n; i++) {
            rozwinietyWzor[i][0] = tab[0][i];
            rozwinietyWzor[i][1] = 1;
            rozwinietyWzor[i][2] = (-1)*tab[1][i];
        }

        var da = new double[n][3];
        var db = new double[n][3];
        for (int i=0;i<n;i++) {
            for (int j=0;j<rozwinietyWzor[i].length;j++) {
                da[i][j] = rozwinietyWzor[i][j];
                db[i][j] = rozwinietyWzor[i][j];
            }
        }

        for (int i=0; i<n; i++) {
            double mnoznik = 2*da[i][0];
            da[i][0] *= mnoznik;
            da[i][1] *= mnoznik;
            da[i][2] *= mnoznik;
        }
        double[] sumaDA = new double[3];
        for (double[] e : da) {
            sumaDA[0] += e[0];
            sumaDA[1] += e[1];
            sumaDA[2] += e[2];
        }

        for (int i=0; i<n; i++) {
            double mnoznik = 2*db[i][1];
            db[i][0] *= mnoznik;
            db[i][1] *= mnoznik;
            db[i][2] *= mnoznik;
        }
        double[] sumaDB = new double[3];
        for (double[] e : db) {
            sumaDB[0] += e[0];
            sumaDB[1] += e[1];
            sumaDB[2] += e[2];
        }

        double wspolczynnik = (-1.0)*sumaDA[0]/sumaDB[0];
        for (int i=0;i<3; i++) sumaDB[i] *= wspolczynnik;

        double[] sum = new double[2];
        sum[0] = sumaDA[1] + sumaDB[1];
        sum[1] = (-1.0)*(sumaDA[2] + sumaDB[2]);

        double B = sum[1]/sum[0];
        double A = (-sumaDA[1]*B - sumaDA[2])/sumaDA[0];

        System.out.println("y = " + A + "x + " + B);

    }
}
