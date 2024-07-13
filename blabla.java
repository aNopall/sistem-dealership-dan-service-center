import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class blabla {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Selamat datang di Sistem Dealership dan Service Center!");
        System.out.println("Silakan pilih opsi:");
        System.out.println("1. Membeli Kendaraan");
        System.out.println("2. Servis Kendaraan");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                buyVehicle();
                break;
            case 2:
                serviceVehicle();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
    }

    private static void buyVehicle() {
        System.out.println("Pilih kendaraan yang ingin Anda beli:");
        System.out.println("1. Mobil");
        System.out.println("2. Motor");
        int vehicleChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Map<String, Integer> vehicles = new HashMap<>();
        String vehicleType = "";
        switch (vehicleChoice) {
            case 1:
                vehicles.put("Nissan GTR", 300000000);
                vehicles.put("Lamborghini Aventador", 350000000);
                vehicles.put("Koenigsegg Jesko", 400000000);
                vehicles.put("BMW M4", 450000000);
                vehicles.put("Avanza", 500000000);
                vehicleType = "Mobil";
                break;
            case 2:
                vehicles.put("Ducati Panigale", 15000000);
                vehicles.put("Kawasaki Ninja H2R", 20000000);
                vehicles.put("Harley Davidson", 25000000);
                vehicles.put("Yamaha R15", 30000000);
                vehicles.put("Honda CBR", 35000000);
                vehicleType = "Motor";
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                return;
        }

        System.out.println("Pilih " + vehicleType + " yang ingin Anda beli:");
        int i = 1;
        for (Map.Entry<String, Integer> entry : vehicles.entrySet()) {
            System.out.println(i + ". " + entry.getKey() + " - Rp" + entry.getValue());
            i++;
        }

        int selectedVehicleIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // consume newline

        if (selectedVehicleIndex < 0 || selectedVehicleIndex >= vehicles.size()) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        String selectedVehicle = (String) vehicles.keySet().toArray()[selectedVehicleIndex];
        int vehiclePrice = vehicles.get(selectedVehicle);
        System.out.println("Anda memilih untuk membeli: " + selectedVehicle + " dengan harga Rp" + vehiclePrice);

        System.out.println("Masukkan No Kartu Keluarga:");
        String noKK = scanner.nextLine();
        System.out.println("Masukkan No KTP:");
        String noKTP = scanner.nextLine();

        if (noKK.isEmpty() || noKTP.isEmpty()) {
            System.out.println("Verifikasi ditolak. No Kartu Keluarga dan No KTP harus diisi.");
            main(null); // Kembali ke menu utama
            return;
        }

        processPayment("Pembelian " + selectedVehicle, vehiclePrice);
    }

    private static void serviceVehicle() {
        System.out.println("Pilih jenis servis:");
        System.out.println("1. Servis");
        System.out.println("2. Tune Up");
        int serviceChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String service = "";
        Map<String, Integer> components = new HashMap<>();
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

        int totalCost = 0;
        StringBuilder selectedComponents = new StringBuilder();
        for (Map.Entry<String, Integer> entry : components.entrySet()) {
            System.out.println(entry.getKey() + " (Rp" + entry.getValue() + "):");
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

        processPayment(service + " kendaraan", totalCost);
    }

    private static void processPayment(String transaction, int amount) {
        System.out.println("Pilih metode pembayaran:");
        System.out.println("1. Kredit");
        System.out.println("2. Debit");
        System.out.println("3. Tunai");
        int paymentChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline

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

    private static void printReceipt(String transaction, String paymentMethod, int amount) {
        System.out.println("----- Struk Pembayaran -----");
        System.out.println("Transaksi: " + transaction);
        System.out.println("Metode Pembayaran: " + paymentMethod);
        System.out.println("Total Pembayaran: Rp" + amount);
        System.out.println("Terima kasih telah menggunakan layanan kami!");
        System.out.println("---------------------------");
    }
}
