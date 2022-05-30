package example11;

public class SaveBankAccount extends BankAccount{

    boolean expire = false; //만기 여부
    public SaveBankAccount(String accountNumber, int balance) {
        super(accountNumber, balance);
    }
    @Override
    public void deposit(int num){
        System.out.println("입금불가능합니다.");
    }
    @Override
    public void withdraw(int num){
        if(expire==true){ //만기시
            super.withdraw(num);
        }else{
            System.out.println("출금 불가능합니다");
        }

    }
    
    public int getMatureAmount(){
        double res = balance*1.02;
        System.out.printf("[기능] 정기예금 만기 금액 : %.f",res );
        return (int)res;
    }
    public void expire(){ // 만기 시킴
        this.balance = (int)(this.balance*1.02);
        System.out.println("[기능] 만기되었습니다.");
        getBalance();
        this.expire = true;
    }

}
