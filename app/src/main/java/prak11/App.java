package prak11;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Wallet wallet = new Wallet("dompet", 10000);
        DebitCard debitCard = new DebitCard("1234-5678-9012", 100000, "1313");
        CreditCard creditCard = new CreditCard("9876-5432-1098", 500000, "345", "1313");

        PaymentProcessor processor = new PaymentProcessor();

        while (true) {
            System.out.print("Masukkan jumlah yang dibayar: ");
            double amount = sc.nextDouble();

            System.out.println("Pilih metode pembayaran:");
            System.out.println("1. Cash (Wallet)");
            System.out.println("2. Debit Card");
            System.out.println("3. Credit Card");
            System.out.print("Masukkan pilihan (1/2/3): ");
            int choice = sc.nextInt();

            try {
                if (choice == 1) {
                    processor.processPayment(wallet, amount);
                    System.out.println("Pembayaran cash berhasil, sisa wallet: " + wallet.getCashValue());
                } else if (choice == 2) {
                    processor.processPayment(debitCard, amount);
                    System.out.println("Pembayaran debit berhasil, sisa saldo debit: " + debitCard.getBalance());
                } else if (choice == 3) {
                    processor.processPayment(creditCard, amount);
                    System.out.println("Pembayaran credit card berhasil, sisa limit: " + creditCard.getRemainingLimit());
                } else {
                    System.out.println("Pilihan tidak valid!");
                }
            } catch (Exception e) {
                System.out.println("Transaksi Gagal: " + e.getMessage());
            }
            System.out.println();
        }
    }
}