package practice;

public class Main {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(1,1,5,5);
        Rectangle c ;


        try{
            c = (Rectangle)r.clone();
//            System.out.println(r.get());
//            System.out.println(c.get());
            c.change(2,2,4,4);
            r.show();
            System.out.println("_----------_");
            c.show();
        }catch (CloneNotSupportedException e){
            e.getMessage();
        }

    }
}
class Point implements Cloneable{
    private int x;
    private int y;
    Point(int x,int y){
        this.x= x;
        this.y=y;
    }
    void show(){
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
    void change(int x,int y){
        this.x= x;
        this.y=y;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Rectangle implements Cloneable{
    private Point up;
    private Point down;
    Rectangle(int x1,int y1, int x2, int y2){
        up = new Point(x1,y1);
        down = new Point(x2,y2);
    }
    void change(int x1,int y1, int x2, int y2){
        up.change(x1,y1);
        down.change(x2,y2);
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        Rectangle cp =  (Rectangle)super.clone();
        cp.up = (Point)up.clone();
        cp.down = (Point)down.clone();

        return cp;
    }
    public void show(){
        System.out.println("up.show() = ");
        up.show();
        System.out.println("down.show() = ");
        down.show();

    }
    public Point get(){
        return up;
    }
}

