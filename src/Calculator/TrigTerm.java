// TrigTerm class:
// This handles trigonometric functions, like sin(x) or cos(x).
// The derivative follows the trig rules. For example, the derivative of sin(x) is cos(x), and the derivative of cos(x) is -sin(x).
// When you evaluate it, you plug in a value for x and calculate the sine or cosine of that number (in radians).


package Calculator;

public class TrigTerm implements ITerm {
    private int a; //for our coefficient
    private TrigType type; // either sine or cosine

    public TrigTerm(int a, TrigType type){
        this.a = a;
        this.type = type;
    }

    @Override
    public ITerm derivative() {
        return null;
    }

    @Override
    public double evaluate(double x) {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
