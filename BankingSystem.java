import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankingSystem {
    // ANSI color codes
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN = "\u001B[36m";
    private static final String PURPLE = "\u001B[35m";
    private static final String RED = "\u001B[31m";
    private static final String BOLD = "\u001B[1m";

    // Emojis
    private static final String BANK = "🏦";
    private static final String MONEY = "💰";
    private static final String CARD = "💳";
    private static final String BILL = "📝";
    private static final String SUPPORT = "📞";
    private static final String LOGOUT = "🚪";
    private static final String SUCCESS = "✅";
    private static final String ERROR = "❌";
    private static final String WAVE = "👋";

    private Map<String, User> users;
    private User currentUser;
    private Scanner scanner;

    public BankingSystem() {
        users = DataStorage.loadUsers();
        scanner = new Scanner(System.in);
        printWelcomeMessage();
    }

    private void printWelcomeMessage() {
        System.out.println("\n" + BOLD + BLUE + "╔════════════════════════════════════════════════════════════╗");
        System.out.println("║" + CYAN + "              Welcome to Secure Banking System " + BANK + "              " + BLUE + "║");
        System.out.println("╚════════════════════════════════════════════════════════════╝" + RESET);
    }

    public boolean login() {
        while (true) {
            System.out.println("\n" + BOLD + BLUE + "╔════════════════════════════════════════════════════════════╗");
            System.out.println("║" + CYAN + "                        Login Menu " + CARD + "                        " + BLUE + "║");
            System.out.println("╚════════════════════════════════════════════════════════════╝" + RESET);
            System.out.println(BOLD + YELLOW + "1. Login");
            System.out.println("2. Register New User" + RESET);
            System.out.print(CYAN + "Enter your choice (1-2): " + RESET);

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 2) {
                    register();
                    continue;
                } else if (choice != 1) {
                    System.out.println(RED + ERROR + " Invalid choice. Please try again." + RESET);
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println(RED + ERROR + " Please enter a valid number." + RESET);
                continue;
            }

            System.out.print(CYAN + "Enter username: " + RESET);
            String username = scanner.nextLine();
            System.out.print(CYAN + "Enter password: " + RESET);
            String password = scanner.nextLine();

            User user = users.get(username);
            if (user != null && user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println(GREEN + SUCCESS + " Login successful! Welcome " + WAVE + RESET);
                return true;
            }
            System.out.println(RED + ERROR + " Invalid credentials. Please try again." + RESET);
        }
    }

    private void register() {
        System.out.println("\n" + BOLD + BLUE + "╔════════════════════════════════════════════════════════════╗");
        System.out.println("║" + CYAN + "                    Register New User " + CARD + "                    " + BLUE + "║");
        System.out.println("╚════════════════════════════════════════════════════════════╝" + RESET);
        
        System.out.print(CYAN + "Enter new username: " + RESET);
        String username = scanner.nextLine();

        if (users.containsKey(username)) {
            System.out.println(RED + ERROR + " Username already exists. Please choose a different username." + RESET);
            return;
        }

        System.out.print(CYAN + "Enter password: " + RESET);
        String password = scanner.nextLine();

        if (password.length() < 6) {
            System.out.println(RED + ERROR + " Password must be at least 6 characters long." + RESET);
            return;
        }

        System.out.print(CYAN + "Enter initial balance: $" + RESET);
        try {
            double initialBalance = Double.parseDouble(scanner.nextLine());
            if (initialBalance < 0) {
                System.out.println(RED + ERROR + " Initial balance cannot be negative." + RESET);
                return;
            }

            users.put(username, new User(username, password, initialBalance));
            DataStorage.saveUsers(users);
            System.out.println(GREEN + SUCCESS + " Registration successful! You can now login." + RESET);
        } catch (NumberFormatException e) {
            System.out.println(RED + ERROR + " Invalid balance amount entered." + RESET);
        }
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n" + BOLD + BLUE + "╔════════════════════════════════════════════════════════════╗");
            System.out.println("║" + CYAN + "                      Banking Menu " + BANK + "                      " + BLUE + "║");
            System.out.println("╚════════════════════════════════════════════════════════════╝" + RESET);
            System.out.println(BOLD + YELLOW + "1. " + MONEY + " View Balance");
            System.out.println("2. " + CARD + " Fund Transfer");
            System.out.println("3. " + BILL + " Bill Payment");
            System.out.println("4. " + SUPPORT + " Access Customer Support");
            System.out.println("5. " + LOGOUT + " Logout" + RESET);
            System.out.print(CYAN + "Enter your choice (1-5): " + RESET);

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        viewBalance();
                        break;
                    case 2:
                        fundTransfer();
                        break;
                    case 3:
                        billPayment();
                        break;
                    case 4:
                        customerSupport();
                        break;
                    case 5:
                        logout();
                        return;
                    default:
                        System.out.println(RED + ERROR + " Invalid choice. Please try again." + RESET);
                }
            } catch (NumberFormatException e) {
                System.out.println(RED + ERROR + " Please enter a valid number." + RESET);
            }
        }
    }

    private void viewBalance() {
        System.out.println("\n" + BOLD + BLUE + "╔════════════════════════════════════════════════════════════╗");
        System.out.println("║" + CYAN + "                      Account Balance " + MONEY + "                    " + BLUE + "║");
        System.out.println("╚════════════════════════════════════════════════════════════╝" + RESET);
        System.out.println(GREEN + "Current Balance: $" + String.format("%.2f", currentUser.getBalance()) + RESET);
    }

    private void fundTransfer() {
        System.out.println("\n" + BOLD + BLUE + "╔════════════════════════════════════════════════════════════╗");
        System.out.println("║" + CYAN + "                     Fund Transfer " + CARD + "                       " + BLUE + "║");
        System.out.println("╚════════════════════════════════════════════════════════════╝" + RESET);
        
        System.out.print(CYAN + "Enter receiver's username: " + RESET);
        String receiverUsername = scanner.nextLine();

        User receiver = users.get(receiverUsername);
        if (receiver == null) {
            System.out.println(RED + ERROR + " Receiver not found." + RESET);
            return;
        }

        try {
            System.out.print(CYAN + "Enter amount to transfer: $" + RESET);
            double amount = Double.parseDouble(scanner.nextLine());

            if (amount <= 0) {
                System.out.println(RED + ERROR + " Amount must be greater than 0." + RESET);
                return;
            }

            if (amount > currentUser.getBalance()) {
                System.out.println(RED + ERROR + " Insufficient balance." + RESET);
                return;
            }

            currentUser.setBalance(currentUser.getBalance() - amount);
            receiver.setBalance(receiver.getBalance() + amount);
            DataStorage.saveUsers(users);
            System.out.println(GREEN + SUCCESS + " Transfer successful!" + RESET);
            System.out.println(CYAN + "New balance: $" + String.format("%.2f", currentUser.getBalance()) + RESET);
        } catch (NumberFormatException e) {
            System.out.println(RED + ERROR + " Invalid amount entered." + RESET);
        }
    }

    private void billPayment() {
        System.out.println("\n" + BOLD + BLUE + "╔════════════════════════════════════════════════════════════╗");
        System.out.println("║" + CYAN + "                     Bill Payment " + BILL + "                        " + BLUE + "║");
        System.out.println("╚════════════════════════════════════════════════════════════╝" + RESET);
        System.out.println(BOLD + YELLOW + "Select bill type:");
        System.out.println("1. Electricity ($100)");
        System.out.println("2. Water ($50)");
        System.out.println("3. Internet ($75)" + RESET);
        System.out.print(CYAN + "Enter your choice (1-3): " + RESET);

        try {
            int choice = Integer.parseInt(scanner.nextLine());
            double amount = 0;

            switch (choice) {
                case 1:
                    amount = 100;
                    break;
                case 2:
                    amount = 50;
                    break;
                case 3:
                    amount = 75;
                    break;
                default:
                    System.out.println(RED + ERROR + " Invalid choice." + RESET);
                    return;
            }

            if (amount > currentUser.getBalance()) {
                System.out.println(RED + ERROR + " Insufficient balance." + RESET);
                return;
            }

            currentUser.setBalance(currentUser.getBalance() - amount);
            DataStorage.saveUsers(users);
            System.out.println(GREEN + SUCCESS + " Bill payment successful!" + RESET);
            System.out.println(CYAN + "New balance: $" + String.format("%.2f", currentUser.getBalance()) + RESET);
        } catch (NumberFormatException e) {
            System.out.println(RED + ERROR + " Invalid input." + RESET);
        }
    }

    private void customerSupport() {
        System.out.println("\n" + BOLD + BLUE + "╔════════════════════════════════════════════════════════════╗");
        System.out.println("║" + CYAN + "                  Customer Support " + SUPPORT + "                    " + BLUE + "║");
        System.out.println("╚════════════════════════════════════════════════════════════╝" + RESET);
        System.out.println(PURPLE + "For assistance, please contact our 24/7 support:");
        System.out.println("📱 Phone: 1-800-BANK-HELP");
        System.out.println("📧 Email: support@bank.com" + RESET);
    }

    private void logout() {
        currentUser = null;
        System.out.println(GREEN + SUCCESS + " Logged out successfully. Goodbye! " + WAVE + RESET);
    }
} 