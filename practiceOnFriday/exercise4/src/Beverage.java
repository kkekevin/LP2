public abstract class Beverage {
    protected String name;
    protected Supplier supplier;
    protected int quantity;
    protected double price;
    public int type;
    
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    Beverage (String name, Supplier supplier, int quantity, double price, int type) {
        this.name = name;
        this.supplier = supplier;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        return supplier.getName() + " [name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
    }

    
}
