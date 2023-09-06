import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Customer client1 = new Customer();
        client1.setName("kevin");        
        new Order().showMenu();
        
        Scanner keyScanner = new Scanner(System.in);
        int key = keyScanner.nextInt();
        new Order().selectMenu(key);
        keyScanner.close();
    }
}
