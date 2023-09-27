public class Bank {
    String name;
    Account accounts[] = new Account[50];

    public void newAccount(Account account) {
        int i = 0;
        while (accounts[i] != null && i < 50)
            i++;
        if (i < 50)
            this.accounts[i] = account;
    }

    Bank(String name) {
        this.name = name;
    }

    public void amountOfAllAcc() {
        float total = 0;
        for (Account a : accounts) {
            if(a != null) total += a.getAmount();
        }
        System.out.println(total);
    }
}
