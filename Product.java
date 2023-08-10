public class Product {
    private String bcode, name;
    private double price;
    private int quantity;
    public Product() {

    }
    public Product(String code, String name, int quantity, double price) {
        this.bcode = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String code) {
        this.bcode = code;
    }

    @Override
    public String toString() {
        return String.format("%s|%s|%d|%.2f", this.bcode, this.name, this.quantity, this.price);
    }
}