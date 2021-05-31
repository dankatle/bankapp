import java.util.Objects;

public class BankAccount {
    private final String holder;
    private final String password;
    private double balance;

    public BankAccount(String holder, String password, double balance) {
        this.holder = holder;
        this.password = password;
        this.balance = balance;
    }

    public String getHolder() {
        return holder;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;

        BankAccount that = (BankAccount) o;

        if (!Objects.equals(holder, that.holder)) return false;
        return Objects.equals(password, that.password);
    }
}
