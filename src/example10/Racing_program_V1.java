package example10;
import java.util.Scanner;


interface Racing{
    void start();
    void accelerate();
    void booster();
    void drift();
    void reverseDriving();
    void cashCar();
    void parking();
}

class Racing_MyCar implements Racing {
    private final String User_CarNumber;
    private int controls = 0; //컨트롤 횟수
    private int speed = 0;//주행거리
    private int distanceDriven = 0;//주행거리
    private int cashCarLv = 1;//캐쉬레벨
    Scanner scan = new Scanner(System.in);

    public Racing_MyCar(String User_CarNumber){
        this.User_CarNumber = User_CarNumber;
    }

    public int getCashCarLv() {
        return cashCarLv;
    }

    public void setCashCarLv(int cashCarLv) {
        this.cashCarLv = cashCarLv;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getControls() {
        return controls;
    }

    public void setControls(int controls) {
        this.controls = controls;
    }

    public int getDistanceDriven() {
        return distanceDriven;
    }

    public void setDistanceDriven(int distanceDriven) {
        this.distanceDriven = distanceDriven;
    }
    @Override
    public void start(){
        String num;
        System.out.printf("\n[안내] %s님. 카카오라이딩에 오신것을 진심으로 환영합니다.\n",
                User_CarNumber);
        while (true) {
            System.out.print("\n카카오라이딩 조작버튼을 누르세요. \n" +
                    "-------------------------\n" +
                    "1) [가속]\n" +
                    "2) [부스터 가속]\n" +
                    "3) [방향 회전]\n" +
                    "4) [후진]\n" +
                    "5) [캐쉬충전]\n" +
                    "6) [종료]\n" +
                    "-------------------------\n" +
                    ">>> ");
            num = scan.nextLine();
            switch (num) {
                case "1":
                    accelerate();
                    break;
                case "2":
                    booster();
                    break;
                case "3":
                    drift();
                    break;
                case "4":
                    reverseDriving();
                    break;
                case "5":
                    cashCar();
                    break;
                case "6":
                    parking();
                    break;
                default:
                    System.out.println("올바른 숫자를 입력해주세요");
                    break;
            }
            if (num.equals("6")) {
                break;
            }
        }
    }
    @Override
    public void accelerate(){
        setControls(getControls() + 1);
        setSpeed(getSpeed() + 10 * cashCarLv);
        setDistanceDriven(getDistanceDriven() + getSpeed());
        if (cashCarLv > 1) {

            System.out.printf("Lv%s [가속]----------------\n" +
                    "| * 컨트롤 횟수 : %s\n" +
                    "| * 현재 속도 : %skm/h\n" +
                    "| * 현재 주행 거리 : %skm\n" +
                    "-------------------------",cashCarLv, controls, speed, distanceDriven);

        } else {
            System.out.printf("[가속]--------------------\n" +
                    "| * 컨트롤 횟수 : %s\n" +
                    "| * 현재 속도 : %skm/h\n" +
                    "| * 현재 주행 거리 : %skm\n" +
                    "-------------------------", controls, speed, distanceDriven);
        }
    }
    @Override
    public void booster(){
        setControls(getControls() + 1);
        setSpeed(getSpeed() + 20 * cashCarLv);
        setDistanceDriven(getDistanceDriven() + getSpeed());
//        if (cashCarLv > 1) {
//            System.out.printf("Lv%s [부스터가속]------------\n" +
//                    "| * 컨트롤 횟수 : %s\n" +
//                    "| * 현재 속도 : %skm/h\n" +
//                    "| * 현재 주행 거리 : %skm\n" +
//                    "-------------------------",cashCarLv, controls, speed, distanceDriven);
//
//        } else {
//            System.out.printf("[부스터가속]----------------\n" +
//                    "| * 컨트롤 횟수 : %s\n" +
//                    "| * 현재 속도 : %skm/h\n" +
//                    "| * 현재 주행 거리 : %skm\n" +
//                    "-------------------------", controls, speed, distanceDriven);
//        }

        if (cashCarLv > 1) {
            System.out.printf("Lv%s [부스터가속]------------\n",cashCarLv);
        }
        else{
            System.out.printf("[부스터가속]----------------\n");
        }
        System.out.printf("[부스터가속]----------------\n" +
        "| * 컨트롤 횟수 : %s\n" +
        "| * 현재 속도 : %skm/h\n" +
        "| * 현재 주행 거리 : %skm\n" +
        "-------------------------", controls, speed, distanceDriven);

    }
    @Override
    public void drift() {
        setControls(getControls() + 1);
        setSpeed(5);
        setDistanceDriven(getDistanceDriven() + getSpeed());

        System.out.print("[방향 회전]----------------\n" +
                "| * 회전 방향 입력 [<] [>] : \n");
        String direction;
        direction = scan.nextLine();
        System.out.printf("| * [%s] 으로 회전합니다.\n" +
                "| * 컨트롤 횟수 : %s\n" +
                "| * 현재 속도 : %skm/h\n" +
                "| * 현재 주행 거리 : %skm\n" +
                "-------------------------",direction,controls,speed,distanceDriven);
    }
    @Override
    public void reverseDriving() {
        setControls(getControls() + 1);
        setSpeed(5);
        setDistanceDriven(getDistanceDriven() - getSpeed());
        System.out.printf("[후진]--------------------\n" +
                "| * 컨트롤 횟수 : %s\n" +
                "| * 현재 속도 : %skm/h\n" +
                "| * 현재 주행 거리 : %skm\n" +
                "-------------------------",controls,speed,distanceDriven);
    }

    @Override
    public void cashCar() {
        cashCarLv++;
        System.out.printf("[안내] (캐쉬충전)%s님. 차량 업그레이드를 진행하였습니다.\n",User_CarNumber);
    }
    @Override
    public void parking() {
        System.out.println("[주행을 종료합니다]");
        scan.close();
    }
}

public class Racing_program_V1 {
    public static void main(String[] args) {
        Racing_MyCar racing_myCar = new Racing_MyCar("소나타");
        racing_myCar.start();
//        Racing_program_V2.racing_myCar = racing_myCar;
        Racing_program_V2 r_v2 = new Racing_program_V2(racing_myCar);
        r_v2.asdfdf();
    }
}
class Racing_program_V2 {
     Racing_MyCar racing_myCar;
    Racing_program_V2(Racing_MyCar r) {
        this.racing_myCar = r;
    }
    void asdfdf() {
        racing_myCar.start();
    }

}

@FunctionalInterface
interface  control{
    void add();

}