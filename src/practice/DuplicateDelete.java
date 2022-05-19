package practice;

import java.util.*;

public class DuplicateDelete {
    public static void main(String[] args) {
        List<String> lst = Arrays.asList("box","toy","box","toy");
        ArrayList<String> list = new ArrayList<>(lst);

        for(String s :list){
            System.out.print(s+ " ");
        }
        System.out.println();

        HashSet<String> set = new HashSet<>(list);
        list = new ArrayList<>(set);
        for(String s :list){
            System.out.print(s+ " ");
        }
        System.out.println();


    }
}
