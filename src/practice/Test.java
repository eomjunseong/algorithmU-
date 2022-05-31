package practice;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.IntStream;

class ReportCard {
    private int kor;    // 국어 점수
    private int eng;    // 영어 점수
    private int math;    // 수학 점수

    public ReportCard(int k, int e, int m) {
        kor = k;
        eng = e;
        math = m;
    }
    public int getKor() { return kor; }
    public int getEng() { return eng; }
    public int getMath() { return math; }
}


class GradeAverage {
    public static void main(String[] args) {
        List<String> sl = Arrays.asList("Toy","Toy2","Toy2","Toy3");

        Stream<String[]> stream = sl.stream().map(s -> s.split(""));//Stream<String[]>
//        Stream<String> stringStream = stream.flatMap(s -> Arrays.stream(s));
        Stream<String> stringStream = stream.flatMap(s -> Stream.of(s));
        System.out.println(stringStream.count());



//        stringStream.forEach(s-> System.out.println(s));
    }
}