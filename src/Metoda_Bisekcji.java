import java.util.Scanner;

public class Metoda_Bisekcji {
    static double f(double x){
        return Math.pow(x, 2) + 2*x - 1;
    }

    public static void main(String[] args) {

        double dok = 0.00000001;
        double a = -2;
        double b = 1;
        double c = (a + b)/2;

        if(f(a)*f(b)>0){
            System.out.println("Niepoprawne dane");
        }
        else if(f(c)==0){
            System.out.println("Pierwiastkiem rownania jest " + c);
        }
        else {
            while (Math.abs(f(c)) > dok) {
                c = (a + b) / 2;
                if (f(c) * f(a) < 0) {
                    b = c;
                } else {
                    a = c;
                }
            }
            System.out.println("Pierwiastkiem rownania jest " + c);
        }
    }
}
