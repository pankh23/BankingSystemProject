import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DataStorage {
    private static final String DATA_FILE = "bank_data.dat";

    public static void saveUsers(Map<String, User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(users);
            System.out.println("Data saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<String, User> loadUsers() {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            Map<String, User> defaultUsers = new HashMap<>();
            defaultUsers.put("john", new User("john", "pass123", 5000.0));
            defaultUsers.put("alice", new User("alice", "pass456", 3000.0));
            return defaultUsers;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            return (Map<String, User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
            return new HashMap<>();
        }
    }
} 