import javax.swing.*;
import java.awt.*;

public class PaymentProcessor {
    public static void processPayment(String transaction, int amount, JPanel mainPanel, CardLayout cardLayout) {
        JPanel paymentPanel = new JPanel();
        paymentPanel.setLayout(null);

        JLabel paymentLabel = new JLabel("Pilih metode pembayaran:");
        paymentLabel.setBounds(10, 20, 480, 25);
        paymentPanel.add(paymentLabel);

        JButton creditButton = new JButton("Kredit");
        creditButton.setBounds(10, 60, 150, 25);
        paymentPanel.add(creditButton);
        creditButton.addActionListener(e -> printReceipt(transaction, "Kredit", amount, mainPanel, cardLayout));

        JButton cashButton = new JButton("Tunai");
        cashButton.setBounds(10, 100, 150, 25);
        paymentPanel.add(cashButton);
        cashButton.addActionListener(e -> printReceipt(transaction, "Tunai", amount, mainPanel, cardLayout));

        mainPanel.add(paymentPanel, "payment");
        cardLayout.show(mainPanel, "payment");
    }

    public static void printReceipt(String transaction, String paymentMethod, int amount, JPanel mainPanel,
            CardLayout cardLayout) {
        JPanel receiptPanel = new JPanel();
        receiptPanel.setLayout(null);

        JLabel transactionLabel = new JLabel("Transaksi: " + transaction);
        transactionLabel.setBounds(10, 20, 480, 25);
        receiptPanel.add(transactionLabel);

        JLabel paymentLabel = new JLabel("Metode Pembayaran: " + paymentMethod);
        paymentLabel.setBounds(10, 50, 480, 25);
        receiptPanel.add(paymentLabel);

        JLabel amountLabel = new JLabel("Total Pembayaran: Rp" + amount);
        amountLabel.setBounds(10, 80, 480, 25);
        receiptPanel.add(amountLabel);

        JLabel thanksLabel = new JLabel("Terima kasih telah menggunakan layanan kami!");
        thanksLabel.setBounds(10, 110, 480, 25);
        receiptPanel.add(thanksLabel);

        JButton exitButton = new JButton("Keluar");
        exitButton.setBounds(10, 140, 200, 25);
        receiptPanel.add(exitButton);
        exitButton.addActionListener(e -> System.exit(0));

        JButton backButton = new JButton("Kembali ke Menu Awal");
        backButton.setBounds(10, 180, 200, 25);
        receiptPanel.add(backButton);
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "menu"));

        mainPanel.add(receiptPanel, "receipt");
        cardLayout.show(mainPanel, "receipt");
    }
}
