import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class VehicleCatalog {
    private JPanel panel;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public VehicleCatalog(JPanel mainPanel, CardLayout cardLayout) {
        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Katalog Kendaraan", SwingConstants.CENTER);
        panel.add(label, BorderLayout.NORTH);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Mobil", createVehiclePanel(1));
        tabbedPane.addTab("Motor", createVehiclePanel(2));
        panel.add(tabbedPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Kembali ke Menu");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "menu"));
        panel.add(backButton, BorderLayout.SOUTH);
    }

    public JPanel getPanel() {
        return panel;
    }

    private JPanel createVehiclePanel(int vehicleChoice) {
        JPanel vehiclePanel = new JPanel();
        vehiclePanel.setLayout(new BoxLayout(vehiclePanel, BoxLayout.Y_AXIS));
        Map<String, Integer> vehicles = VehicleManagement.getVehicles(vehicleChoice);

        for (Map.Entry<String, Integer> entry : vehicles.entrySet()) {
            JLabel vehicleLabel = new JLabel(entry.getKey() + " - Rp" + entry.getValue());
            vehicleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            vehiclePanel.add(vehicleLabel);
        }

        return vehiclePanel;
    }
}
