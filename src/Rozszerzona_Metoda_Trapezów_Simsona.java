import java.util.Scanner;

public class Rozszerzona_Metoda_Trapezów_Simsona {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a, b, value, ksi, error, h, temp;
        int n;
        var func = new MyFunction();

        System.out.print("Poczatek całki: ");
        a = input.nextDouble();
        System.out.print("Koniec całki: ");
        b = input.nextDouble();

        //Metoda złożonych trapezów
        System.out.print("Ilość przedzialow pomocniczych: ");
        n = input.nextInt();

        h = (b-a)/(n*1.0);
        temp = (func.evaluate(a) + func.evaluate(b))/2;

        for (double i=(a+h);i<=(b-h);i+=h) {
            temp += func.evaluate(i);
        }

        value = h * temp;

        if (func.evaluate(a)>=func.evaluate(b)) ksi = a;
        else ksi = b;

        error = (-1.0/12.0)*Math.pow(h,3)*func.deriverative(ksi, 2);

        System.out.println("Złożony wzór trapezów:");
        System.out.println(value + " + " + error + " = " + (value+error) + "\n");

        //Metoda złożonych parabol
        if (n%2==1) {
            System.out.println("N nieparzyste więc metoda nie zadziała");
        } else {
            h = (b - a) / (n * 1.0);
            temp = func.evaluate(a) + func.evaluate(b);

            for (double i = (a + h); i <= (b - h); i += h) {
                temp += 2 * func.evaluate(i) + 4 * func.evaluate(i + h);
            }

            value = (h / 6.0) * temp;

            if (func.evaluate(a) >= func.evaluate(b)) ksi = a;
            else ksi = b;

            error = (-n / 90.0) * Math.pow(h / 2.0, 5) * func.deriverative(ksi, 4);

            System.out.println("Złożony wzór parabol:");
            System.out.println(value + " + " + error + " = " + (value + error) + "\n");
        }

    }
}
