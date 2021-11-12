import java.util.Iterator;
public class LinkedList<E>  implements Iterable <E> {
    private int size;
    private Node<E> head;
    private Node<E> last;

    public LinkedList() {
        Node<E> newNode = new Node<E>();
        this.head = newNode;
        this.last = this.head;
    }

    public void append(E e) {
		Node<E> temp = new Node<E>(e);

		if (this.head.getData() == null) {
			this.head = temp;
			this.last = this.head;
		}
        else {
            this.last.setNext(temp);
            this.last = temp;
		}
		size++;
	}

    public void newHead(E e) {
        Node<E> temp = new Node<E>(e);
        temp.setNext(head);
        head = temp;
        size++;
    }

    public void insertAfter(E newElement, int position ) {
        Node<E> temp = new Node<E>(newElement);
        Node<E> current = this.head;

        if(this.head != null && position <= this.size) {
            for (int i = 1; i < position; i++) {
                current = current.getNext();
            }
            temp.setNext(current.getNext());
            current.setNext(temp);
            size++;
        }    
    }

    public int getSize() {
        return size;
    }
    
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if(hasNext()){
                    E data = current.getData();
                    current = current.getNext();
                    return data;
                }
                return null;
            }
        };
    }
    public static void main(String[] args) {
        LinkedList<String> newlist = new LinkedList<String>();
        newlist.append("One");
        newlist.append("Two");
        newlist.append("Three");
        newlist.append("Four");
        newlist.newHead("New Head");
        newlist.insertAfter("Inserted Node", 2);
        newlist.insertAfter("Inserted Node", 4);

        for (String str : newlist) {
            System.out.println(str);
        }
    }
}