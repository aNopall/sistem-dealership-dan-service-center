import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class buyVehicleService {
    private JPanel panel;
    private Map<String, Integer> vehicles;
    private String vehicleType;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public buyVehicleService(JPanel mainPanel, CardLayout cardLayout) {
        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;
        panel = new JPanel();
        panel.setLayout(null);

        JLabel chooseVehicleLabel = new JLabel("Pilih kendaraan yang ingin Anda beli:");
        chooseVehicleLabel.setBounds(10, 20, 480, 25);
        panel.add(chooseVehicleLabel);

        JButton carButton = new JButton("Mobil");
        carButton.setBounds(10, 60, 150, 25);
        panel.add(carButton);
        carButton.addActionListener(e -> showVehicles(1));

        JButton bikeButton = new JButton("Motor");
        bikeButton.setBounds(10, 100, 150, 25);
        panel.add(bikeButton);
        bikeButton.addActionListener(e -> showVehicles(2));
    }

    public JPanel getPanel() {
        return panel;
    }

    private void showVehicles(int vehicleChoice) {
        vehicles = VehicleManagement.getVehicles(vehicleChoice);
        vehicleType = (vehicleChoice == 1) ? "Mobil" : "Motor";

        JPanel vehiclePanel = new JPanel();
        vehiclePanel.setLayout(null);

        JLabel chooseLabel = new JLabel("Pilih " + vehicleType + " yang ingin Anda beli:");
        chooseLabel.setBounds(10, 20, 480, 25);
        vehiclePanel.add(chooseLabel);

        int yPos = 60;
        ButtonGroup group = new ButtonGroup();
        Map<JRadioButton, String> buttonMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : vehicles.entrySet()) {
            JRadioButton button = new JRadioButton(entry.getKey() + " - Rp" + entry.getValue());
            button.setBounds(10, yPos, 480, 25);
            vehiclePanel.add(button);
            group.add(button);
            buttonMap.put(button, entry.getKey());
            yPos += 30;
        }

        JButton proceedButton = new JButton("Lanjutkan");
        proceedButton.setBounds(10, yPos, 150, 25);
        vehiclePanel.add(proceedButton);
        proceedButton.addActionListener(e -> {
            for (Map.Entry<JRadioButton, String> entry : buttonMap.entrySet()) {
                if (entry.getKey().isSelected()) {
                    String selectedVehicle = entry.getValue();
                    int vehiclePrice = vehicles.get(selectedVehicle);
                    JOptionPane.showMessageDialog(panel,
                            "Anda memilih untuk membeli: " + selectedVehicle + " dengan harga Rp" + vehiclePrice);
                    requestKKandKTP(selectedVehicle, vehiclePrice);
                    return;
                }
            }
            JOptionPane.showMessageDialog(panel, "Pilihan tidak valid.");
        });

        mainPanel.add(vehiclePanel, "chooseVehicle");
        cardLayout.show(mainPanel, "chooseVehicle");
    }

    private void requestKKandKTP(String selectedVehicle, int vehiclePrice) {
        JPanel kkKtpPanel = new JPanel();
        kkKtpPanel.setLayout(null);

        JLabel kkLabel = new JLabel("Masukkan No Kartu Keluarga:");
        kkLabel.setBounds(10, 20, 200, 25);
        kkKtpPanel.add(kkLabel);

        JTextField kkField = new JTextField(20);
        kkField.setBounds(220, 20, 150, 25);
        kkKtpPanel.add(kkField);

        JLabel ktpLabel = new JLabel("Masukkan No KTP:");
        ktpLabel.setBounds(10, 60, 200, 25);
        kkKtpPanel.add(ktpLabel);

        JTextField ktpField = new JTextField(20);
        ktpField.setBounds(220, 60, 150, 25);
        kkKtpPanel.add(ktpField);

        JButton proceedButton = new JButton("Lanjutkan");
        proceedButton.setBounds(10, 100, 150, 25);
        kkKtpPanel.add(proceedButton);
        proceedButton.addActionListener(e -> {
            String noKK = kkField.getText();
            String noKTP = ktpField.getText();
            if (noKK.isEmpty() || noKTP.isEmpty()) {
                JOptionPane.showMessageDialog(panel, "Verifikasi ditolak. No Kartu Keluarga dan No KTP harus diisi.");
                cardLayout.show(mainPanel, "menu");
                return;
            }
            PaymentProcessor.processPayment("Pembelian " + selectedVehicle, vehiclePrice, mainPanel, cardLayout);
        });

        mainPanel.add(kkKtpPanel, "kkKtp");
        cardLayout.show(mainPanel, "kkKtp");
    }
}
