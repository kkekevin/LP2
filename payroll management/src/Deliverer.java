public class Deliverer extends Employee {
    double riskBonuses;
    Deliverer(String name, String cpf, double riskBonuses) {
        super(name, cpf);
        setSalary(((getSalary() * (1 + riskBonuses)) + getHelthCare() + getTransport()));
    }
}
