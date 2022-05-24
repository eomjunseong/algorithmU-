package example10;

import java.util.Scanner;

public class Racing_program_V1 implements  Racing{

    String name ;
    Scanner scan = new Scanner(System.in);
    int count = 1;
    int distane = 0 ;
    Racing_program_V1(String name){
        this.name=name;
    }

    //기본 속도 10
    //부스터 20
    //좌우 5
    //후진 1
    //액션 마다, 누적된 주행 거리 노출
    //속도 * 시간(애션당 1초) = 이동거리

    @Override//시작
    public void start() {
        System.out.printf("[안내] %s님. 카카오라이딩에 오신것을 진심으로 환영합니다.\n",name);
    }

    @Override
    public void accelerate() {
        System.out.println("[가속]------------------------------");
        System.out.printf("| * 컨트롤 횟수 : %d\n",count++);
        distane = distane+1*10;
        System.out.printf("| * 주행 거리 : %dkm/h\n",distane);
        System.out.println("------------------------------------\n");
    }

    @Override
    public void drift() {
        System.out.println("------------------------------------");
        System.out.print("| * 회전 방향 입력 [<] [>](입력 오류시 우회전 합니다) : ");
        String direction = scan.nextLine(); //< >
        if(direction.equals("<")) System.out.println("| * [왼쪽] 으로 회전합니다.");
        else System.out.println("| * [오르쪽] 으로 회전합니다.");
        distane = distane+1*5;
        System.out.printf("| * 컨트롤 횟수 : %d\n",count++);
        System.out.printf("* 드리프트 주행 거리 : %d\n",distane);
        System.out.println("------------------------------------\n");
    }

    @Override
    public void booster() {
        System.out.println("[부스터 가속 2 단계 ]-------------------");
        System.out.printf("| * 컨트롤 횟수 : %d\n",count++);
        distane = distane+1*20;
        System.out.printf("| * 주행 거리 : %dkm/h\n",distane);
        System.out.println("------------------------------------\n");
    }

    @Override
    public void back() {
        System.out.println("[후진]-------------------------------");
        System.out.printf("| * 컨트롤 횟수 : %d\n",count++);
        distane = distane+1*1;
        System.out.printf("| *후진 주행 거리 : %dkm/h\n",distane);
    }

    public static void main(String[] args) {
        int distance= 0 ;

        Racing_program_V1 myCar = new Racing_program_V1("엄준승");
        System.out.println("//기본 속도 10\n" +
                "//부스터 20\n" +
                "//좌우 5\n" +
                "//후진 1\n" +
                "//액션 마다, 누적된 주행 거리 노출\n" +
                "//속도 * 시간(애션당 1초) = 이동거리");
        //시작
        myCar.start();
        //가속
        myCar.accelerate();
        //배속
        myCar.booster();
        //회전
        myCar.drift();
        //후진
        myCar.back();

    }
}
