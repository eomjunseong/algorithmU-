package example02;

import java.util.Scanner;

public class Gugu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("[안내]희망하는 구구단을 숫자로 입력해 주세요 (2 ~ 9) :");
        int targetNum=scan.nextInt();
        if(targetNum>9||targetNum<=1){
            System.out.printf("%d 단 이 입력되었습니다.\n",targetNum);
            System.out.print("[경고]구구단은 2단 ~ 9단 까지만 선택할 수 있습니다.\n로그램을 종료합니다.");
            return;
        }
        for(int i = 1 ;i<=9;i++){
            System.out.printf("%d * %d = %d\n",targetNum,i,targetNum*i);
        }
    }
}
