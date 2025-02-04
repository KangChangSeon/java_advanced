package Day02.exception.userDefineEx;

public class Main {
    public static void main(String[] args) {

        Account account = new Account();

        account.deposit(100000);
        System.out.println("현재 잔고는 " + account.getBalance() + " 원입니다.");

        //출금
        try {
            account.withdraw(300000);
        } catch (InsufficientEx e) {
            String message = e.getMessage();
            System.out.println(message);
        }
    }
}
