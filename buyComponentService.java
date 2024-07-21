import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class buyComponentService {
    private JPanel panel;
    private Map<String, Integer> components;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public buyComponentService(JPanel mainPanel, CardLayout cardLayout) {
        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;
        panel = new JPanel();
        panel.setLayout(null);

        JLabel chooseComponentLabel = new JLabel("Pilih komponen yang ingin Anda beli:");
        chooseComponentLabel.setBounds(10, 20, 480, 25);
        panel.add(chooseComponentLabel);

        showComponents();
    }

    public JPanel getPanel() {
        return panel;
    }

    private void showComponents() {
        components = ComponentManagement.getComponents();

        JPanel componentPanel = new JPanel();
        componentPanel.setLayout(null);

        JLabel chooseLabel = new JLabel("Pilih komponen yang ingin Anda beli:");
        chooseLabel.setBounds(10, 20, 480, 25);
        componentPanel.add(chooseLabel);

        int yPos = 60;
        Map<JCheckBox, String> checkBoxMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : components.entrySet()) {
            JCheckBox checkBox = new JCheckBox(entry.getKey() + " - Rp" + entry.getValue());
            checkBox.setBounds(10, yPos, 480, 25);
            componentPanel.add(checkBox);
            checkBoxMap.put(checkBox, entry.getKey());
            yPos += 30;
        }

        JButton proceedButton = new JButton("Lanjutkan");
        proceedButton.setBounds(10, yPos, 150, 25);
        componentPanel.add(proceedButton);
        proceedButton.addActionListener(e -> {
            StringBuilder selectedComponents = new StringBuilder();
            int totalPrice = 0;

            for (Map.Entry<JCheckBox, String> entry : checkBoxMap.entrySet()) {
                if (entry.getKey().isSelected()) {
                    String selectedComponent = entry.getValue();
                    int componentPrice = components.get(selectedComponent);
                    selectedComponents.append(selectedComponent).append(" - Rp").append(componentPrice).append("\n");
                    totalPrice += componentPrice;
                }
            }

            if (selectedComponents.length() == 0) {
                JOptionPane.showMessageDialog(panel, "Tidak ada komponen yang dipilih.");
            } else {
                JOptionPane.showMessageDialog(panel,
                        "Anda memilih untuk membeli:\n" + selectedComponents.toString() + "Total Harga: Rp"
                                + totalPrice);
                processPayment(selectedComponents.toString(), totalPrice);
            }
        });

        componentPanel.setBounds(10, 10, 480, yPos + 60);
        panel.add(componentPanel);
    }

    private void processPayment(String selectedComponents, int totalPrice) {
        PaymentProcessor.processPayment("Pembelian Komponen:\n" + selectedComponents, totalPrice, mainPanel,
                cardLayout);
    }
}
