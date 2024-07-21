import javax.swing.*;
import java.awt.*;

public class Main {
    private static JFrame frame = new JFrame("Sistem Dealership dan Service Center");
    private static CardLayout cardLayout = new CardLayout();
    private static JPanel mainPanel = new JPanel(cardLayout);

    public static void main(String[] args) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);

        JLabel loginLabel = new JLabel("Masuk sebagai:");
        loginLabel.setBounds(10, 20, 480, 25);
        loginPanel.add(loginLabel);

        JButton buyerButton = new JButton("Pembeli");
        buyerButton.setBounds(10, 60, 200, 25);
        loginPanel.add(buyerButton);
        buyerButton.addActionListener(e -> cardLayout.show(mainPanel, "menu"));

        JButton adminButton = new JButton("Admin");
        adminButton.setBounds(10, 100, 200, 25);
        loginPanel.add(adminButton);
        adminButton.addActionListener(e -> cardLayout.show(mainPanel, "adminPanel"));

        mainPanel.add(loginPanel, "login");

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(null);

        JLabel welcomeLabel = new JLabel("Selamat datang di Sistem Dealership dan Service Center!");
        welcomeLabel.setBounds(10, 20, 480, 25);
        menuPanel.add(welcomeLabel);

        JLabel optionLabel = new JLabel("Silakan pilih opsi:");
        optionLabel.setBounds(10, 60, 200, 25);
        menuPanel.add(optionLabel);

        JButton catalogButton = new JButton("Lihat Katalog Kendaraan");
        catalogButton.setBounds(10, 100, 200, 25);
        menuPanel.add(catalogButton);
        catalogButton.addActionListener(e -> cardLayout.show(mainPanel, "vehicleCatalog"));

        JButton buyButton = new JButton("Membeli Kendaraan");
        buyButton.setBounds(10, 140, 200, 25);
        menuPanel.add(buyButton);
        buyButton.addActionListener(e -> cardLayout.show(mainPanel, "buyVehicleService"));

        JButton serviceButton = new JButton("Servis Kendaraan");
        serviceButton.setBounds(10, 140, 200, 25);
        menuPanel.add(serviceButton);
        serviceButton.addActionListener(e -> cardLayout.show(mainPanel, "serviceVehicleService"));

        JButton componentButton = new JButton("Membeli Komponen");
        componentButton.setBounds(10, 180, 200, 25);
        menuPanel.add(componentButton);
        componentButton.addActionListener(e -> cardLayout.show(mainPanel, "buyComponentService"));

        mainPanel.add(menuPanel, "menu");

        AdminPanel adminPanel = new AdminPanel(mainPanel, cardLayout);
        mainPanel.add(adminPanel.getPanel(), "adminPanel");

        VehicleCatalog vehicleCatalog = new VehicleCatalog(mainPanel, cardLayout);
        mainPanel.add(vehicleCatalog.getPanel(), "vehicleCatalog");

        buyVehicleService buyService = new buyVehicleService(mainPanel, cardLayout);
        mainPanel.add(buyService.getPanel(), "buyVehicleService");

        buyComponentService componentService = new buyComponentService(mainPanel, cardLayout);
        mainPanel.add(componentService.getPanel(), "buyComponentService");

        frame.add(mainPanel);
        cardLayout.show(mainPanel, "login");
        frame.setVisible(true);
    }
}
