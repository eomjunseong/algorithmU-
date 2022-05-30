package example11;

public class BankAccount {
    protected String accountNumber;
    protected int balance;

    public BankAccount(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        System.out.printf("[안내] %s 계좌가 생성되었습니다. 잔고 ( 0 원)\n",accountNumber);
        System.out.printf("[안내] %s 계좌 생성을 위해 %d 원 입금되었습니다.\n",accountNumber,balance);
    }
    public void deposit(int num){
        balance+=num;
        System.out.printf("[기능] 계좌 입금 : %d 원\n",num);
    }
    public void withdraw(int num){
        balance-=num;
        System.out.printf("[기능] 계좌 출금 : %d 원\n",num);
    }

    public int getBalance() {
        System.out.printf("[기능] 계좌 잔고 호출 : %d원\n",balance);
        return balance;
    }

}
