import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class serviceVehicleService {
    private JPanel panel;
    private Map<String, Integer> components;
    private String service;
    private int totalCost;
    private StringBuilder selectedComponents;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public serviceVehicleService(JPanel mainPanel, CardLayout cardLayout) {
        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;
        panel = new JPanel();
        panel.setLayout(null);

        JLabel chooseServiceLabel = new JLabel("Pilih jenis layanan:");
        chooseServiceLabel.setBounds(10, 20, 480, 25);
        panel.add(chooseServiceLabel);

        JButton serviceButton = new JButton("Servis");
        serviceButton.setBounds(10, 60, 150, 25);
        panel.add(serviceButton);
        serviceButton.addActionListener(e -> selectService(1));

        JButton tuneUpButton = new JButton("Tune Up");
        tuneUpButton.setBounds(10, 100, 150, 25);
        panel.add(tuneUpButton);
        tuneUpButton.addActionListener(e -> selectService(2));
    }

    public JPanel getPanel() {
        return panel;
    }

    private void selectService(int serviceChoice) {
        components = ServiceComponentManagement.getServiceComponents(serviceChoice);
        service = (serviceChoice == 1) ? "Servis" : "Tune Up";

        JPanel componentPanel = new JPanel();
        componentPanel.setLayout(null);

        JLabel instructionLabel = new JLabel(service.equals("Servis")
                ? "Pilih komponen yang ingin diperiksa :"
                : "Pilih komponen yang ingin di tune up :");
        instructionLabel.setBounds(10, 20, 480, 25);
        componentPanel.add(instructionLabel);

        int yPos = 60;
        Map<JCheckBox, String> checkBoxMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : components.entrySet()) {
            JCheckBox checkBox = new JCheckBox(entry.getKey() + " (Rp" + entry.getValue() + ")");
            checkBox.setBounds(10, yPos, 480, 25);
            componentPanel.add(checkBox);
            checkBoxMap.put(checkBox, entry.getKey());
            yPos += 30;
        }

        JButton proceedButton = new JButton("Lanjutkan");
        proceedButton.setBounds(10, yPos, 150, 25);
        componentPanel.add(proceedButton);
        proceedButton.addActionListener(e -> {
            totalCost = 0;
            selectedComponents = new StringBuilder();
            for (Map.Entry<JCheckBox, String> entry : checkBoxMap.entrySet()) {
                if (entry.getKey().isSelected()) {
                    totalCost += components.get(entry.getValue());
                    selectedComponents.append(entry.getValue()).append(", ");
                }
            }

            if (totalCost > 0) {
                if (serviceChoice == 1) {
                    JOptionPane.showMessageDialog(panel, "Komponen yang rusak: " + selectedComponents.toString()
                            + "\nBiaya total servis: Rp" + totalCost);
                } else {
                    JOptionPane.showMessageDialog(panel, "Komponen yang di tune up: " + selectedComponents.toString()
                            + "\nBiaya total tune up: Rp" + totalCost);
                }
            } else {
                if (serviceChoice == 1) {
                    JOptionPane.showMessageDialog(panel, "Tidak ada komponen yang rusak.");
                } else {
                    JOptionPane.showMessageDialog(panel, "Tidak ada komponen yang di tune up.");
                }
            }

            PaymentProcessor.processPayment(service + " kendaraan", totalCost, mainPanel, cardLayout);
        });

        mainPanel.add(componentPanel, "component");
        cardLayout.show(mainPanel, "component");
    }
}
