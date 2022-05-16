package example04;

import java.util.Arrays;
import java.util.Scanner;
//굿굿
public class CC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        final String ID = "admin";
        final String PW = "0000";
        String IDTemp ;
        String PWTemp ;

        String[] banStr = new String[]{"킹","시발","꺼저","미친"};
        String[] replaceStr = new String[]{"열","사랑","용기","희망"};

        //시작
        System.out.print("[시스템] 유튜브 계정의 아이디를 입력하세요 {Ex - admin} :");
        String loginID = scan.nextLine();
        System.out.print("[시스템] 유튜브 계정의 비밀번호를 입력하세요{Ex - 0000} :");
        String loginPW = scan.nextLine();
        System.out.println();

        //로그인 비교
        if(loginID.equals(ID)&&loginPW.equals(PW)){

            //자막 입력 받고 출력
            String cc ;

            //기타출력
            System.out.printf("[안내] 안녕하세요 "+loginID+ "님.");
            System.out.println("[안내] 유튜브 영상의 자막을 생성해 주세요.");
            cc =scan.nextLine();
            System.out.println("========================================\n" +
                    "[알림] 프로그램의 금칙어 리스트입니다.");
            System.out.print("[");
            int i;
            for(i=0 ; i <banStr.length-1;i++){
                System.out.print(banStr[i]+", ");
            }
            System.out.print(banStr[i]);
            System.out.println("]");
            System.out.print("========================================\n" +
                    "[알림] 자막 순화 프로그램 결과입니다.");

            //순환번역
            for(i=0; i<banStr.length;i++){
                cc=cc.replace(banStr[i],replaceStr[i]);
            }

            //결과 출력
            System.out.println();
            System.out.print(">>>"+cc);
        }
        else{
            System.out.println("[경고] 유튜브 계정의 아이디 및 비밀번호를 다시 확인해 주세요.");
            return ;
        }

    }

}
