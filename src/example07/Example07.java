package example07; //good

import java.util.Scanner;

public class Example07 {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("[안내]피보나치 수열 프로그램 시작.");
        System.out.print("원하는 수열의 개수를 입력해 주세요 : ");
        int num = sc.nextInt();
        arr = new int[num+1];
        System.out.println("[안내]피보나치 수열 프로그램 시작.");
        fib(num);
        for(int i =1;i<=num;i++){
            System.out.println(arr[i]);
        }
        System.out.println("[안내]피보나치 수열 프로그램 종료.");
    }
    static int fib(int num){
        if(num<=1) return arr[num]= num;
        return arr[num] = fib(num-1)+fib(num-2);
    }
}
