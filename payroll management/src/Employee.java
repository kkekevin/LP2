public class Employee {
    private String name, cpf;
    private double salary = 1315.20, helthCare= 315.21, transport = 76.30, inssD = 0.11, irpfD = 0.15;
    Department department;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setHelthCare(double helthCare) {
        this.helthCare = helthCare;
    }

    public void setTransport(double transport) {
        this.transport = transport;
    }

    public double getHelthCare() {
        return helthCare;
    }

    public double getTransport() {
        return transport;
    }

    public double getInssD() {
        return inssD;
    }

    public double getIrpfD() {
        return irpfD;
    }

    Employee(String name, String cpf) {
        this.cpf = cpf;
        this.name = name;
    }

}
