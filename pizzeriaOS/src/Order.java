public class Order {
    static Double price;
    String description;
    Etapa etapa = Etapa.Pedido;

    Order(String description, double price) {
        this.description = description;
        this.price = price;
    }

    Order() {
    }

    public void showMenu() {
        System.out.println("""
                pizza               valor
                1- calabresa        16.99
                2- portuguesa       17.00
                3- carne de sol     22.00
                bebida              valor
                4- suco             5.50
                5- refrigerante     8.99
                """);
    }

    public void selectMenu(int key) {
        Order pizzaVip;
        switch (key) {
            case 1:
                pizzaVip = new Order("pizza de calabresa", 16.99);
                System.out.println("pedido feito de: "
                + pizzaVip.description +
                "\npelo preco de: "
                + pizzaVip.price);
                new Pizzeria().takeOrder(pizzaVip);
                break;
            case 2:
                pizzaVip = new Order("pizza portuguesa", 17);
                System.out.println("pedido feito de: "
                + pizzaVip.description +
                "\npelo preco de: "
                + pizzaVip.price);
                new Pizzeria().takeOrder(pizzaVip);
                break;
            case 3:
                pizzaVip = new Order("pizza de carne de sol", 22);
                System.out.println("pedido feito de: "
                + pizzaVip.description +
                "\npelo preco de: "
                + pizzaVip.price);
                new Pizzeria().takeOrder(pizzaVip);
                break;
            case 4:
                pizzaVip = new Order("suco", 5.50);
                System.out.println("pedido feito de: "
                + pizzaVip.description +
                "\npelo preco de: "
                + pizzaVip.price);
                new Pizzeria().takeOrder(pizzaVip);
                break;
            case 5:
                pizzaVip = new Order("refrigerante", 8.99);
                System.out.println("pedido feito de: "
                + pizzaVip.description +
                "\npelo preco de: "
                + pizzaVip.price);
                new Pizzeria().takeOrder(pizzaVip);
                break;
            default:
                System.out.println("invalid input");
        }
    }

    public double getPrice() {
        return price;
    }
}
