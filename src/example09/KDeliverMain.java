package example09;

import java.util.*;

public class KDeliverMain {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();
        kiosk.start();

    }
}

class Kiosk{
    Scanner scan = new Scanner(System.in);

    Set<Order> orderList = new HashSet<>(); // 주문 리스트
    Set<Shop> shopList = new HashSet<>(); // 가게리스트
    List<Feedback> feedbackList = new ArrayList<>(); // 단순 조회 용 -> list 로 저장

    void start(){
        while(true){
            //메뉴 선택
            String selectMenu = selectMenu();

            switch (selectMenu){
                case "1": //가게 등록
                    addStore();
                    break;
                case "2"://후기 보기
                    checkFeedback();
                    break;
                case "3"://음식 주문
                    makeOrder();
                    break;
                case "4": //후기 등록
                    makeFeedback();
                    break;
                case "5": //가게별 메뉴 보기
                    showMenu();
                    break;
                case "6": //종료
                    System.out.println("[안내] 이용해주셔서 감사합니다.");
                    break;

            }
            if(selectMenu.equals("6")) break;
        }
    }

    //메뉴선택
    String selectMenu(){
        String selectMenu;
        do{
            System.out.println("[치킨의 민족 프로그램 V1] \n" +
                    "-------------------------\n" +
                    "1) [사장님용] 음식점 등록하기\n" +
                    "2) [고객님과 사장님용] 음식점 별점 조회하기\n" +
                    "3) [고객님용] 음식 주문하기\n" +
                    "4) [고객님용] 별점 등록하기\n" +
                    "5) [고객님과 사장님용] 메뉴 조회\n" +
                    "6) 프로그램 종료하기\n" +
                    "-------------------------");
            selectMenu= scan.nextLine();
            if(selectMenu.equals("1")||selectMenu.equals("2")||selectMenu.equals("3")||selectMenu.equals("4")||selectMenu.equals("5")){
                break;
            }
            else{
                System.out.println("정확한 메뉴 번호를 입력해주세요.");
            }
        }while(true);
        return selectMenu;
    }

    //"1" 가게추가
    void addStore(){
        String shopName;
        String foodName;
        String price;
        System.out.println("[안내] 반갑습니다. 가맹주님!");
        System.out.println("[안내] 음식점 상호는 무엇인가요?");
        shopName=scan.nextLine();
        System.out.println("[안내] 메뉴 이름은 무엇인가요?");
        foodName=scan.nextLine();
        System.out.println("[안내] 해당 메뉴 가격은 얼마인가요?");
        price=scan.nextLine();
        Shop shop = new Shop(shopName,foodName,price);

        if(!shopList.contains(shop)){
            if(checkNum(price)){
                shopList.add(shop);
                System.out.println("등록이 완료 되었습니다.");
            }
            else{
                System.out.println("가격정보를 확인해주세요");
            }
        }
        else{
            System.out.println("이미 존재하는 매장입니다. 입력 정보를 확인해주세요.");
        }
    }

    //"2"
    void checkFeedback(){
        for(int i = 0 ; i< feedbackList.size();i++){
            Feedback fb =feedbackList.get(i);
            System.out.printf("%s [고객님]\n",fb.getCustomerName());
            System.out.println("-------------------------");
            System.out.printf("주문 매장 : %s\n",fb.getShopName());
            System.out.printf("주문 메뉴 : %s\n",fb.getFoodName());
            System.out.printf("별점 : %s\n\n",makeStar(fb.getGrade()));
        }
    }

    //"3" 주문
    void makeOrder(){
        String name;
        String shopName;
        String foodName;
        System.out.println("[안내] 고객님! 메뉴 주문을 진행하겠습니다!");
        System.out.println("[안내] 주문자 이름을 알려주세요!");
        name = scan.nextLine();
        System.out.println("[안내] 상호명을 알려주세요!");
        shopName=scan.nextLine();
        System.out.println("[안내] 주문할 메뉴 이름을 알려주세요!");
        foodName=scan.nextLine();
        Order order= new Order(shopName, foodName,name);

        if(shopList.contains(new Shop(shopName,foodName,""))){ //샵이 있으면
            System.out.println("주문이 완료되었습니다.");
            orderList.add(order);
        }else{
            System.out.println("정화한 상호명과, 메뉴를 입력해주세요");
        }
    }

    //"4" 후기 작성
    void makeFeedback(){
        String name;
        String shopName;
        String foodName;
        String star;
        System.out.println("[안내] 주문자 이름은 무엇인가요?");
        name=scan.nextLine();
        System.out.println("[안내] 음식점 상호는 무엇인가요?");
        shopName= scan.nextLine();
        System.out.println("[안내] 주문하신 음식 이름은 무엇인가요?");
        foodName = scan.nextLine();

        if(orderList.contains(new Order(shopName,foodName,name))){ //주문 목록에 있으면
            System.out.println("[안내] 음식맛은 어떠셨나요? (1점 ~ 5점)");
            star = scan.nextLine();
            if(checkNum(star)){
                if(Integer.valueOf(star)<=5&&Integer.valueOf(star)>=1){
                    feedbackList.add(new Feedback(shopName,name,foodName,Integer.valueOf(star))); //후기등록
                    System.out.println("후기가 등록되었습니다.");
                }
                else{
                    System.out.println("별점은 1~5만 입력 가능합니다.");
                }
            }
            else{
                System.out.println("별점은 1~5만 입력 가능합니다.");
            }
        }
        else{
            System.out.println("주문이 조회되지 않습니다.");

        }

    }

    //"5" 메뉴 보기
    void showMenu(){ //Set임
        int idx = 1 ;
        for(Shop shop : shopList){
            System.out.println("--("+idx+ ")------------------");
            System.out.println("상호명 : "+shop.getShopName());
            System.out.println("메뉴명 : "+shop.getFoodName());
            System.out.println("가격 : "+shop.getPrice());
            System.out.println("^^^^\n\n");
            idx++;
        }

    }

    boolean checkNum(String str){
        if(str.length()==0) return false;
        for(int i = 0 ; i<str.length();i++){
            if(!Character.isDigit(str.charAt(i))){ //price가 숫자가아닐떄
                return false;
            }
        }
        return true;
    }
    String makeStar(int c){
        String star ="";
        for(int i = 1 ; i<=c;i++){
            star+="*";
        }
        return star;
    }
}

class Order {
    private String shopName;
    private String foodName;
    private String customerName;


    public Order(String shopName, String foodName,String customerName) {
        this.shopName = shopName;
        this.foodName = foodName;
        this.customerName = customerName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @Override
    public boolean equals(Object o) {
        Order order = (Order) o;
        return Objects.equals(shopName, order.shopName) && Objects.equals(customerName, order.customerName) && Objects.equals(foodName, order.foodName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(shopName, customerName, foodName);
    }
}

//굳이 상속해서 만듬... 굳이 안해도 되지만...
class Feedback extends Order{
    private int grade;

    public Feedback(String shopName, String customerName, String foodName, int grade) {
        super(shopName, customerName, foodName);
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

}

class Shop{
    private String shopName;
    private String foodName;
    private String price;

    public Shop(String shopName, String foodName, String price) {
        this.shopName = shopName;
        this.foodName = foodName;
        this.price = price;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String fooodName) {
        this.foodName = fooodName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        Shop shop = (Shop) o;
        if(this.shopName.equals(((Shop) o).shopName)&&this.foodName.equals(((Shop) o).foodName))return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopName, foodName);
    }
}