public class Account {
    private int accNumber;
    private float amount;
    private Client client;

    public void withDraw(float value) {
        if (amount > value && value > 0)
            amount -= value;
        else
            System.out.println("invalid operation");
    }

    public void depositMoney(float deposit) {
        if (deposit > 0) {
            amount += deposit;
            System.out.println("you made a deposit of: " + deposit
                    + "\nto: " + client.name);
        } else {
            System.out.println("invalid operation");
        }
    }

    public void checkAmount() {
        System.out.println("amount: " + amount);
    }

    public float getAmount() {
        return amount;
    }

    Account() {
        
    }

    Account(int accNumber, String name, int cpf) {
        this.accNumber = accNumber;
        client = new Client(name, cpf);
        amount = 0;
    }

}
