import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class OperationToProduct {
    public Product inputProduct(Product newProduct, Scanner sc) throws Exception {
        try{
        String code;
        int quantity;
        double price;
        System.out.println("Please enter the product's name: ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Please enter the product's code: ");
        code = sc.next();
        System.out.println("Please enter the product's quantity: ");
        quantity = sc.nextInt();
        System.out.println("Please enter the product's price: (unit of per item)");
        price = sc.nextDouble();
        return new Product(code, name, quantity, price);
    }catch (Exception e){
            System.out.println("Can't add this new product");
            return null;
        }}
    public MyList<Product> readFromFile(String filename, boolean addLast, MyList<Product> list) throws Exception {
        try {
            FileReader file = new FileReader(filename);
            BufferedReader br = new BufferedReader(file);
            String line = " ";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }

                String text[] = line.split("::");
                String bcode = text[0];// mã sản phẩm
                String title = text[1];
                int quantity = Integer.parseInt(text[2]);
                double price = Double.parseDouble(text[3]);
                Product newProduct = new Product(bcode, title, quantity, price);
                if (addLast) {
                    list.insertTail(newProduct);
                } else {
                    list.insertHead(newProduct);
                }
            }
            br.close();
            file.close();
        } catch (Exception e) {
        }
        return list;
    }
    public void writeToFile(String fileName,MyList<Product> list) {
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
           Node<Product> node = list.getHead();
           while (node!=null){
               fw.write(node.getInfo().toString()+"\n");
               node = node.getNext();
           }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }
    public void addLast(Product newProduct, MyList<Product> list) {
        list.insertTail(newProduct);
    }

    /*  public void displayAll(MyList<Product> list) {
           list.showList();
       }

       public MyList<Product> writeAllItemsToFile(String fileName, MyList<Product> list) {
           return list.readFromFile(fileName, true, list);
       }*/
    public Product searchByCode(MyList<Product> list, String code) {
        Node<Product> node= list.getHead();
        while(node != null){
            if(node.getInfo().getBcode().compareToIgnoreCase(code) == 0){
                System.out.println(node.getInfo().toString());
            }
            node = node.getNext();
        }
        return null;
    }


    public void deleteByCode(String bcode, MyList<Product> list) {

        Node<Product> node = list.getHead();
        while(node != null){
            if(node.getInfo().getBcode().compareToIgnoreCase(bcode)==0){
                list.deleteElement(node.getInfo());

            }
            node = node.getNext();
        }
        System.out.println("list is empty");;
    }


    // quick sort
    public Node<Product> QuickSort(Node<Product> start, Node<Product> end){
        if(start == end || start == null || end == null){
            return start;
        }
        Node<Product> current = start;
        Node<Product> pipre = start;
        Product pivot = end.getInfo();
        while(start != end){
            if(start.getInfo().getBcode().compareToIgnoreCase(pivot.getBcode()) < 0){
                pipre = current;
                Product temp = current.getInfo();
                current.setInfo(start.getInfo());
                start.setInfo(temp);
                current = current.getNext();
            }
            start = start.getNext();
        }

        Product temp = current.getInfo();
        current.setInfo(pivot);
        end.setInfo(temp);

        return pipre;
    }
    public void Arrange(Node<Product> start, Node<Product> end){// Hàm sắp xếp
        if(start == null || start == end || start == end.getNext()){
            return;
        }
        Node<Product> pivot_pre = QuickSort(start, end);
        Arrange(start, pivot_pre);

        if(pivot_pre != null && pivot_pre == start)
            Arrange(pivot_pre.getNext(), end);
        else if(pivot_pre != null && pivot_pre.getNext() != null){
            Arrange(pivot_pre.getNext().getNext(), end);
        }
    }
    public String convertToBinary(int x){//đổi hệ số 10 sang nhị phân
        int a;
        if(x > 0){
            a = x % 2;
            return (convertToBinary(x/2)+""+a);
        }
        return "";
    }



}