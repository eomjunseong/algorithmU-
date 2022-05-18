package practice;

class Box<T>{
    private T ob;
    Box(T o){
        ob = o;
    }
    public void set(T o){
        ob = o;
    }
    public T get(){
        return ob;
    }
}
class Toy{
    private String name ;
    Toy(String s){
        name =s  ;
    }

    @Override
    public String toString() {
        return name;
    }
}
class MoveBox{
    static void moveElement(Box<? extends Toy> from, Box<? super Toy> to){
        to.set(from.get());
    }
}
public class WildCardTest {
    public static void main(String[] args) {
        Box<Toy> from = new Box<>(new Toy("toy2"));
        Box<Toy> to = new Box<>(new Toy("hi"));
        MoveBox.moveElement(from,to);
        System.out.println(from.get());
        System.out.println(to.get());
    }
}
