// Main class:
// We will actually run everything here.
// In here, we’ll create expressions with different terms, calculate their derivatives, evaluate them for different values of x,
// and print the results to see if it’s working right.


package Calculator;

public class Main {
    public static void main(String[] args) {
        //test run
        ConstantTerm constantTerm = new ConstantTerm(5);
        LinearTerm linearTerm = new LinearTerm(7);
        PolynomialTerm polynomialTerm = new PolynomialTerm(4, 3);
        ITerm linearDerivative = linearTerm.derivative();
        ITerm polynomialDerivative = polynomialTerm.derivative();
        TrigTerm trigTerm = new TrigTerm(4, TrigType.SINE);
        ITerm trigDerivative = trigTerm.derivative();


        System.out.println("Constant term evaluated at x = 4: " + constantTerm.evaluate(4));
        System.out.println("Constant term toString: " + constantTerm);

        System.out.println("Linear term evaluated at x = 4: " + linearTerm.evaluate(4));
        System.out.println("Linear term toString: " + linearTerm);
        System.out.println("Linear Term derivative: " + linearDerivative);

        System.out.println("Polynomial term evaluated at x = 4: " + polynomialTerm.evaluate(4));
        System.out.println("Polynomial term toString: " + polynomialTerm);
        System.out.println("Polynomial Term derivative: " + polynomialDerivative);

        System.out.println("Trig term evaluated at x = 4: " + trigTerm.evaluate(4));
        System.out.println("Trig term toString: " + trigTerm);
        System.out.println("Trig Term derivative: " + trigDerivative);

        }
    }
