package example08;

import java.util.*;

public class MyStorageV3 {
    public static void main(String[] args) {
//        if(args.length!=0||args!=null){
//            System.out.println("조회되지 않는 회원입니다. 관리자 권한으로 로그인해 주세요.");
//            return;
//        }
//        else{
//            System.out.printf("[System] %s 점장님 어서오세요.\n",args[0]);
//            System.out.println("[System] 해당 프로그램의 기능입니다.");
//        }

        ERP erp = new ERP();
        erp.start(); //start


    }
}
class ERP {

    TreeMap<String,Integer> itemList = new TreeMap<>(); //이름은 리스트이나 맵으로 구현해벌임..
    Scanner scan = new Scanner(System.in);
    void start(){
        int menu=-1;
        do{
            menu = menuMacro();
            switch (menu){
                case 1://제품추가 1
                    prodInput();
                    break;
                case 2://제품삭제 2
                    prodRemove();
                    break;
                case 3://제품수량 추가 3
                    prodAmountAdd();
                    break;
                case 4://제품수량 감소 4
                    prodAmountDecrease();
                    break;
                case 5:
                    showItem();
                    break;
            }
        }while(menu!=6);
        System.out.println("프로그램을 종료합니다.");

    }
//메뉴선택
    int menuMacro(){
        int selectMenu;
        do{
            System.out.println("------------------------------");
            System.out.println(
                    "1. 물건 정보(제품명) 등록하기\n" +
                    "2. 물건 정보(제품명) 등록 취소하기\n" +
                    "3. 물건 넣기 (제품 입고)\n" +
                    "4. 물건 빼기 (제품 출고)\n" +
                    "5. 재고 조회\n" +
                    "6. 프로그램 종료");
            System.out.println("------------------------------");
            selectMenu=scan.nextInt();
            if(selectMenu<1||selectMenu>6){
                System.out.println("메뉴룰 확인 해주세요.");
            }
            else break;

        }while(true);
        scan.nextLine();// 버퍼비움
        return selectMenu;
    }
//제품추가 1
    void prodInput(){
        System.out.println("[System] 제품 등록을 원하는 제품명을 입력하세요 : ");
        String name =scan.nextLine();
        if(checkName(name)){
            System.out.println("이미 등록된 상품입니다.");
        }
        else{
            if(itemList.size()>4){//다섯개까지만 등록
                System.out.println("더 이상 제품을 등록할 수 없습니다.");
            }
            else itemList.put(name,0); // 추가
        }
        showItem();
    }
//제품삭제 2
    void prodRemove(){
        System.out.println("[System] 제품 등록 취소를 원하는 제품명을 입력하세요 : ");
        String name =scan.nextLine();
        if(checkName(name)){
            itemList.remove(name);
            System.out.println("[System] 제품 취소가 완료됬습니다.");
        }
        else{
            System.out.println("제품명을 확인해 주세요.");
        }
        showItem();
    }
//제품수량 추가 3
    void prodAmountAdd(){
        System.out.println("[System] 수량을 추가할 제품명을 입력하세요 : ");
        String name = scan.nextLine();
        System.out.println("추가할 수량을 입력해주세요 : ");
        int count = scan.nextInt();
        scan.nextLine();//버퍼비움
        if(checkName(name)&&checkNum(count)){
            System.out.println("추가 되었습니다.");
            itemList.put(name,itemList.get(name)+count);//추가
        }
        else{
            System.out.println("제품명 혹은 수량을 확인해 주세요.");
        }
        showItem();
    }
//제품수량 감소 4
    void prodAmountDecrease(){
        System.out.println("[System] 출고를 진행할 제품명을 입력하세요 : ");
        String name = scan.nextLine();
        System.out.println("원하는 출고량을 입력하세요 : ");
        int count = scan.nextInt();
        scan.nextLine();//버퍼비움
        if(checkName(name)&&checkNum(count)){
            int itemCount = itemList.get(name);
            if(itemCount-count<0){
                System.out.println("수량이 부족합니다. 수량을 확인해주세요.");
            }
            else{
                System.out.println("출고하였습니다.");
                itemList.put(name,itemList.get(name)-count);//감소
            }
        }
        else{
            System.out.println("제품명 혹은 수량을 확인해 주세요.");
        }
        showItem();
    }
//재고조회 5
    void showItem(){
        System.out.println("[System] 현재 등록된 제품 및 수량 ▼");
        int size=itemList.size();
        for(String key : itemList.keySet()){
            System.out.printf("%s : %d개\n",key,itemList.get(key));
        }
        for(int i =1;i<=5-size;i++){
            System.out.println("등록 가능 : 0개");
        }
    }
    void exit(){

    }
    boolean checkName(String name ) {
        return itemList.containsKey(name)?true:false;
    }
    boolean checkNum(int count){
        //상한 제한 안둠..
        if(count<0) return false;
        else return true;
    }
}
