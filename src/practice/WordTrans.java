import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;

public class WordTrans {
    public static void main(String[] args) {


        HashMap<String, String> id_pw_list = new HashMap<String,String>();
        id_pw_list.put("admin", "0000");
        HashMap<String, String> ban_list = new HashMap<String, String>();
        ban_list.put("킹", "열");
        ban_list.put("시발", "사랑");
        ban_list.put("꺼저", "용기");
        ban_list.put("미친", "희망");

        Scanner scanner = new Scanner(System.in);
        System.out.print("[시스템] 유튜브 계정의 아이디를 입력하세요 {Ex - admin} : ");
        String id = scanner.nextLine();
        System.out.print("[시스템] 유튜브 계정의 비밀번호를 입력하세요{Ex - 0000} :");
        String pw = scanner.nextLine();
        System.out.println();

        System.out.println(id_pw_list.containsKey(id));
        System.out.println(id_pw_list.get(id));


        //ID가 없을때
        if(id_pw_list.get(id)==null ||(id_pw_list.get(id).compareTo(pw)!=0) ){
            System.out.println("[경고] 유튜브 계정의 아이디 및 비밀번호를 다시 확인해 주세요.");
        }
        else {

            System.out.printf("[안내] 안녕하세요 %s님.%n", id);
            System.out.println("[안내] 유튜브 영상의 자막을 생성해 주세요.");
            System.out.println("=".repeat(20));
            String sentence = scanner.nextLine();
            System.out.println("=".repeat(20));
            System.out.println("[알림] 프로그램의 금칙어 리스트입니다.");
            System.out.println(ban_list.keySet());
            System.out.println("=".repeat(20));
            System.out.println("[알림] 자막 순화 프로그램 결과입니다.");


            for(String i : ban_list.keySet()) {
                sentence = sentence.replace(i,ban_list.get(i));
            }
            System.out.printf(">>> %s%n",sentence);
            System.out.println("[안내] 프로그램을 종료합니다.");




        }
    }
}
