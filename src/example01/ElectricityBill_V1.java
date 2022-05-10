package example01;

import java.util.Scanner;

public class ElectricityBill_V1 {
    public static void main(String[] args) {
        System.out.println("=========================");
        System.out.println("주택용 전기요금(저압) 계산기 ");
        System.out.println("=========================");

        Scanner scanner = new Scanner(System.in);
        double answer = scanner.nextDouble(); //입력 받고
        System.out.println(AddFunc(answer)); //계산 출력
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
        if(a>500) {
            return (100*60.7)+(100*125.9)+(100*187.9)+(100*280.6)+(100*417.7)+((a-500)*670.6);
        }else if(a>400){
            return (100*60.7)+(100*125.9)+(100*187.9)+(100*280.6)+((a-400)*417.7);
        }else if(a>300){
            return (100*60.7)+(100*125.9)+(100*187.9)+((a-300)*280.6);
        }else if(a>200){
            return (100*60.7)+(100*125.9)+((a-200)*187.9);
        }else if(a>100){
            return (100*60.7)+((a-100)*125.9);
        }else return a*60.7;
    }
}