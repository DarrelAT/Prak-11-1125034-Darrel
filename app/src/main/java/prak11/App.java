package prak11;

import java.util.Scanner;

public class App{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Wallet wallet = new Wallet("dompet", 10000);
        DebitCard debitcard = new DebitCard("123-456-77", 100000, "1313");
        CreditCard creditcard = new CreditCard("112-333-456", 1000000, 0, "112", "1313");

        while(true) {
            System.out.print("Masukan jumlah yang di bayar: ");
            double amount = sc.nextDouble();

            System.out.println("Pilih Metode Pembayaran: ");
            System.out.println("1. Wallet (cash)");
            System.out.println("2. Debit Card");
            System.out.println("3. Credit Card");
            int metode = sc.nextInt();

            if(metode == 1){
                if(wallet.validate(amount)) {
                    wallet.pay(amount);
                    System.out.println("Pembayaran cash berhasil, sisa saldo wallet: " + wallet.getCashValue());
                }else{
                    System.out.println("Pembayaran gagal, sisa saldo wallet: " + wallet.getCashValue());
                }
            }else if(metode == 2){
                if(debitcard.validate(amount)) {
                    debitcard.pay(amount);
                    System.out.println("Pembayarn debit berhasil, sisa saldo debit: " + debitcard.getBalance());
                }else{
                    System.out.println("Pembayaran gagal saldo debit tidak cukup, sisa saldo debit: " + debitcard.getBalance());
                }
            }else if(metode == 3){
                if(creditcard.validate(amount)) {
                    creditcard.pay(amount);
                    System.out.println("Pembayaran Credit berhasil, limit sisa: " + creditcard.getCurrentDebt());
                }else{
                    System.out.println("Pembayaran gagal saldo melebih limit, limit saldo: "+ creditcard.getCurrentDebt());
                }
            }else{
                System.out.println("Metode Pembayaran tidak valid ");
            }
            System.out.println();
        }
    }
}
