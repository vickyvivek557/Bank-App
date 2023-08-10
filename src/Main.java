public class Main {
    public static void main(String[] args) {
        //Trying to create account with initial balance lessnthan Rs. 1000
//        SBIAccount vivekAcc = new SBIAccount("Vivek", "v223", 900);
        SBIAccount kunalAcc = new SBIAccount("Kunal", "k123", 10000);

//        System.out.println(vivekAcc);//printing account with less than 1000 balance(will show Error:)
        System.out.println(kunalAcc); //printing normal account

        //fetch balance
        System.out.println(kunalAcc.fetchBalance("123"));
        System.out.println(kunalAcc.fetchBalance("k123"));

        //add money
        System.out.println(kunalAcc.addMoney(150000));

        //withdraw money
        System.out.println(kunalAcc.withdrawMoney(200000, "k123"));//insufficient balance
        System.out.println(kunalAcc.withdrawMoney(20000, "k123"));//successful
        System.out.println(kunalAcc.withdrawMoney(20000, "k23"));//wrong password

        //change password
        System.out.println(kunalAcc.changePassword("k123", "k123"));
        System.out.println(kunalAcc.changePassword("12", "kunal234"));
        System.out.println(kunalAcc.changePassword("k123", "k12345"));

        //fetch balance with new password
        System.out.println(kunalAcc.fetchBalance("k12345"));

        //calculate interest
        System.out.println(kunalAcc.calculateInterest(4));
    }
}