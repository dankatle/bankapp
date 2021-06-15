import java.util.HashSet;
import java.util.Scanner;

public class App {
    private BankAccount user = null;
    private final Scanner scanner = new Scanner(System.in);

    public void startApp(HashSet<BankAccount> list) {
        auth(list);
        System.out.println("Добрый день, " + ". Какую услугу желаете произвести?");
        String command = null;

        do {
            System.out.println("B - узнать баланс, T - перевести деньги другому пользователю, P - пополнить баланс, X - выход из банка");
            command = scanner.next();
            switch (command) {
                case "B" -> infoBalance(user);
                case "T" -> transferMoney(list);
                case "P" -> addMoney(user);
            }
        } while (!command.equals("X"));
    }

    public void auth(HashSet<BankAccount> list) {
        System.out.println("Привет! Это ваш банк! Для начала работы выполните вход.");
        System.out.println("Ваше имя: ");
        checkName(list);
        System.out.println("Ваш пароль: ");
        checkPassword(user);
        System.out.println("Поздравляю, вы вошли в систему!");
    }

    private void checkName(HashSet<BankAccount> list) {
        String tryName = scanner.nextLine();
        for (BankAccount checkUser : list) {
            if (checkUser.getHolder().equals(tryName)) {
                System.out.println("Ваше имя найдено в нашей базе.");
                user = checkUser;
                break;
            }
        }

        if (user == null) {
            System.out.println("Ваше имя не найдено в базе");
        }
    }

    private void checkPassword(BankAccount bankAccount) {
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

    private void transferMoney(HashSet<BankAccount> list) {
        System.out.println("Напишите через пробел имя владельца счета и сумму перевода");
        String sum = scanner.nextLine();
        String[] mathExpression = sum.split(" ");
        String nameHolder = null;
        int amount = 0;

        try {
            nameHolder = mathExpression[0];
            amount = Integer.parseInt(mathExpression[1]);
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат ввода");
            System.out.println("Следуйте инструкциям.");
            return;
        }

        for (BankAccount checkUser : list) {
            if (checkUser.getHolder().equals(nameHolder)) {
                if (amount > 0) {
                    user.setBalance(user.getBalance() - amount);
                    System.out.println("Вы успешно перевели");
                    break;
                } else if (user.getBalance() <= 0) {
                    System.out.println("Для перевода у вас не достаточно средств. Ваш баланс " + user.getBalance());
                    break;
                } else {
                    System.out.println("Введите положительное число");
                    break;
                }
            } else {
                System.out.println("Имя владельца не найдено.");
                break;
            }
        }
    }

    private void addMoney(BankAccount bankAccount) {
        System.out.println("Введите сумму пополнения");
        double addMoneys = scanner.nextDouble();
        if (addMoneys > 0) {
            bankAccount.setBalance(addMoneys);
            System.out.println("Успешно!");
        } else {
            System.out.println("Безуспешно");
        }
    }
}

