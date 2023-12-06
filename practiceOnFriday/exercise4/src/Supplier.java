import java.util.ArrayList;

public class Supplier {
    protected String name;
    public ArrayList<Beverage> beverages;

    public void addBeverage (Beverage beverage) {
        this.beverages.add(beverage);
    }

    Supplier (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public ArrayList<Beverage> getBeverages() {
        return beverages;
    }
}
