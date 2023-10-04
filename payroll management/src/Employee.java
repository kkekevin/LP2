public class Employee {
    private int cpf;
    private String name;
    private float salary = 1315.20, benefit, discount;
    Department department;

    //public void addEmployee() {}
    //private void removeEmployee() {}
    public void setName(String name) {
        this.name = name;
    }
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }
    public float getSalary() {
        return salary;
    }

    Employee (int cpf, String name) {
        this.cpf = cpf;
        this.name = name;
    }
    
}
