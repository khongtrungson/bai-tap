package TH1;

public class TestPoint {
    public static void main(String[] args) {
        Point t = new Point();
        Point t1 = new Point(t);
        Point t2 = new Point(1,2,3);
        System.out.println(t2.getX()+" "+t2.getY()+" "+t2.getZ());
    }
}
