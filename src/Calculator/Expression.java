// Expression class:
// This is where we bring all the terms together to make an entire equation, like 5x + 4x^3 - sin(x).
// It handles a few key things:
// 1. It stores all the terms in a linked list.
// 2. It can find the derivative of the whole equation by getting the derivative of each term.
// 3. It can evaluate the equation by plugging in a value for x and adding up the results of each term.
// 4. It turns the full equation into a nice string so it looks like math when printed.


package Calculator;
import java.util.ArrayList; //our resizable array for our terms
import java.util.Comparator; //helps create a custom sorting order

public class Expression {
    private final ProjLinkedList<ITerm> terms;

    public Expression(){//our constructor to create an empty list terms
        terms = new ProjLinkedList<>();
    }

    public void add(ITerm term){//method to add new terms to expression
        if (term != null) {//edge case in case term is null - we don't want that
            terms.add(term);//terms is our list and term is a single term to add to list
        }
    }

    public Expression getDerivative() {
        //we are going to create a new expression aka a new linked list for the derivatives
        Expression derivativeExpression = new Expression();
        //start at the head of our terms LL
        ProjNode<ITerm> current = terms.getHead();

        while (current != null){//loop through each term in our terms LL
            ITerm derivativeTerm = current.getData().derivative();//get current - head derivative
            if (derivativeTerm != null){ //exclude our zeroes
                derivativeExpression.add(derivativeTerm); //add this value to the new expression
            }
            current = current.getNext(); //set new current value to next to traverse
        }
        return derivativeExpression; //return our second expression composed of terms LL derivatives
    }

    //this method is going to evaluate at our expression at a given value of x
    public double getEvaluation(double x){
        ProjNode<ITerm> current = terms.getHead(); //start at the head
        double sum = 0; //initialize sum variable
        while (current != null){ //loop through our expression
            sum += current.getData().evaluate(x);//evaluate current term and add to sum total
            current = current.getNext(); //traverse to next node if one exists
        }
        return sum; //return the total value of the sum
    }

    @Override
    public String toString(){
        //create list to store terms from the LL
        ArrayList<ITerm> termList = new ArrayList<>();
        //start at list of LL to collect
        ProjNode<ITerm> current = terms.getHead();

        while (current != null){
            termList.add(current.getData());
            current = current.getNext();
        }
        //once we have entered our terms, we need to sort the terms in a specific order
        termList.sort(new Comparator<>() {
            @Override
            public int compare(ITerm t1, ITerm t2) {
                //define our order:
                //polynomial terms first with the exponent in descending order
                //then linear terms
                //then sin
                //then cosine
                //then constants

                int rank1 = getRank(t1);
                int rank2 = getRank(t2);

                if (rank1 != rank2) {
                    return rank1 - rank2; //lower rank comes first
                } else if (t1 instanceof PolynomialTerm && t2 instanceof PolynomialTerm) {
                    //for our polynomials, sort by the exponent in descending order
                    PolynomialTerm p1 = (PolynomialTerm) t1; //t1 in ITerm but exponent in poly term class
                    PolynomialTerm p2 = (PolynomialTerm) t2; //same here
                    return p2.getExponent() - p1.getExponent();
                } else {
                    return 0; // means ranks are same and also not polynomials
                }

            }

            private int getRank(ITerm t) {
                switch (t) {
                    case PolynomialTerm polynomialTerm -> {
                        return 1;
                    }
                    case LinearTerm linearTerm -> {
                        return 2;
                    }
                    case TrigTerm trigTerm -> {
                        if (trigTerm.getType() == TrigType.SINE) {
                            return 3;
                        } else {
                            return 4;
                        }
                    }
                    case ConstantTerm constantTerm -> {
                        return 5; //constant terms will always be last
                    }
                    case null, default -> {
                        return 6;
                    }
                }
            }
        });

        //next step is to put it all together with a string builder
        StringBuilder sb = new StringBuilder();
        for (ITerm term : termList){ //for loop to go
            String termString = term.toString();
            if(!termString.isEmpty()){ //this skips our empty terms
                if(sb.length() < 0 && !termString.startsWith("+") && !termString.startsWith("-")){
                    sb.append("+");
                }
                sb.append(termString).append(" "); //this appends our current term string into sb
            }
        }
        String result = sb.toString().trim(); //came across solution with plus symbol at beginning. this is solution
        if (result.startsWith("+")){
            result = result.substring(1).trim();
        }
        return result;

    }
}
