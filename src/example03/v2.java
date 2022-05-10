package example03;

import java.util.Scanner;

public class v2 {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        System.out.printf("[인공지능 프로그램 V2]\n" +
                "==============================\n" +
                "[System] a 값을 입력하여 주세요 :");
        int a = scan.nextInt();
        System.out.print("[System] b 값을 입력하여 주세요 : ");
        int b = scan.nextInt();
        double[] arr = new double[]{580, 700, 810, 840};
        System.out.println("[안내] 입력된 '광고비'는 다음과 같습니다.");
        for(int i = 0 ; i<arr.length; i++){
            System.out.printf("%d 번째) %.1f   ",i+1,arr[i] );
        }
        System.out.println();
        for(int i = 0 ; i<arr.length; i++){
            System.out.printf("%d 번째 예측) %.1f회 방문\n",i+1,arr[i]*a+b );
        }

    }
}
