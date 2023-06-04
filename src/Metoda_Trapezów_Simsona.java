import umontreal.iro.lecuyer.functions.MathFunction;
import umontreal.iro.lecuyer.functions.MathFunctionUtil;

public class Metoda_Trapezów_Simsona {
    public static void main(String[] args) {
            double a = 1;
            double b = 4;
            MathFunction fun = (x) -> Math.pow((x),2);
            double fa = fun.evaluate(a);
            System.out.println("fa:");
            System.out.println(fa);
            double fb = fun.evaluate(b);
            System.out.println("fb:");
            System.out.println(fb);
            double S = ((b-a)/2)*(fa+fb);
            System.out.println("S:");
            System.out.println(S);
            double ksi = Math.max(fa,fb);
            System.out.println("ksi:");
            System.out.println(ksi);
            double B = (-1.0/12.0)*Math.pow((b-a),3)* MathFunctionUtil.derivative(fun,ksi,2);
            double C = S + B;
            System.out.println("Trapez: "+C);
            System.out.println("Całka: " + B);
            System.out.println();

            double hand = fun.evaluate((a+b)/2);
            double S2 = ((b-a)/6)*(fa+fb+4*hand);
            double B2 = (-1.0/90.0)*Math.pow((b-a),5)*MathFunctionUtil.derivative(fun,ksi,4);
            double C2 = S2 + B2;
            System.out.println("Simson: "+C2);
            System.out.println("Całka: " + B2);
    }
}
