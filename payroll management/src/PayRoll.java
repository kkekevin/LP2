import java.util.Scanner;

public class PayRoll {
    private Department department;

    public void payEmployee() {
        Scanner in = new Scanner(System.in);
        System.out.println("deseja alterar valor da bonificacao?? Y/N");
        char x = in.next().charAt(0);
        if (x == 'Y' || x == 'y') {
            System.out.println("novo valor do plano de saude: ");
            double benefit = in.nextDouble();
            department.getAdministrator().setHelthCare(benefit);
            in.nextLine();
            System.out.println("novo valor do vale transporte: ");
            benefit = in.nextDouble();
            department.getAdministrator().setTransport(benefit);
            in.nextLine();
        } else if (x == 'N' || x == 'n') {
            // check if there is an adm
            if (department.getAdministrator() != null) {
                // adm of x department
                System.out.printf("%s do departamento %s, cpf: %s\n", department.getAdministrator().getName(),
                        department.name, department.getAdministrator().getCpf());
                System.out.printf("salario base: %f\n", department.getAdministrator().getSalary());
                System.out.print("Salario com os beneficios: ");
                // adjust for benefits
                department.getAdministrator()
                        .setSalary(((department.getAdministrator().getSalary()
                                * (1 + department.getAdministrator().getBossBonuses()))
                                + department.getAdministrator().getHelthCare()
                                + department.getAdministrator().getTransport()));
                System.out.println(department.getAdministrator().getSalary());
                // salary after discounts
                System.out.print("salario liquido com descontos: ");
                department.getAdministrator().setSalary(department.getAdministrator().getSalary()
                        * (1 - (department.getAdministrator().getInssD() + department.getAdministrator().getIrpfD())));
                System.out.println(department.getAdministrator().getSalary());
                System.out.println("Administrator has been paid successfully");
            } else {
                System.out.println("there is no adm yet");
            }
            // check if there is a seller
            if (department.getSellers() != null) {
                // get all sellers
                for (Seller i : department.getSellers()) {
                    // seller of x department
                    System.out.printf("%s do departamento %s, cpf: %s\n", i.getName(), department.name, i.getCpf());
                    System.out.printf("salario base: %f\n", i.getSalary());
                    System.out.print("Salario com os beneficios: ");
                    // adjust for benefits
                    i.setSalary(i.getSalary() + i.getHelthCare() + i.getTransport());
                    System.out.println(i.getSalary());
                    // comissions
                    System.out.println("comissões: " + i.getComission());
                    // salary after discounts
                    i.setSalary(i.getSalary() + i.getComission());
                    System.out.print("salario liquido com descontos: ");
                    i.setSalary(i.getSalary() * (1 - (i.getInssD() + i.getIrpfD())));
                    System.out.println(i.getSalary());
                    System.out.println("Seller" + i.getName() + "has been paid successfully");
                    i.setComission(0);
                }
            } else {
                System.out.println("there is no seller yet!");
            }
            // check if there is a deliverer
            if (department.getDeliverers() != null) {
                // get all deliverers
                for (Deliverer i : department.getDeliverers()) {
                    // deliverer of x department
                    System.out.printf("%s do departamento %s, cpf: %s\n", i.getName(), department.name, i.getCpf());
                    System.out.printf("salario base: %f\n", i.getSalary());
                    System.out.print("Salario com os beneficios: ");
                    // adjust for benefits
                    i.setSalary(i.getSalary() + i.getHelthCare() + i.getTransport());
                    System.out.println(i.getSalary());
                    // salary after discounts
                    System.out.print("salario liquido com descontos: ");
                    i.setSalary(i.getSalary() * (1 - (i.getInssD() + i.getIrpfD())));
                    System.out.println(i.getSalary());
                    System.out.println("Deliverer" + i.getName() + "has been paid successfully");
                }
            } else {
                System.out.println("there is no seller yet!");
            }
        } else {
            System.out.println("invalid input");
        }
    }

    PayRoll(Department department) {
        this.department = department;
    }
}
