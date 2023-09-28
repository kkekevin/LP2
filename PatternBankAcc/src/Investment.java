public class Investment extends Account {

    public void checkInvestment() {
        float x = this.getAmount();

        x *= 1.01;
        this.depositMoney(x);
        System.out.println(x);
    }

    Investment(int accNumber, String name, int cpf) {
        super(accNumber, name, cpf);
    }
}
