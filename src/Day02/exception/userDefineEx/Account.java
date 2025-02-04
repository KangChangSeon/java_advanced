package Day02.exception.userDefineEx;

public class Account {

    private long balance; // 계좌 잔고 저장멤버

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Account() {}
    public Account(long balance) {
        this.balance = balance;
    }

    public void deposit(int money) {
        this.balance += money; // 은행 예금
    }

    public void withdraw(int money) throws InsufficientEx { // 호출한 곳으로 예외 떠넘김
        if(this.balance < money){
            throw new InsufficientEx("잔고 부족으로 출금이 안됩니다. " + (money - this.balance) + " 부족합니다.");
        }
        this.balance -= money;
    }
}
