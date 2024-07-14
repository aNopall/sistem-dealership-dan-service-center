import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class serviceVehicleService {
    private Scanner scanner;
    private String service;
    private Map<String, Integer> components;
    private int totalCost;
    private StringBuilder selectedComponents;

    public serviceVehicleService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void serviceVehicle() {
        System.out.println("Pilih jenis servis:");
        System.out.println("1. Servis");
        System.out.println("2. Tune Up");
        System.out.print("Masukkan input : ");

        int serviceChoice = scanner.nextInt();
        scanner.nextLine();

        service = "";
        components = new HashMap<>();
        if (serviceChoice == 1) {
            service = "Servis";
            components.put("Mesin dan Komponen Utama", 1000000);
            components.put("Sistem Kelistrikan", 750000);
            components.put("Sistem Rem", 500000);
            components.put("Sistem Kemudi dan Suspensi", 700000);
            components.put("Sistem Pembuangan", 600000);
            components.put("Interior dan Eksterior", 450000);
            components.put("Sistem Bahan Bakar", 800000);
            components.put("AC dan Sistem Pemanas", 550000);
            components.put("Sistem Transmisi", 900000);
            System.out.println(
                    "Pilih komponen yang ingin diperiksa (masukkan 'Rusak' atau 'Tidak' untuk setiap komponen):");
        } else if (serviceChoice == 2) {
            service = "Tune Up";
            components.put("Penggantian Oli Mesin", 200000);
            components.put("Pembersihan Filter Udara", 150000);
            components.put("Pemeriksaan Busi", 100000);
            components.put("Penggantian Filter Bahan Bakar", 250000);
            components.put("Pemeriksaan Timing Belt", 300000);
            components.put("Penggantian Filter Oli", 150000);
            components.put("Pembersihan Throttle Body", 200000);
            components.put("Pemeriksaan Sistem Pendingin", 250000);
            components.put("Pemeriksaan Sistem Knalpot", 200000);
            System.out.println(
                    "Pilih komponen yang ingin di tune up (masukkan 'Iya' atau 'Tidak' untuk setiap komponen):");
        } else {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        totalCost = 0;
        selectedComponents = new StringBuilder();
        for (Map.Entry<String, Integer> entry : components.entrySet()) {
            System.out.println(entry.getKey() + " (Rp" + entry.getValue() + "):");
            System.out.print("Masukkan input : ");
            String condition = scanner.nextLine();
            if (condition.equalsIgnoreCase("Rusak") || condition.equalsIgnoreCase("Iya")) {
                totalCost += entry.getValue();
                selectedComponents.append(entry.getKey()).append(", ");
            }
        }

        if (totalCost > 0) {
            if (serviceChoice == 1) {
                System.out.println("Komponen yang rusak: " + selectedComponents.toString());
                System.out.println("Biaya total " + service.toLowerCase() + ": Rp" + totalCost);
            } else {
                System.out.println("Komponen yang di tune up: " + selectedComponents.toString());
                System.out.println("Biaya total " + service.toLowerCase() + ": Rp" + totalCost);
            }
        } else {
            if (serviceChoice == 1) {
                System.out.println("Tidak ada komponen yang rusak.");
            } else {
                System.out.println("Tidak ada komponen yang di tune up.");
            }
        }

        PaymentProcessor.processPayment(service + " kendaraan", totalCost, scanner);
    }
}
