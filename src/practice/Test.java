package practice;

import java.util.*;
class Person implements  Comparable<Person>{
    String name;
    int age;
    Person(String a, int b){
        name =a ; age = b;
    }
    @Override
    public int compareTo(Person o) {
        return this.age-o.age;
    }
    @Override
    public String toString() {
        return name + " " +age;
    }
}
class PersonCompartor implements  Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        return o2.age-o1.age;
    }
}

public class Test {
    public static void main(String[] args) {
        TreeSet<Person> t = new TreeSet<>();
        t.add(new Person("a1",33));
        t.add(new Person("a2",23));
        t.add(new Person("a3",53));


        Iterator<Person>itr = t.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next().toString());
        }
    }
}
