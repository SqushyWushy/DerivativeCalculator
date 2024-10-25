// Main class:
// We will actually run everything here.
// In here, we’ll create expressions with different terms, calculate their derivatives, evaluate them for different values of x,
// and print the results to see if it’s working right.


package Calculator;

public class Main {
    public static void main(String[] args) {
                //create terms for the expression
                ITerm term1 = new PolynomialTerm(4, 3);     //4x^3
                ITerm term2 = new LinearTerm(-7);             //-7x
                ITerm term3 = new TrigTerm(4, TrigType.SINE); //4sin(x)
                ITerm term4 = new TrigTerm(-9, TrigType.COSINE);//-9cos(x)
                ITerm term5 = new ConstantTerm(2);              //+2

                //create an expression and add all the terms
                Expression expression = new Expression();

                expression.add(term1);
                expression.add(term2);
                expression.add(term3);
                expression.add(term4);
                expression.add(term5);

                //print out original expression
                System.out.println("Original Expression: " + expression);

                //evaluate expression at given value, this case we will do 7
                double valueAT7 = expression.getEvaluation(7);
                System.out.printf("Evaluated Expression at x = 7: %.2f%n", valueAT7);

                //print out derivative of expression
                System.out.println("Derivative of Expression: " + expression.getDerivative());

                //evaluate the expression at given value of 7, in this case 7, of the derivative
                double derValueAt7 = expression.getDerivative().getEvaluation(7);
                System.out.printf("Derivative Evaluated at x = 7: %.2f%n", derValueAt7);





       /* this is all the code i tested throughout the program when making new terms
       //test run
//        ConstantTerm constantTerm = new ConstantTerm(5);
//        LinearTerm linearTerm = new LinearTerm(7);
//        PolynomialTerm polynomialTerm = new PolynomialTerm(4, 3);
//        TrigTerm trigTerm = new TrigTerm(4, TrigType.SINE);
//        ITerm linearDerivative = linearTerm.derivative();
//        ITerm polynomialDerivative = polynomialTerm.derivative();
//        ITerm trigDerivative = trigTerm.derivative();
//        ProjNode<ITerm> node1 = new ProjNode<>(constantTerm);
//        ProjNode<ITerm> node2 = new ProjNode<>(linearTerm);
//
//        System.out.println(polynomialTerm.toString() + trigTerm.toString() + constantTerm.toString());
//        node1.setNext(node2);
//        System.out.println(node1.getNext().getData());


//        System.out.println("Constant term evaluated at x = 4: " + constantTerm.evaluate(4));
//        System.out.println("Constant term toString: " + constantTerm);
//
//        System.out.println("Linear term evaluated at x = 4: " + linearTerm.evaluate(4));
//        System.out.println("Linear term toString: " + linearTerm);
//        System.out.println("Linear Term derivative: " + linearDerivative);
//
//        System.out.println("Polynomial term evaluated at x = 4: " + polynomialTerm.evaluate(4));
//        System.out.println("Polynomial term toString: " + polynomialTerm);
//        System.out.println("Polynomial Term derivative: " + polynomialDerivative);
//
//        System.out.println("Trig term evaluated at x = 4: " + trigTerm.evaluate(4));
//        System.out.println("Trig term toString: " + trigTerm);
//        System.out.println("Trig Term derivative: " + trigDerivative);

        */
        }
    }
