package example01;

import java.util.Scanner;

public class ElectricityBill_V1 {
    public static void main(String[] args) {
        System.out.println("=========================");
        System.out.println("주택용 전기요금(저압) 계산기 ");
        System.out.println("=========================");

        Scanner scanner = new Scanner(System.in);
        double answer = scanner.nextDouble();
        System.out.println(AddFunc(answer));
    }
    public static double AddFunc(double a){
//            저압의 경우
//            100kWh 이하는 kWh당 60.7원,
//            100kWh 초과는 125.9원,
//            200kWh 초과는 187.9원,
//            300kWh 초과는 280.6원,
//            400kWh 초과는 417.7원,
//            500kWh초과는 670.6원의
//            전력량 요금을 내야한다.
        double sum = 0 ; // 초기값
        double target = a;
        if(target<=100){
            sum=target*60.7;
            return sum;
        }else{
           sum+=100*60.7;
        }
        target-=100;

        if(target<=100){
            sum=target*60.7;
            return sum;
        }else{
            sum+=100*60.7;
        }
        return sum;
    }
}