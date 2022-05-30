package example11;

import java.util.Scanner;

public class Bankprogram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input ;

        //v1
        BankAccount bankAccount1 = new BankAccount("0000-0000", 500_000);
        System.out.print("[기능] 계좌에 입금할 금액을 입력해 주세요 : ");
        input = scan.nextInt(); //입금할 금액 입력
        bankAccount1.deposit(input);

        System.out.print("[기능] 계좌에 출금할 금액을 입력해 주세요 : ");
        input = scan.nextInt(); //출금할 금액 입력
        bankAccount1.withdraw(input); //츌굼
        bankAccount1.getBalance();//잔고 확인

        //V2 -- 만기시, 출금가능
        SaveBankAccount bankAccount2 = new SaveBankAccount("1234-1234",700_000);
        bankAccount2.getBalance();

        bankAccount2.deposit(10000); //안됨
        bankAccount2.withdraw(100000);//안됨
        //
        bankAccount2.expire(); //만기
        bankAccount2.withdraw(500000);//출금가능
        bankAccount2.getBalance(); // 조회







    }
}
