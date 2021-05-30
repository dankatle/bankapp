import java.util.Scanner;

public class App {
    BankAccount bankAccount;

    public void startApp(BankAccount bankAccount) {
        Scanner scanner = new Scanner(System.in);
        auth(bankAccount);
        System.out.println("Добрый день, " + bankAccount.getHolder() + ". Какую услугу желаете произвести?");
        System.out.println("B - узнать баланс, T - перевести деньги другому пользователю, P - пополнить баланс, X - выход из банка");
        String command = scanner.next();

        switch (command) {
            case "B":
                infoBalance(bankAccount);
            case "T":
                break;
            case "P":
                addMoney(bankAccount);
            case "X":
                exitApp();
                break;
        }
    }

    public void auth(BankAccount bankAccount) {
        System.out.println("Привет! Это ваш банк! Для начала работы выполните вход.");
        System.out.println("Ваше имя: ");
        checkName(bankAccount);
        System.out.println("Ваш пароль: ");
        checkPassword(bankAccount);
        System.out.println("Поздравляю, вы вошли в систему!");
    }

    private void checkName(BankAccount bankAccount) {
        Scanner scanner = new Scanner(System.in);
        String tryName = scanner.nextLine();
        while (!bankAccount.getHolder().equalsIgnoreCase(tryName)) {
            System.out.println("Данное имя в нашей базе не найдено.");
            System.out.println("Введите еще раз");
            tryName = scanner.nextLine();
        }
        System.out.println("Ваше имя найдено в нашей базе.");
    }

    private void checkPassword(BankAccount bankAccount) {
        Scanner scanner = new Scanner(System.in);
        String tryPassword = scanner.nextLine();
        while (!bankAccount.getPassword().equals(tryPassword)) {
            System.out.println("Пароль неверный");
            System.out.println("Введите еще раз");
            tryPassword = scanner.nextLine();
        }
        System.out.println("Пароль верный!");
    }

    private void infoBalance(BankAccount bankAccount) {
        System.out.println("Ваш баланс: " + bankAccount.getBalance());
    }

    private void transferMoney(BankAccount bankAccount) {

    }

    private void addMoney(BankAccount bankAccount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму пополнения");
        double addMoneys = scanner.nextDouble();
        if (addMoneys > 0) {
            bankAccount.setBalance(addMoneys);
            System.out.println("Успешно!");
        } else {
            System.out.println("Безуспешно");
        }
    }

    private void exitApp() {
        System.exit(0);
    }
}
