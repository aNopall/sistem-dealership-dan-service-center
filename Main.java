import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Selamat datang di Sistem Dealership dan Service Center!");
        System.out.println("Silakan pilih opsi:");
        System.out.println("1. Membeli Kendaraan");
        System.out.println("2. Servis Kendaraan");
        System.out.print("Masukkan input : ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                buyVehicleService buyService = new buyVehicleService(scanner);
                buyService.buyVehicle();
                break;
            case 2:
                serviceVehicleService serviceService = new serviceVehicleService(scanner);
                serviceService.serviceVehicle();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
    }
}
