public class Main {
    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();
        
        while (true) {
            if (bankingSystem.login()) {
                bankingSystem.showMenu();
            }
        }
    }
} 