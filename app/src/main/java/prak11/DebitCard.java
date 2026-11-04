package prak11;

import java.util.List;

public class DebitCard implements PaymentStrategy {
    private String cardNumber;
    private double balance;
    private String pin;

    public DebitCard(String cardNumber, double balance, String pin) {
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.pin = pin;
    }

    @Override
    public boolean validate(double amount) {
        return this.balance >= amount;
    }

    @Override
    public void pay(double amount) {
        if (validate(amount)) {
            this.balance -= amount;
        }
    }

    @Override
    public List<AuthorizationMethod> getRequiredAuthorizations() {
        return List.of(AuthorizationMethod.PIN); // Butuh PIN
    }

    public double getBalance() {
        return this.balance;
    }
}