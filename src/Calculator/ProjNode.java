// ProjNode class:
// This is like a box that holds one term, like 5x or sin(x).
// It also links to the next term in the equation, which allows us to string terms together to form a full equation.


package Calculator;

public class ProjNode<T> { //T allows us to use any type because of Generics!
    private final T data; //This is the data each node will hold, in our case, each term
    private ProjNode<T> next; //This is going to link our nodes to the next node, a reference to next node

    public ProjNode(T data){ //this is our constructor for ProjNode class
        this.data = data; //this is the term our node should hold
        this.next = null; //each node will automatically link to null
    }

    public T getData(){ //this method will return a term stored in a node
        return data;
    }

    public ProjNode<T> getNext() { //this will let us see the next node in the linked list
        return next;
    }

    public void setNext(ProjNode<T> next){ //this method will let us set the next node after a given node
        this.next = next;
    }
}
