public class Node<E> {
    protected E data;
    protected Node next = null;


    Node(E data){
        this.data = data;
    }

    public E getData(){
        return data;
    }

    public Node<E> getNext(){
        return next;
    }

    public void setNext(Node<E> next){
        this.next = next;
    }
}