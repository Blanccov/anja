import umontreal.iro.lecuyer.functions.MathFunction;
import umontreal.iro.lecuyer.functions.MathFunctionUtil;

public class Function implements MathFunction {
    public double evaluate(double v) {
        return v*Math.sin(v);
    }

    public double deriverative(double v, int n) {
        return MathFunctionUtil.derivative(this, v, n);
    }
}