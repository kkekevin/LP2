import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Department it = new Department("information technology");

        while (true) {
            System.out.println("""
                    1 - cadastrar funcionario.
                    2 - remover funcionario.
                    """);
            int x = in.nextInt();
            //in.close();
            switch (x) {
                case 1:
                it.hire();
                    break;

                default:
                System.out.println("entre com valor valido.");
                    break;
            }
        }
    }
}
