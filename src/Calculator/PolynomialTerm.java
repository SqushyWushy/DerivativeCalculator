// PolynomialTerm class:
// This is for terms where x has an exponent, like 4x^3 or -2x^5.
// To get the derivative, you follow the power rule. For example, for 4x^3, you bring the exponent down (3 * 4 = 12)
// and then subtract 1 from the exponent (so it becomes 12x^2).
// When you evaluate it, you just plug in the value for x and do the math (like if x = 2, you'd calculate 4 * 2^3).


package Calculator;

public class PolynomialTerm implements ITerm {
    private int a; //this will be our coefficient term
    private int b; //this will be our exponent term

    public PolynomialTerm(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public ITerm derivative() {
        if (b == 0){ //the derivative of a constant term - anything to zero power of 0 is 1
            return null;
        } else if(b == 1){//if the exp is 1 then we get a linear term because anything to the power of 1
            //is just the value itself
            return new LinearTerm(a);
        }
        return new PolynomialTerm(a * b, b - 1); //this return a = a times b and b = b - 1
    }

    @Override
    public double evaluate(double x) {
        return a * Math.pow(x, b);
    }

    @Override
    public String toString() {
        if (a == 0){
            return "";//a zero in our term makes everything zero so return nothing
        }
        String sign = (a > 0) ? "+ " : "- ";
        int absA = Math.abs(a);
        String coeff = (absA == 1) ? "" : Integer.toString(absA);
        return sign + coeff + "x^" + b;
    }
}
