public class Customer {
    private String name;
    Order item;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Customer(String name, Order item) {
        this.name = name;
        this.item = item;
    }

    Customer() {
    }

    public Etapa orderStatus() {
        return item.etapa;
    }

}
