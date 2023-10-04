import java.util.ArrayList;
import java.util.Scanner;

public class Department {
    String name;
    private Administrator administrator;
    private ArrayList<Seller> sellers = new ArrayList<>();
    private ArrayList<Deliverer> deliverers = new ArrayList<>();

    private void addEmployee(Employee newEmployee) {
        employee.add(newEmployee);
    }

    private void removeEmployee() {}

    public void layOff() {
        System.out.println("""
                \t1 - administrator.
                \t2 - seller.
                \t3 - delivery driver.
                """);
                Scanner inn = new Scanner(System.in);
                int x = inn.nextInt();
                if(x == 1) {
                    if(administrator != null){
                        //colocar aqui um mecanismo de busca, e chamar a funcao removeEmplyee pra deletar um adm
                    } else {
                        System.out.println("nao tem funcionario nesta funcao");
                    }
                }
    }

    public void hire() {
        System.out.println("""
                \t1 - administrator.
                \t2 - seller.
                \t3 - delivery driver.
                """);
        Scanner inn = new Scanner(System.in);
        int x = inn.nextInt();
        // boolean oneOfThem = false;
        if (x == 1) {
            if (administrator == null) {
                System.out.print("nome: ");
                String nameOfEmployee = inn.nextLine();
                System.out.print("cpf: ");
                int cpf = inn.nextInt();
                administrator = new Administrator(nameOfEmployee, cpf);
                // oneOfThem = true;
            } else {
                System.out.println("ja temos adm neste departamento");
            }
        } else if (x == 2) {
            new Seller();
        } else if (x == 3) {
            new Deliverer();
        } else {
            System.out.println("invalid input");
        }
        // Employee employee = new Employee(cpf, name);
        // if(oneOfThem == true)
        // addEmployee(employee);
    }

    Department(String name) {
        this.name = name;
    }
}
