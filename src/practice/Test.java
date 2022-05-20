package practice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
class ToyInfo{
    String model;
    int price;
    ToyInfo(String a, int b){
        model = a;
        price =b;
    }
    int getPrice(){
        return price;
    }
}
class OptionalBase {
    public static void main(String[] args) {
        List<ToyInfo> ls = new ArrayList<>();
        ls.add(new ToyInfo("a1",10));
        ls.add(new ToyInfo("a2",5));
        ls.add(new ToyInfo("a3",10));
        ls.add(new ToyInfo("a4",11));

        int sum =ls.stream().filter(p->p.getPrice()<11)
                .mapToInt(t->t.getPrice()).sum();
        System.out.println(sum);

    }
}