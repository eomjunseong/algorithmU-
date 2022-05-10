package example03;

public class v3 {
    public static void main(String[] args) {
        double[][] arr = new double[][] {{374,385,375,401}, {1161,1401,1621,1681}};
        System.out.printf("[인공지능 프로그램 V3]\n" +
                "==============================\n" +
                "[안내] 인공지능 프로그램에 할당된 데이터\n");
        System.out.println();
        System.out.println();
        for(int i = 0 ; i<arr[0].length;i++){
            System.out.printf("%d번 째 데이터) [실제값] 웹 페이지 방문자 수 : %.1f\t[인공지능 예측값] 웹 페이지 방문자 수 : %.1f\n",i+1,arr[0][i],arr[1][i]);
        }
        double sum = 0 ;
        double temp ;
        double temp2 ;
        for(int i = 0 ; i<arr[0].length;i++){
            temp = arr[0][i]-arr[1][i];
            temp2 = temp*temp;
            sum+=temp2;
            System.out.printf("[%d 번째 데이터] 실제 값과 예측값의 오차 : %.1f\n[안내] 오차의 제곱 : %.1f\n\n",i+1,temp,temp2);
        }
        System.out.printf("==============================\n" +
                "[안내] 인공지능 프로그램의 성능(오차의 제곱 합) : %.1f",sum);
    }
}
