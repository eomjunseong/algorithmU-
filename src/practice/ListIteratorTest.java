package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("toy","box","robot","box");
        list = new ArrayList<>(list);
        ListIterator<String> itr = list.listIterator();
        String str;

        while(itr.hasNext()){
            str = itr.next();
            System.out.print(str+" ");
            if(str.equals("box")){
                itr.add("box2");
            }
            System.out.println("\nsize "+ list.size());
        }
//        System.out.println();
//        while(itr.hasPrevious()){
//            str = itr.previous();
//            System.out.print(str+" ");
//            if(str.equals("robot")){
//                itr.add("robot2");
//            }
//        }
//        System.out.println();
//        while(itr.hasNext()){
//            System.out.print(itr.next() + " ");
//        }
    }
}

////결과값
//toy box robot box
//box robot robot2 box toy2 toy
//toy toy2 box robot2 robot box

//여기서 왜,,,,, 첫번째 출력에 toy2는 출력되지 않는가,,,,,, next()-> add() 하면  뒤에 삽입되는건데 그건 왜 스킵하는가,,,?
//두번째 출력을 보면 Previous()때는 생각하는대로 작동한다,,, previous() ->add하면 앞에 삽입되는거니까,,,,
//왜일까,,,, 내부에서 어떤 방식으로 동작하는지 ㅇ_ㅇ...