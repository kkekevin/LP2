import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class Department {
    String name;
    private Administrator administrator;
    private ArrayList<Seller> sellers = new ArrayList<>();
    private ArrayList<Deliverer> deliverers = new ArrayList<>();

    public void layOff() {
        System.out.println("""
                \t1 - administrator.
                \t2 - seller.
                \t3 - delivery driver.
                """);
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        in.nextLine();
        if (x == 1) {
            if (administrator != null) {
                administrator = null;
            } else {
                System.out.println("nao tem funcionario nesta funcao");
            }
        } else if (x == 2) {
            if (sellers != null) {
                System.out.println("digite o cpf do funcionario: ");
                String cpf = in.nextLine();
                for (Seller i : sellers) {
                    if (i.getCpf().equals(cpf))
                        sellers.remove(i);
                }
            } else {
                System.out.println("nao tem funcionario nesta funcao");
            }
        } else if (x == 3) {
            if (deliverers != null) {
                System.out.println("digite o cpf do funcionario: ");
                String cpf = in.nextLine();
                for (Deliverer i : deliverers) {
                    if (i.getCpf().equals(cpf))
                        deliverers.remove(i);
                }
            } else {
                System.out.println("nao tem funcionario nesta funcao");
            }
        } else {
            System.out.println("invalid input");
        }
        // in.close();
    }

    public void hire() {
        System.out.println("""
                \t1 - administrator.
                \t2 - seller.
                \t3 - delivery driver.
                """);
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        in.nextLine();
        if (x == 1) {
            if (administrator == null) {
                System.out.print("nome: ");
                String nameOfEmployee = in.nextLine();
                System.out.print("cpf: ");
                String cpf = in.nextLine();
                administrator = new Administrator(nameOfEmployee, cpf);
            } else {
                System.out.println("ja temos adm neste departamento");
            }
        } else if (x == 2) {
            System.out.print("nome: ");
            String nameOfEmployee = in.nextLine();
            System.out.print("cpf: ");
            String cpf = in.nextLine();
            System.out.println("comissao de venda: ");
            double commissionRate = in.nextDouble();
            in.nextLine();
            sellers.add(new Seller(nameOfEmployee, cpf, commissionRate));
        } else if (x == 3) {
            System.out.print("nome: ");
            String nameOfEmployee = in.nextLine();
            System.out.print("cpf: ");
            String cpf = in.nextLine();
            System.out.println("bonus de risco: ");
            double riskBonuses = in.nextDouble();
            in.nextLine();
            deliverers.add(new Deliverer(nameOfEmployee, cpf, riskBonuses));
        } else {
            System.out.println("invalid input");
        }
        // in.close();
    }

    public void showEmployee() {
        if (administrator != null) {
            System.out.printf("temos um adm chamado: %s\n\n", administrator.getName());
        } else {
            System.out.println("ainda não temos adm\n\n");
        }
        if (sellers != null) {
            System.out.println("os vendedores sao: ");
            for (Seller i : sellers)
                System.out.printf("%s ", i.getName());
        } else {
            System.out.println("ainda nao temos vendedor");
        }
        if (deliverers != null) {
            System.out.println("\n\nos motoboys sao:");
            for (Deliverer i : deliverers)
                System.out.printf("%s ", i.getName());
        } else {
            System.out.println("\n\nainda nao temos motoboy");
        }
    }

    // for add sale or check sales of seller out
    public void sell() {
        Scanner in = new Scanner(System.in);
        System.out.println("cpf do vendedor: ");
        String cpf = in.nextLine();
        Seller seller = findSeller(cpf);
        if (seller != null) {
            System.out.println("""
                    \t1 - verificar vendas.
                    \t2 - adicionar venda.
                    """);
            int choice = in.nextInt();
            if (choice == 1) {
                System.out.println("Este vendedor tem " + seller.getNoOfSales() + " vendas.\n");
            } else if (choice == 2) {
                System.out.println("valor do produto: ");
                double price = in.nextDouble();
                in.nextLine();
                System.out.println("data da venda: ");
                String data = in.nextLine();
                seller.addSale(data, price);
            } else {
                System.out.println("invalid input\n");
            }
        } else {
            System.out.println("seller not found\n");
        }
        // in.close();
    }

    // find seller using iterator
    private Seller findSeller(String cpf) {
        Iterator<Seller> iterator = sellers.iterator();
        while (iterator.hasNext()) {
            Seller seller = iterator.next();
            if (seller.getCpf().equals(cpf))
                return seller;
        }
        return null;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public ArrayList<Deliverer> getDeliverers() {
        return deliverers;
    }

    public ArrayList<Seller> getSellers() {
        return sellers;
    }

    Department(String name) {
        this.name = name;
    }

}
