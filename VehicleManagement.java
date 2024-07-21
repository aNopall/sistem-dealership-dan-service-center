import java.util.HashMap;
import java.util.Map;

public class VehicleManagement {
    private static Map<String, Integer> cars = new HashMap<>();
    private static Map<String, Integer> bikes = new HashMap<>();

    static {
        cars.put("Nissan GTR", 300000000);
        cars.put("Lamborghini Aventador", 350000000);
        cars.put("Koenigsegg Jesko", 400000000);
        cars.put("BMW M4", 450000000);
        cars.put("Avanza", 500000000);

        bikes.put("Ducati Panigale", 15000000);
        bikes.put("Kawasaki Ninja H2R", 20000000);
        bikes.put("Harley Davidson", 25000000);
        bikes.put("Yamaha R15", 30000000);
        bikes.put("Honda CBR", 35000000);
    }

    public static Map<String, Integer> getVehicles(int vehicleChoice) {
        return vehicleChoice == 1 ? cars : bikes;
    }

    public static void addVehicle(int vehicleChoice, String name, int price) {
        if (vehicleChoice == 1) {
            cars.put(name, price);
        } else {
            bikes.put(name, price);
        }
    }
}
