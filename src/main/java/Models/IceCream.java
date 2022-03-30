package Models;

public class IceCream {
    private int id;
    private String brand;
    private String flavor;
    private String size;
    private int qty;
    private double price;

    public IceCream (){
        this(0,"", "", "", 0, 0.00);
    }

    public IceCream(int id, String brand, String flavor, String size, int qty, double price) {
        this.id = id;
        this.brand = brand;
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

    public void setBrand(String brand) {
        this.brand = brand;
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


