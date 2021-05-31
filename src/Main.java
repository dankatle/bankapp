import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HashSet<BankAccount> list = new HashSet<>();
        list.add(new BankAccount("Алексей", "2828", 1000));
        list.add(new BankAccount("Максим", "1234", 1000));
        list.add(new BankAccount("Мария", "1234", 1000));
        list.add(new BankAccount("Ирина", "2332", 10000));
        App app = new App();
        app.startApp(list);
    }
}
