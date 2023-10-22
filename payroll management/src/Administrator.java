public class Administrator extends Employee {
    private double bossBonuses = 0.2;

    Administrator(String name, String cpf) {
        super(name, cpf);
    }
    public double getBossBonuses() {
        return bossBonuses;
    }
}
