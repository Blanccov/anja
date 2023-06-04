import java.util.Scanner;

public class Metoda_Stycznych_Newtona {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double x1, x2, epsilon;

        System.out.print("Poczatek przedzialu: ");
        x1 = input.nextDouble();

        System.out.print("Koniec przedzialu: ");
        x2 = input.nextDouble();

        System.out.print("Dokladnosc: ");
        epsilon = input.nextDouble();

        if (f(x1)*f(x2)<0) {

            double x=0;
            double temp;
            int counter = 0;
            if (f(x1)*ddf(x1)>0) x = x1;
            if (f(x2)*ddf(x2)>0) x = x2;

            do {
                temp = x;
                if (x==x1) x = x - f(x2)/df(x2);
                else if (x==x2) x = x - f(x2)/df(x2);
                else x = x - f(temp)/df(temp);
                counter++;

            } while (Math.abs(f(x))>epsilon);

            System.out.println("Miejsce zerowe w " + x + ", odbyto " + counter + " iteracji.");

        } else System.out.println("Brak miejsc zerowych w zadanym przedziale.");
    }

    public static double f(double x) {
        return Math.pow(x,3) + x -1;
    }

    public static double df(double x) {
        return 3*x*x+1;
    }

    public static double ddf(double x) {
        return 6*x;
    }

}
