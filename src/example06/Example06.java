package example06;

import java.util.Scanner;

public class Example06 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int selectMenu,count;
        Menu[] menuArray = new Menu[5];

        menuArray[1]= new Menu("김밥",1000);
        menuArray[2]= new Menu("계란 김밥",1500);
        menuArray[3]= new Menu("충무 김밥",1000);
        menuArray[4]= new Menu("떡볶이",2000);

        System.out.println("[안내]안녕하세요. 김밥천국에 오신 것을 환영합니다.");
        System.out.println("------------------------------");
        System.out.println("[안내]원하시는 메뉴의 번호를 입력하여 주세요.");

        do{
            for(int i = 1; i<=4;i++){
                System.out.print(i+") "+menuArray[i].getName()+"("+menuArray[i].getPrice()+")  ");
            }
            System.out.println();
            selectMenu  = sc.nextInt();
            if(selectMenu<=0||selectMenu>=5){
                System.out.println("[안내]메뉴에 포함된 번호를 입력하여 주세요.");
            }
            else break;
        }while(true);
        do{
            System.out.println("[안내]선택하신 메뉴의 수량을 입력하여 주세요.");
            System.out.println("(※ 최대 주문 가능 수량 : 99)");
            count=sc.nextInt();
            if(count<=0||count>=100){
                System.out.printf("[경고]%d개는 입력하실 수 없습니다.\n",count);
                System.out.println("[경고]수량 선택 화면으로 돌아갑니다.");
            }
            else break;
        }while(true);

        int totalPrice = menuArray[selectMenu].getPrice()*count;
        System.out.printf("[안내]주문하신 메뉴의 총 금액은%d원 입니다.\n",totalPrice);
        System.out.println("[안내]이용해 주셔서 감사합니다.");
    }
}
class Menu{
    String name;
    int price;
    Menu(String name ,int price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}