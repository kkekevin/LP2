public class Administrator extends Employee {
    float bossBonuses = 0.2;
    Administrator(String name, int cpf) {
        this.setName(name);
        this.setCpf(cpf);
        this.setSalary(this.getSalary() * (1 + bossBonuses));
    }
    
}
