public class BankAccount {
    private String acctNumber;
    private double balance;

    BankAccount(){
        acctNumber = "";
        balance = 0;
    }


    public void setAcctNumber(String acctNumber){
        this.acctNumber = acctNumber;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public String getAcctNumber(){
        return acctNumber;
    }

}
