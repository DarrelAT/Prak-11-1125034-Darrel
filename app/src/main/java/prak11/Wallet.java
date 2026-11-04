package prak11;

import java.util.List;

public class Wallet implements PaymentStrategy {
    private String name;
    private double cashValue;

    public Wallet(String name, double cashValue) {
        this.name = name;
        this.cashValue = cashValue;
    }

    @Override
    public boolean validate(double amount) {
        return this.cashValue >= amount;
    }

    @Override
    public void pay(double amount) {
        if (validate(amount)) {
            this.cashValue -= amount;
        }
    }

    @Override
    public List<AuthorizationMethod> getRequiredAuthorizations() {
        return List.of(); // Cash tidak butuh PIN/CCV
    }

    public double getCashValue() {
        return this.cashValue;
    }
}