import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Department it = new Department("information technology");
        PayRoll pr = new PayRoll(it);

        while (true) {
            System.out.println("""
                    1 - cadastrar funcionario.
                    2 - remover funcionario.
                    3 - mostrar funcionarios do departamento.
                    4 - area vendedor.
                    5 - pagar funcionarios.
                    6 - sair.
                    """);
            int x = in.nextInt();
            switch (x) {
                case 1:
                    it.hire();
                    break;
                case 2:
                    it.layOff();
                    break;
                case 3:
                    it.showEmployee();
                    break;
                case 4:
                    it.sell();
                    break;
                case 5:
                    pr.payEmployee();
                    break;
                case 6:
                    System.out.println("seeya");
                    in.close();
                    System.exit(0);
                default:
                    System.out.println("entre com valor valido.");
                    break;
            }
        }
    }
}
