import umontreal.iro.lecuyer.functions.MathFunction;
import umontreal.iro.lecuyer.functions.MathFunctionUtil;

public class MyFunction implements MathFunction {
    public double evaluate(double v) {
        return 3*Math.pow(v, 5) - 4*Math.pow(v,3) - v - 1;
    }
    public double deriverative(double v, int number) {
        return MathFunctionUtil.derivative(this, v, number);
    }
}
