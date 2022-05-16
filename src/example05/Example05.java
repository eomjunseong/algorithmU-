package example05;

import java.util.Scanner;

public class Example05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        int power,defense,hp;

        System.out.println("[안내] TRPG 스타크래프트 시작합니다.");
        System.out.println("[안내] 자신의 유닛 정보를 입력해 주세요.");

        System.out.print("[시스템] 유닛 [이름] 을 입력해 주세요 :");
        name = sc.nextLine();
        System.out.print("[시스템] 유닛 [공격력] 을 입력해 주세요 : (Ex 50)");
        power = sc.nextInt();
        System.out.print("[시스템] 유닛 [방어력] 을 입력해 주세요 : (Ex 1)");
        defense = sc.nextInt();
        System.out.print("[시스템] 유닛 [체력] 을 입력해 주세요 : (Ex 100)");
        hp = sc.nextInt();

        Unit myUnit = new Unit(name,power,hp,defense);

        System.out.println();
        System.out.println("[안내] 생성된 유닛 정보는 다음과 같습니다.");
        System.out.printf("[안내] %s 유닛이 게임에 참여하였습니다.",myUnit.getName());
        System.out.println("[공격력] : "+myUnit.getPower());
        System.out.println("[방어력] : "+myUnit.getDefense());
        System.out.println("[체력] : "+myUnit.getHp());


        System.out.println("========================================");

        sc.nextLine(); //버퍼 엔터 제거

        System.out.println("[안내] 상대 유닛 정보를 입력해 주세요.");
        System.out.print("[시스템] 유닛 [이름] 을 입력해 주세요 :");
        name = sc.nextLine();
        System.out.print("[시스템] 유닛 [공격력] 을 입력해 주세요 : (Ex 50)");
        power = sc.nextInt();
        System.out.print("[시스템] 유닛 [방어력] 을 입력해 주세요 : (Ex 1)");
        defense = sc.nextInt();
        System.out.print("[시스템] 유닛 [체력] 을 입력해 주세요 : (Ex 100)");
        hp = sc.nextInt();
        Unit enemy = new Unit(name,power,hp,defense);

        System.out.println();
        System.out.println("[안내] 생성된 유닛 정보는 다음과 같습니다.");
        System.out.printf("[안내] %s 유닛이 게임에 참여하였습니다.",enemy.getName());
        System.out.println("[공격력] : "+enemy.getPower());
        System.out.println("[방어력] : "+enemy.getDefense());
        System.out.println("[체력] : "+enemy.getHp());
        System.out.println("========================================");
        System.out.println("----------------------------------------");

        int flag = -1 ;
        while(true){
            if(myUnit.attack(enemy)){
                System.out.println(enemy);
            }
            else{
                flag = 0 ;//상대 패배
                break;
            }
            if(enemy.attack(myUnit)){
                System.out.println(myUnit);
            }
            else break;//내가 패배
        }
        System.out.println("[안내] 더 이상 공격할 수 없습니다.");
        if(flag==0){
            System.out.println("[안내] 상대 유닛(적)이 제거되었습니다. 승리하였습니다");
        }
        else System.out.println("[안내] 내 유닛이 제거되었습니다. 패배하였습니다.");




    }
}
class Unit{
    private String name;
    private int power;
    private int hp;
    private int defense;

    Unit(String name, int power, int hp , int defese){
        this.name = name;
        this.power = power;
        this.hp=hp;
        this.defense = defese;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
    public boolean attack(Unit enemy){ // 상대방 체력은 = 상대방 체력 + 상대방 방어력 - 내공격력
        System.out.printf("[안내] [%s]유닛이 [공격] 하였습니다.",this.name);
        enemy.hp = enemy.hp+enemy.defense-this.power;
        if(enemy.hp<=0){
            System.out.println("[안내] 상대 유닛의 남은 [체력]은 0 입니다.");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[안내] ["+this.name+"] 남은 [체력]은 "+this.hp +" 입니다.";
    }
}
