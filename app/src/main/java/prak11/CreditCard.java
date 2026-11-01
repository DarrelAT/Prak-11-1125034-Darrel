package prak11;

public class CreditCard {
    public String cardNumber;
    public double limit;
    public double currentDebt;
    public String ccv;
    public String pin;

    public CreditCard(String cardNumber, double limit, double currentDebt, String ccv, String pin){
        this.cardNumber = cardNumber;
        this.limit = limit;
        this.currentDebt = currentDebt;
        this.ccv = ccv;
        this.pin = pin;
    }

    public boolean validate(double amount) {
        return (this.currentDebt + amount) <= this.limit;
    }

    public void pay(double amount) {
            this.currentDebt += amount;
    }

    public double getCurrentDebt(){
        return this.limit - this.currentDebt;
    }
}
