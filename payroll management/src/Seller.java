import java.util.ArrayList;

public class Seller extends Employee {
    private int noOfSales;
    private double commissionRate, comission;
    private ArrayList<Sales> sale = new ArrayList<>();

    Seller(String nameOfEmployee, String cpf, double commissionRate) {
        super(nameOfEmployee, cpf);
        // setSalary((getSalary() + getHelthCare() + getTransport()));
        noOfSales = 0;
        comission = 0;
    }

    public void addSale(String data, double price) {
        //setSalary(getSalary() + (price * commissionRate));
        comission += price * commissionRate;
        sale.add(new Sales(price, data));
        noOfSales++;
        System.out.println("successfully sold!");
    }

    public int getNoOfSales() {
        return noOfSales;
    }

    public double getComission() {
        return comission;
    }

    public void setComission(double comission) {
        this.comission = comission;
    }
}
