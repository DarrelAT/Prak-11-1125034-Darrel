package prak11;

import java.util.List;
import java.util.Scanner;

public class PaymentProcessor {
    public void processPayment(PaymentStrategy paymentStrategy, double amount) {
        if (!paymentStrategy.validate(amount)){
            throw new RuntimeException("Pembayaran gagal, Saldo tidak cukup atau limit");
        }

        List<AuthorizationMethod> requiredAuthorizations = paymentStrategy.getRequiredAuthorizations();
        Scanner sc = new Scanner(System.in);

        for (AuthorizationMethod auth : requiredAuthorizations) {
            switch (auth) {
                case PIN: 
                    System.out.print("Masukan PIN:");
                    String pin = sc.next();
                    break;
                case CCV:
                    System.out.print("Masukan CCV:");
                    String ccv = sc.next();
                    break;
            }
        }

        paymentStrategy.pay(amount);

    }
}
