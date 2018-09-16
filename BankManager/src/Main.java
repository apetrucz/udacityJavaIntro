public class Main {
    public static void main(String [] args){


        CheckingAccount AniaChecking = new CheckingAccount();
        AniaChecking.setAcctNumber("134-567");
        AniaChecking.setBalance(1500.0);
        AniaChecking.setLimit(900);
        System.out.println(AniaChecking.getBalance());





    }

}
