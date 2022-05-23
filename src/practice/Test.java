package practice;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public List<String> mergeTwoStream(List<String> list1, List<String> list2) {
        Stream<String> s1 = list1.stream();
        Stream<String> s2 = list2.stream();
        return Stream.concat(s1,s2).collect(Collectors.toList());
    }
}