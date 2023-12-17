public class Sale {
    protected Beverage beverage;
    protected int quantity;

    Sale (Beverage beverage, int quantity) {
        this.beverage = beverage;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return beverage.getName() + " - " + quantity;
    }
}
