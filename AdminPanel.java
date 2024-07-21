import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class AdminPanel {
    private JPanel panel;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public AdminPanel(JPanel mainPanel, CardLayout cardLayout) {
        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;
        panel = new JPanel();
        panel.setLayout(null);

        JLabel adminLabel = new JLabel("Panel Admin - Kelola Data Kendaraan");
        adminLabel.setBounds(10, 20, 480, 25);
        panel.add(adminLabel);

        JButton addCarButton = new JButton("Tambah Mobil");
        addCarButton.setBounds(10, 60, 200, 25);
        panel.add(addCarButton);
        addCarButton.addActionListener(e -> manageVehicle(1));

        JButton addBikeButton = new JButton("Tambah Motor");
        addBikeButton.setBounds(10, 100, 200, 25);
        panel.add(addBikeButton);
        addBikeButton.addActionListener(e -> manageVehicle(2));

        JButton backButton = new JButton("Kembali ke Login");
        backButton.setBounds(10, 140, 200, 25);
        panel.add(backButton);
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "login"));
    }

    public JPanel getPanel() {
        return panel;
    }

    private void manageVehicle(int vehicleChoice) {
        JPanel managePanel = new JPanel();
        managePanel.setLayout(null);

        JLabel manageLabel = new JLabel("Masukkan data untuk " + (vehicleChoice == 1 ? "Mobil" : "Motor") + ":");
        manageLabel.setBounds(10, 20, 480, 25);
        managePanel.add(manageLabel);

        JLabel nameLabel = new JLabel("Nama Kendaraan:");
        nameLabel.setBounds(10, 60, 200, 25);
        managePanel.add(nameLabel);

        JTextField nameField = new JTextField(20);
        nameField.setBounds(220, 60, 150, 25);
        managePanel.add(nameField);

        JLabel priceLabel = new JLabel("Harga Kendaraan:");
        priceLabel.setBounds(10, 100, 200, 25);
        managePanel.add(priceLabel);

        JTextField priceField = new JTextField(20);
        priceField.setBounds(220, 100, 150, 25);
        managePanel.add(priceField);

        JButton saveButton = new JButton("Simpan");
        saveButton.setBounds(10, 140, 150, 25);
        managePanel.add(saveButton);
        saveButton.addActionListener(e -> {
            String name = nameField.getText();
            int price;
            try {
                price = Integer.parseInt(priceField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Harga tidak valid.");
                return;
            }

            VehicleManagement.addVehicle(vehicleChoice, name, price);
            JOptionPane.showMessageDialog(panel, "Kendaraan berhasil ditambahkan.");
            cardLayout.show(mainPanel, "adminPanel");
        });

        mainPanel.add(managePanel, "manageVehicle");
        cardLayout.show(mainPanel, "manageVehicle");
    }
}
