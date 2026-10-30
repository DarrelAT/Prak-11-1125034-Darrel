package prak11;
public class Wallet {
    public String name;
    public double cashValue;

    public Wallet(String name, double cashValue){
        this.name = name;
        this.cashValue = cashValue;
    }

    public boolean validate(double amount){
        return this.cashValue >= amount;
    }

    public void pay(double amount){
        this.cashValue -= amount;
    }
}
