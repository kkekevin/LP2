import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Control {
    protected ArrayList<Sale> sales;
    protected ArrayList<Beverage> drinks;
    protected ArrayList<Supplier> suppliers;
    protected Scanner in;
    //protected BufferedWriter writer = new BufferedWriter(new FileWriter("teste.txt"));
    String path = "/home/kevin/CPufma/LP2/LP2/practiceOnFriday/exercise4/src/teste.txt";

    public void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line = reader.readLine();
            while(line != null){
                String[] vet = line.split(";");
                String name = vet[0];
                Integer supplier = Integer.parseInt(vet[1]);
                Integer quantity = Integer.parseInt(vet[2]);
                Integer typeOfBeverage = Integer.parseInt(vet[4]);
                Double price = Double.parseDouble(vet[3]);
                line = reader.readLine();
                switch (typeOfBeverage) {
                    case 1:
                        this.drinks.add(new Soda(name, suppliers.get(supplier), quantity, price));
                        break;
                    case 2:
                        this.drinks.add(new Juice(name, suppliers.get(supplier), quantity, price));
                        break;
                    case 3:
                        this.drinks.add(new Alcoholic(name, suppliers.get(supplier), quantity, price));
                        break;
                    case 4:
                        this.drinks.add(new Water(name, suppliers.get(supplier), quantity, price));
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void writeFile(String name, Integer quantity, Double price){

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
            bw.write("");
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

     public void readSFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("suppliers.txt"))){
            String line = reader.readLine();
            while(line != null){
                suppliers.add(new Supplier(line));
                line = reader.readLine();
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void writeSFile(String supplier){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("suppliers.txt", true))){
            writer.write(supplier + "\n");
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void addBeverage() {
        System.out.println("Selecione o tipo da bebida");
        System.out.println("1 - Refrigerante");
        System.out.println("2 - Suco");
        System.out.println("3 - Alcoolico");
        System.out.println("4 - Agua");
        int type = this.in.nextInt();
        this.in.nextLine();

        System.out.println("Segue a lista de fornecedores ");
        listOfSuppliers();
        System.out.println("Informe o fornecedor (nº):");
        int indexSupplier = this.in.nextInt();
        this.in.nextLine();
        System.out.println(suppliers.get(indexSupplier).getName());

        System.out.println("Informe o nome da bebida");
        String name = this.in.nextLine();

        System.out.println("Informe a quantidade em estoque:");
        int quantity = this.in.nextInt();
        this.in.nextLine();

        System.out.println("Informe o valor da bebida:");
        double price = this.in.nextDouble();
        this.in.nextLine();
        Beverage prod = null;

        switch (type) {
            case 1:
                prod = new Soda(name, suppliers.get(indexSupplier), quantity, price);
                this.drinks.add(prod);
                break;
            case 2:
                prod = new Juice(name, suppliers.get(indexSupplier), quantity, price);
                this.drinks.add(prod);
                break;
            case 3:
                prod = new Alcoholic(name, suppliers.get(indexSupplier), quantity, price);
                this.drinks.add(prod);
                break;
            case 4:
                prod = new Water(name, suppliers.get(indexSupplier), quantity, price);
                this.drinks.add(prod);
                break;
        }
    }

    public void listOfBeverage () {
        //readFile();
        for (Beverage i : drinks) {
            System.out.println(i);
        }
    }

    public void listOfSuppliers () {
        for (Supplier i : this.suppliers) {
            System.out.println(i.getName());
        }
    }

    public String addSupplier() {
        System.out.println("Informe o nome do fornecedor: ");
        String name = this.in.nextLine();
        for (Supplier i : this.suppliers) { 
            if (name.equals(i.getName())) {
                return "ja existe este fornecedor";
            }
        }
        this.suppliers.add(new Supplier(name));
        writeSFile(name);
        return "";
    }

    public void sell() {
        System.out.println("Segue a lista de bebidas disponiveis ");
        this.listOfBeverage();
        System.out.println("Informe a bebida (nº):");
        int indexBeverage = this.in.nextInt();
        this.in.nextLine();

        System.out.println("Informe a quantidade desejada:");
        int quantity = this.in.nextInt();
        this.in.nextLine();

        if (this.drinks.get(indexBeverage).getQuantity() < quantity) {
            System.out.println("estoque insuficiente");
            return;
        }

        sales.add(new Sale(drinks.get(indexBeverage), quantity)); //set a sale
        drinks.get(indexBeverage).setQuantity(
            drinks.get(indexBeverage).getQuantity() - quantity); //take away quantity
    }

    public void listOfSales () {
        for (Sale i : sales) {
            System.out.printf("%c %f",i.getBeverage(), i.getQuantity());
        }
    }

    public void menu(){
        this.readSFile(); //load all suppliers
        this.readFile(); //load all beverages
        int opt;
        do {
            System.out.println("Selecione uma opcao:");
            System.out.println("1 - Cadastrar bebida ");
            System.out.println("2 - Listar todas as bebidas");
            System.out.println("3 - Cadastrar Fornnecedor");
            System.out.println("4 - Listar Fornecedores");
            System.out.println("5 - Realizar venda");
            System.out.println("6 - Lista Vendas");
            System.out.println("0 - Sair");
            opt = this.in.nextInt();
            this.in.nextLine();

            switch (opt){
                case 1:
                    this.addBeverage();
                    break;
                case 2:
                    this.listOfBeverage();
                    break;
                case 3:
                    String sit = this.addSupplier();
                    System.out.println(sit);
                    break;
                case 4:
                    this.listOfSuppliers();
                    break;
                case 5:
                    this.sell();
                    break;
                case 6:
                    this.listOfSales();
                    break;
            }



        }while (opt != 0);
    }
    Control () {
        this.in = new Scanner(System.in);
        this.sales = new ArrayList<Sale>();
        this.drinks = new ArrayList<Beverage>();
        this.suppliers = new ArrayList<Supplier>();
    }
}
