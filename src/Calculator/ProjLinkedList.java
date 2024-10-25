// ProjLinkedList class:
// This is the chain that links all the terms together to form the full expression.
// Each term is stored in a ProjNode, and this class makes sure they’re connected in the right order.
// You can go through the terms one by one, like reading an equation from left to right.


package Calculator;


public class ProjLinkedList<T> {
    private ProjNode<T> head; //the first node in our linked list

    //our constructor will initialize the linked list as empty/head is null
    public ProjLinkedList(){
        this.head = null;
    }

    public void add(T data){ //our method to add a new node to the front of the list
        //create a new node with the provided data
        ProjNode<T> newNode = new ProjNode<>(data);
        //link the new node's next to the current head
        newNode.setNext(head);
        //set the head equal to the new node variable now that its at the front
        head = newNode;
    }

//    //method to retrieve the value at a certain index
//    public T getAt(int index){
//        ProjNode<T> current = head;
//        int count = 0;
//
//        //traverse the list with a while loop until reach desired index
//        while (current != null){
//            if (count == index){
//                return current.getData(); //return data to given index
//            }
//            count++; //increment our count by one to point to next index
//            current = current.getNext(); //move to the next node
//        }
//        return null; //if the index is out of bounds, then we'll just return null
//    }

    public ProjNode<T> getHead(){ //this method will literally just return/"get" the head of the LL
        return head;
    }
}
