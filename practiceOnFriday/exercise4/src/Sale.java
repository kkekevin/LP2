public class Sale {
    protected Beverage beverage;
    protected int quantity;

    Sale (Beverage beverage, int quantity) {
        this.beverage = beverage;
        this.quantity = quantity;
    }

    public Beverage getBeverage() {
        return beverage;
    }

    public int getQuantity() {
        return quantity;
    }
}
