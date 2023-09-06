public class Pizzeria {
    private double budget;

    public Pizzeria() {
        budget = 0;
    }

    public void takeOrder(Order pizzaVip) {
        budget += pizzaVip.getPrice();
        System.out.println(budget);
    }
}
