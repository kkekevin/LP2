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
                Beverage prod = null;
                switch (typeOfBeverage) {
                    case 1:
                        prod = new Soda(name, suppliers.get(supplier), quantity, price);
                        this.drinks.add(prod);
                        this.suppliers.get(supplier).addBeverage(prod);
                        break;
                    case 2:
                        prod = new Juice(name, suppliers.get(supplier), quantity, price);
                        this.drinks.add(prod);
                        this.suppliers.get(supplier).addBeverage(prod);
                        break;
                    case 3:
                        prod = new Alcoholic(name, suppliers.get(supplier), quantity, price);
                        this.drinks.add(prod);
                        this.suppliers.get(supplier).addBeverage(prod);
                        break;
                    case 4:
                        prod = new Water(name, suppliers.get(supplier), quantity, price);
                        this.drinks.add(prod);
                        this.suppliers.get(supplier).addBeverage(prod);
                        break;
                    default:
                        break;
                }
            }
            reader.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void writeFile(String name, int supplier, Integer quantity, Double price, int type){

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))){
            writer.write(name + ";");
            writer.write(supplier + ";");
            writer.write(quantity + ";");
            writer.write(price + ";");
            writer.write(type + "\n");
            writer.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void updateFile() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))){
           
            int x = 1;
            for (Supplier i : suppliers) {
                for (int j = 0; j < i.beverages.size(); j++) {
                    writer.write(i.beverages.get(j).getName() + ";");
                    writer.write(x + ";");
                    writer.write(i.beverages.get(j).getQuantity() + ";");
                    writer.write(i.beverages.get(j).getPrice() + ";");
                    writer.write(i.beverages.get(j).type + "\n");
                }
                //tiger;2;48;5.0;3
                x++;
            }
            writer.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void writeSale(String name, int quantity) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sales.txt", true))){
           writer.write(name + ";");
           writer.write(quantity + "\n");
           writer.close();
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
            reader.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void writeSFile(String supplier){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("suppliers.txt", true))){
            writer.write(supplier + "\n");
            writer.close();
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
                prod = new Soda(name, suppliers.get(indexSupplier - 1), quantity, price);
                this.drinks.add(prod);
                writeFile(name, indexSupplier, quantity, price, type);
                break;
            case 2:
                prod = new Juice(name, suppliers.get(indexSupplier - 1), quantity, price);
                this.drinks.add(prod);
                writeFile(name, indexSupplier, quantity, price, type);                
                break;
            case 3:
                prod = new Alcoholic(name, suppliers.get(indexSupplier - 1), quantity, price);
                this.drinks.add(prod);
                writeFile(name, indexSupplier, quantity, price, type);
                break;
            case 4:
                prod = new Water(name, suppliers.get(indexSupplier - 1), quantity, price);
                this.drinks.add(prod);
                writeFile(name, indexSupplier, quantity, price, type);
                break;
        }
    }

    public void listOfBeverage () {
        int x = 1;
        for (Beverage i : drinks) {
            System.out.println(x + " - " + i);
            x++;
        }
    }

    public void listOfSuppliers () {
        int x = 1;
        for (Supplier i : this.suppliers) {
            System.out.println(x + " - " + i.getName());
            x++;
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

        if (this.drinks.get(indexBeverage - 1).getQuantity() < quantity) {
            System.out.println("estoque insuficiente");
            return;
        }

        sales.add(new Sale(drinks.get(indexBeverage - 1), quantity)); //set a sale
        drinks.get(indexBeverage - 1).setQuantity(
            drinks.get(indexBeverage - 1).getQuantity() - quantity); //take away quantity
        updateFile(); //update quantity of beverages
        writeSale(drinks.get(indexBeverage - 1).getName(), quantity); //set this sale in file sales.txt
    }

    public void listOfSales () {
        for (Sale i : sales) {
            System.out.println(i);
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
