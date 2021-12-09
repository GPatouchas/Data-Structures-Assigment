import java.io.PrintStream;
import java.util.NoSuchElementException;

public class IntQueueImpl<E> implements IntQueue<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int count = 0;
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void put(E item) {
        count+=1;
        Node<E> n = new Node<E>(item);
        System.out.println("Inserting " + item);
        //list is empty
        if(isEmpty()){
            this.head = n;
            this.tail = n;

        }
        else{
            //queue is not empty

            //1:connect n to the queue
            this.tail.setNext(n);

            //2: modify tail
            this.tail = n;
        }

    }

    @Override
    public E get() throws NoSuchElementException {
        //queue is empty
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        System.out.println("Removing " + peek());
        count-=1;
        //queue is not empty
        E data = this.head.getData();

        //queue has 1 node
        if(this.head == this.tail){
            this.head = null;
            this.tail = null;
        }
        else{
            //queue has >=2 nodes
            this.head = this.head.getNext();
        }
        return (E) data;
    }

    @Override
    public E peek() throws NoSuchElementException {
        //queue is empty
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        //queue is not empty
        E data = this.head.getData();
        return (E) data;
    }

    @Override
    public void printQueue(PrintStream stream) {
        Node node = head;//head of queue

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