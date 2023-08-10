public class Node<T> {
    private Node<T> next;
    private T info;

    public Node() {
        this.info = null;
        this.next = null;
    }

    ;

    public Node(T data) {
        this.info = data;
    }

    public Node(T data, Node<T> next) {
        this.info = data;
        this.next = next;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return this.info.toString();
    }}
 