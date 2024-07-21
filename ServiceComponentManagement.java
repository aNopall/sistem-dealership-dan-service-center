import java.util.HashMap;
import java.util.Map;

public class ServiceComponentManagement {
    public static Map<String, Integer> getServiceComponents(int serviceChoice) {
        Map<String, Integer> components = new HashMap<>();
        if (serviceChoice == 1) {
            components.put("Mesin dan Komponen Utama", 1000000);
            components.put("Sistem Kelistrikan", 750000);
            components.put("Sistem Rem", 500000);
            components.put("Sistem Kemudi dan Suspensi", 700000);
            components.put("Sistem Pembuangan", 600000);
            components.put("Interior dan Eksterior", 450000);
            components.put("Sistem Bahan Bakar", 800000);
            components.put("AC dan Sistem Pemanas", 550000);
            components.put("Sistem Transmisi", 900000);
        } else if (serviceChoice == 2) {
            components.put("Penggantian Oli Mesin", 200000);
            components.put("Pembersihan Filter Udara", 150000);
            components.put("Pemeriksaan Busi", 100000);
            components.put("Penggantian Filter Bahan Bakar", 250000);
            components.put("Pemeriksaan Timing Belt", 300000);
            components.put("Penggantian Filter Oli", 150000);
            components.put("Pembersihan Throttle Body", 200000);
            components.put("Pemeriksaan Sistem Pendingin", 250000);
            components.put("Pemeriksaan Sistem Knalpot", 200000);
        }
        return components;
    }
}
