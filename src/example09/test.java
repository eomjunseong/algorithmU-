package example09;

import java.util.HashSet;
import java.util.Set;

public class test {
    public static void main(String[] args) {
        Shop shop1 =new Shop("a","aa","1");
        Shop shop2 =new Shop("a","aa","12");
        Set<Shop> set = new HashSet<>();
        System.out.println(shop1.equals(shop2));
        set.add(shop1);
        System.out.println(set.contains(shop2));

    }
}
