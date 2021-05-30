public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("Алексей", "2828", 1000);
        App app = new App();
        app.startApp(bankAccount);
    }
}
