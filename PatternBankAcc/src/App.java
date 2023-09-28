public class App {
    public static void main(String[] args) throws Exception {
        new Pattern(9);
        
        //Pattern.squarePattern();
        //Pattern.arrowUpPattern();
        //Pattern.rhombusPattern();
        
        Account client1 = new Account(3030, "kevin", 1010);
        client1.depositMoney(50);
        client1.checkAmount();

        Bank bank = new Bank("bradesco");
        bank.newAccount(client1);
        bank.amountOfAllAcc();

        Investment investmentAcc = new Investment(50, "caio", 1020);
        investmentAcc.depositMoney(50);
        investmentAcc.checkAmount();
        investmentAcc.checkInvestment();
    }
}
