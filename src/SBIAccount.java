import java.util.UUID;

public class SBIAccount implements BankAccountInterface{
    private String name;
    private String accountNo;
    private String password;
    private double balance;
    final double rateOfInterest = 7.1;
    final String IFSCCode = "SBIN0009797";

    //default constructor
    public SBIAccount(){

    }
    //parameterised constructor
    public SBIAccount(String name, String password, double amount){
        if(amount < 1000){
            System.out.println("Account can't be created with less than Rs.1000 !!!");
        }else{
        this.name = name;
        this.password = password;
        this.balance = amount;
        this.accountNo = String.valueOf(UUID.randomUUID());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    @Override
    public String fetchBalance(String password) {
        if(this.password.equals(password)){
            return "Your current balance is: " + this.balance;
        }
        return "Incorrect Password !!!";
    }

    @Override
    public String addMoney(double amount) {
        if(amount < 0) return "You are adding Inappropiate amount";
        this.balance += amount;
        return "Amount added successfully. New balance is: " + this.balance;
    }

    @Override
    public String withdrawMoney(double amount, String password) {
        if(this.password.equals(password)){
            if(this.balance < amount){
                return "Insufficient balance !!!";
            }
            this.balance -= amount;
            return "Amount deducted successfully. Your new balance is: " + this.balance;
        }
        return "Wrong Password !!!";
    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {
        if(oldPassword.equals(newPassword)){
            return "New password should be different from original password.";
        }
        if(this.password.equals(oldPassword)){
            this.password = newPassword;
            return "Password updated successfully.";
        }
        return "Incorrect original password !!!";
    }

    @Override
    public String calculateInterest(int year) {
        double interest = (this.balance * year * rateOfInterest) / 100;
        return "Interest for "+ year + " years wii be " + interest;
    }

    @Override
    public String toString() {
        return "SBIAccount{" +
                "name='" + name + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", rateOfInterest=" + rateOfInterest +
                ", IFSCCode='" + IFSCCode + '\'' +
                '}';
    }
}
