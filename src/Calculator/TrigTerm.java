// TrigTerm class:
// This handles trigonometric functions, like sin(x) or cos(x).
// The derivative follows the trig rules. For example, the derivative of sin(x) is cos(x), and the derivative of cos(x) is -sin(x).
// When you evaluate it, you plug in a value for x and calculate the sine or cosine of that number (in radians).


package Calculator;

public class TrigTerm implements ITerm {
    private final int a; //for our coefficient
    private final TrigType type; // either sine or cosine

    public TrigTerm(int a, TrigType type){
        this.a = a; //coefficient
        this.type = type;
    }

    @Override
    public ITerm derivative() {
        if (a == 0){
            return null; //if the coefficient of our trig term is zero, then
            //everything becomes zero
        }
        //derivative of sine is cosine, derivative of cosine is negative sine
        if (type == TrigType.SINE) {
            return new TrigTerm(a, TrigType.COSINE);
        } else{
            return new TrigTerm(-a, TrigType.SINE);
        }
    }

    //evaluate the term for a given x and we use the Math.sin and Math.cos to do so
    @Override
    public double evaluate(double x) {
        double radians = Math.toRadians(x);
        if (type == TrigType.SINE){
            return a * Math.sin(radians); //this evaluates sin * x which is now in radians
        }else {
            return a * Math.cos(radians);//same here but for cosine
        }
    }

    @Override
    public String toString() {
        if (a == 0){
            return "";//no need to return anything if a is 0
        }
        String sign = (a > 0) ? "+ " : "- ";
        int absA = Math.abs(a);
        String coeff = (absA == 1) ? "" : Integer.toString(absA);
        String function = (type == TrigType.SINE) ? "sin(x) " : "cos(x) ";
        return sign + coeff + function;
    }

    public TrigType getType(){
        return type;
    }
}
