import javax.imageio.IIOException;
import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class MyList<T> {
    private Node<T> head;
    private Node<T> tail;

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;

    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> Tail) {
        this.tail = tail;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Node<T> front() {
        return head;
    }


    public int length(){// hàm cho biết chiều dài linked list
        if(head == null){
            return 0;
        }
        Node<T> current = head;
        int count = 0;
        while(current != null){
            count++;
            current = current.getNext();
        }
        return count;
    }
    public void insertHead(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    public void insertTail(T data) {
        Node<T> p = new Node<>(data);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.setNext(p);
            tail = p;
        }
    }

    public void clear() {
        head = null;
    }


    public void deleteTail() {
        if(!isEmpty()) {
            if (head.getNext() == null) {
                head.setNext(null);
                head = null;
                return;
            }
            Node<T> pre = null, current = this.head;
            while (current != tail) {
                pre = current;
                current = current.getNext();
            }if(pre != null){
                pre.setNext(null);
                tail = pre;
            }
        }else {
            System.out.println("This list is empty");
        }
    }
    public void deleteElement(T item){
        Node<T> element = new Node<>(item);
        Node<T> current = this.head, pre = null;
        if(current != null){
            if(this.head.getInfo() == element.getInfo()){
                this.head = this.head.getNext();
                return;
            }
            while (current != null && current.getInfo() != element.getInfo()) {
                pre = current;
                current = current.getNext();
            }
            if (element.getInfo() == current.getInfo() && current.getNext() != null) {
                pre.setNext(current.getNext());
                System.out.println("Delete successfully!");
            } else if (element.getInfo() == current.getInfo() && current.getNext() == null) {
                deleteTail();
            } else
                System.out.println("No such item!");
        }else System.out.println("This linked list is empty!");

    }
    public boolean fileIsEmpty(String fileName) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            return line == null;
        } catch (Exception e) {
        }
        return false;
    }

    public void showList() {
       Node<T> node = this.head;
       while (node!=null){
           System.out.println(node.getInfo() + " ");
           node = node.getNext();
        }
    }
}
