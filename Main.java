import java.util.Scanner;

public class Main {

    public static final String filename = "Data.txt";
    public static final String consolefile = "console_output.txt";

    public static void main(String[] arg) throws Exception {
        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        OperationToProduct p = new OperationToProduct();
        int choice;
        MyList<Product> list = new MyList<>();
        while (loop) {
            System.out.print("Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Thanks for using");
                    loop = false;
                    break;
                case 1: {// đọc dữ liệu trong file và in ra màn hình

                    if (!list.fileIsEmpty(filename)) {
                        list.clear();
                        p.readFromFile(filename, true, list);
                        list.showList();
                    } else {
                        System.out.println("File is empty");
                    }
                    break;
                }

                case 2: {//thêm sản phẩm vào cuối danh sách
                    System.out.println("Product Information");
                    Product newProduct = new Product();
                    p.addLast(newProduct, list);
                    p.inputProduct(newProduct, sc);

                    break;
                }
                case 3://In danh sách sản phẩm ra màn hình
                    if (list.isEmpty()) {
                        System.out.println("List is empty");
                    } else {
                        System.out.println("List product");
                        System.out.printf("%5s%1s|%7s%2s|%11s%3s|%6s\n", "Code", " ", "Name", " ", "Quantity", " ", "Price");
                        list.showList();

                    }
                    break;
                case 4: {//Ghi dữ liệu từ danh sách vào file

                    if (!list.isEmpty()) {
                        p.writeToFile(filename, list);
                    } else {
                        System.out.println("List is empty");
                    }
                }
                case 5://Tìm kiếm sản pham bằng ID
                    if (list.isEmpty()) {
                        System.out.println("List is empty");
                    } else {
                        System.out.println("Search by ID: ");
                        String id = sc.nextLine();
                        Product newProduct = new Product();

                        var searchID = p.searchByCode(list, id);
                        if (searchID != null) {
                            System.out.println(searchID);
                        }
                    }
                    break;
                case 6:

                    break;
                case 7:
                    break;
            }
        }
        ;
    }
}
