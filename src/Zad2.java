import java.util.function.DoubleFunction;

public class Zad2 {

    private static final double DX = 0.001;
    private static DoubleFunction<Double> dervie(DoubleFunction<Double> f) {
        return (x) -> (f.apply(x + DX));
    }

    public static void main(String[] args) {
       DoubleFunction<Double> funk = (x) -> Math.pow(x,3) + x-1;
       double x0,x1,f0,f1;
       x0 = -0;
       double E = 0.001;
       x1 = x0 - f(x0)/dervie(funk).apply(x0);
       f0 = f(x0);
       while(Math.abs(x1-x0) > E && Math.abs(f0) > E){
           f1 = dervie(funk).apply(x0);
           if(Math.abs(f1) < E){
               System.out.println("error");
               break;
           }
           x1 = x0;
           x0 = x0 - f0 / f1;
           f0 = f(x0);
       }
       if(x0==0){
           System.out.println("Nie spełnia");
       }
        System.out.println("Nasze x = " + x0);
    }
    public static double f(double x){
        return Math.pow(x,3) + x-1;
    }
}
