package prak11;
public class DebitCard {
    public String cardNumber;
    public double balance;
    public String pin;

    public DebitCard (String cardNumber, double balance, String pin) {
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.pin = pin;
    }

    public boolean validate (double amount){
        return this.balance >= amount;
    }

    public void pay (double amount){
        this.balance -= amount;
    }

    public double getBalance(){
        return this.balance;
    }
}