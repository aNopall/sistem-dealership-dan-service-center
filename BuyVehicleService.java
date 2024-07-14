import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class buyVehicleService {
    private Scanner scanner;
    private Map<String, Integer> vehicles;
    private String vehicleType;

    public buyVehicleService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void buyVehicle() {
        System.out.println("Pilih kendaraan yang ingin Anda beli:");
        System.out.println("1. Mobil");
        System.out.println("2. Motor");
        System.out.print("Masukkan input : ");

        int vehicleChoice = scanner.nextInt();
        scanner.nextLine();

        vehicles = new HashMap<>();
        vehicleType = "";
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
        System.out.print("Masukkan input : ");

        int selectedVehicleIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (selectedVehicleIndex < 0 || selectedVehicleIndex >= vehicles.size()) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        String selectedVehicle = (String) vehicles.keySet().toArray()[selectedVehicleIndex];
        int vehiclePrice = vehicles.get(selectedVehicle);
        System.out.println("Anda memilih untuk membeli: " + selectedVehicle + " dengan harga Rp" + vehiclePrice);

        System.out.println("Masukkan No Kartu Keluarga:");
        System.out.print("Masukkan input : ");
        String noKK = scanner.nextLine();
        System.out.println("Masukkan No KTP:");
        System.out.print("Masukkan input : ");
        String noKTP = scanner.nextLine();

        if (noKK.isEmpty() || noKTP.isEmpty()) {
            System.out.println("Verifikasi ditolak. No Kartu Keluarga dan No KTP harus diisi.");
            Main.main(null); // Kembali ke menu utama
            return;
        }

        PaymentProcessor.processPayment("Pembelian " + selectedVehicle, vehiclePrice, scanner);
    }
}
