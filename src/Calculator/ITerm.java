// ITerm interface:
// This is essentially a guideline for all types of terms, like constants, linear terms (like 5x), or polynomials.
// It makes sure that every term can do three things:
// 1. Calculate its derivative.
// 2. Be evaluated when you plug in a value for x.
// 3. Turn into a string so it looks like math when printed.

package Calculator;

public interface ITerm {
    //method to calculate the derivative of the term
    ITerm derivative();

    //method to evaluate the term for a given value of x
    double evaluate(double x);

    //method to return the term as a string
    @Override
    String toString();

}
