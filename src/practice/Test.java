package practice;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.function.Predicate;

class RemoveIfDemo {
    public static void main(String[] args) {
        List<Integer> ls1 = Arrays.asList(1, -2, 3, -4, 5);
        ls1 = new ArrayList<>(ls1);

        List<Double> ls2 = Arrays.asList(-1.1, 2.2, 3.3, -4.4, 5.5);
        ls2 = new ArrayList<>(ls2);


        ls2.removeIf(s->s.doubleValue()<0.0);
        System.out.println(ls2);

    }
}