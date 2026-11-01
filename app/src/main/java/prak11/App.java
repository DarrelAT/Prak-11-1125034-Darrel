package prak11;

import java.util.Scanner;

public class App{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Wallet wallet = new Wallet("dompet", 10000);

        while(true) {
            System.out.print("Masukan jumlah yang di bayar: ");
            double amount = sc.nextDouble();

            if(wallet.validate(amount)){
                wallet.pay(amount);
                System.out.print("Pembayaran cash berhasil, sisa wallet: " + wallet.cashValue);
            }else{
                System.out.print("Pembayaran gagal saldo tidak cukup, saldo tersisa: " + wallet.cashValue);
            }
            System.out.println();
        }
    }
}
