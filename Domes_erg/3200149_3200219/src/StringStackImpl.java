import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.stream.*;
import java.util.stream.*;
import java.util.stream.Collectors;


public class StringStackImpl<E> implements StringStack<E>{
    private Node<E> top = null;
    private int count = 0;

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void push(E item) {
        count += 1;
        Node<E> prev = this.top;
        this.top = new Node(item);
        this.top.data = item;
        this.top.setNext(prev);
        System.out.println("Inserting " + item);
    }


    @Override
    public E pop() throws NoSuchElementException {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        count -= 1;
        System.out.println("Removing " + peek());
        E data  = this.top.getData();
        this.top = this.top.next;
        return (E)data;
    }





    @Override
    public E peek() throws NoSuchElementException {
        //check if the stack is empty
        if(!isEmpty()){
            return this.top.data;
        }
        else{
            throw new NoSuchElementException();
        }
    }

    @Override
    public void printStack(PrintStream stream) {
        Node node = top; // top of the stack

        while(node != null){
            stream.println(node.data);
            stream.flush();
            node = node.next;
        }



    }

    @Override
    public int size() {
        return count;
    }
}