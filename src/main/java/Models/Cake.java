package Models;

public class Cake {
    private int id;
    private String brand;
    private String flavor;
    private String size;
    private int qty;
    private double price;

    public Cake (){
        this(0, "", "", 0, 0.00);
    }

    public Cake(int id, String flavor, String size, int qty, double price) {
        this.id = id;
        this.brand = "Sera 'N' Dipity";
        this.flavor = flavor;
        this.size = size;
        this.qty = qty;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
