// ConstantTerm class:
// This is for constant numbers like 5 or -3. These are terms that don't have an x (they're just plain numbers).
// The derivative of any constant is always 0 because constants don't change.
// If you evaluate it (like ask "what's 5 when x = 2?"), it'll always give you the constant itself (so, just 5).

package Calculator;

public class ConstantTerm implements ITerm {
    private int a;

    public ConstantTerm(int a){ //constructor to set the constant value a
        this.a = a;
    }

    @Override
    public ITerm derivative(){ //this comes straight out of the interface
        return null; //derivative of a constant is always 0 aka nothing
    }

    @Override
    public double evaluate(double x) { //also part of the interface
        return a; //evaluating at a constant is just the constant itself
    }

    @Override
    public String toString(){ //also part of the interface
        if (a == 0){
            return ""; //for the string, we will return nothing because its zero
        }
        return (a > 0 ? "+ ": "- ") + Math.abs(a); //if our value is greater than zero include positive sign
        //if not, then include negative sign along with abs value of the number itself
    }
}
