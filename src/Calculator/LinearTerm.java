// LinearTerm class:
// This is for terms like 5x or -3x. Basically, it's numbers that are multiplied by x.
// The derivative of something like 5x is just the number in front, so the derivative of 5x is 5.
// If you evaluate it (like for x = 2), you just multiply the number by whatever x is (so, 5 * 2 = 10).


package Calculator;

public class LinearTerm implements ITerm {
    private int a;

    public LinearTerm(int a){
        this.a = a;
    }

    @Override
    public ITerm derivative() {
        return new ConstantTerm(a); // the derivative of ax is just a
    }

    @Override
    public double evaluate(double x) {
        return a * x; //evaluate our linear term by computing a times x
    }

    @Override
    public String toString() {
        if (a == 0){
            return "";
        }
        String sign = a > 0 ? "+ ": "- ";
        int absA = Math.abs(a);
        String coeff = (absA == 1) ? "": Integer.toString(absA);
        return sign + coeff + "x";
    }
}
