import umontreal.iro.lecuyer.functions.MathFunctionUtil;

import java.util.Scanner;

public class Metoda_Siecznych {
    public static void main(String[] args) {
        var function = new MyFunction();
        var input = new Scanner(System.in);

        double x0, x1, epsilon;

        System.out.print("Podaj poczatek przedzialu: ");
        x0 = input.nextDouble();

        System.out.print("Podaj koniec przedzialu: ");
        x1 = input.nextDouble();

        System.out.print("Podaj dokladnosc: ");
        epsilon = input.nextDouble();

        if (function.evaluate(x0) * function.evaluate(x1) < 0) {

            double f0 = function.evaluate(x0);
            double f1 = function.evaluate(x1);
            double x2, f2;
            int counter = 0;

            double fprimprim = MathFunctionUtil.derivative(function, x1, 2);

            if (function.evaluate(x1)*fprimprim > 0) {
                double tempF = f0;
                double temp = x0;
                x0 = x1;
                x1 = temp;

                f0 = f1;
                f1 = tempF;
            }


            do {
                x2 = x1 - f1 * (x1 - x0) / (f1 - f0);
                f2 = function.evaluate(x2);
                x0 = x1;
                x1 = x2;
                f0 = f1;
                f1 = f2;

                counter++;
            } while (Math.abs(f2) > epsilon);

            System.out.println("Liczba iteracji: " + counter);
            System.out.println("Miejsce zerowe jest w  " + x2);

        } else System.out.println("W tym przedziale najpewniej nie ma miejsca zerowego.");
    }
}
