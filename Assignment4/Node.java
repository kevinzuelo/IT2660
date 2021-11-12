public class Node<E> {
    private E data;
    private Node<E> next;

    public Node() {
        this.data = null;
        this.next = null;
    }

    public Node(E obj) {
        this.data = obj;
        this.next = null;
    }

    public E getData() {
        return data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
    

}