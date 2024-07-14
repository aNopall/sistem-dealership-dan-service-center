import java.util.Scanner;

public class PaymentProcessor {
    public static void processPayment(String transaction, int amount, Scanner scanner) {
        System.out.println("Pilih metode pembayaran:");
        System.out.println("1. Kredit");
        System.out.println("2. Debit");
        System.out.println("3. Tunai");
        System.out.print("Masukkan input : ");

        int paymentChoice = scanner.nextInt();
        scanner.nextLine();

        String paymentMethod = "";
        switch (paymentChoice) {
            case 1:
                paymentMethod = "Kredit";
                break;
            case 2:
                paymentMethod = "Debit";
                break;
            case 3:
                paymentMethod = "Tunai";
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                return;
        }

        System.out.println("Anda memilih metode pembayaran: " + paymentMethod);
        printReceipt(transaction, paymentMethod, amount);
    }

    public static void printReceipt(String transaction, String paymentMethod, int amount) {
        System.out.println("----- Struk Pembayaran -----");
        System.out.println("Transaksi: " + transaction);
        System.out.println("Metode Pembayaran: " + paymentMethod);
        System.out.println("Total Pembayaran: Rp" + amount);
        System.out.println("Terima kasih telah menggunakan layanan kami!");
        System.out.println("---------------------------");
    }
}
