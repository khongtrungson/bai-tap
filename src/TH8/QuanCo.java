package TH8;

public class QuanCo {
    private int x,y;

    public QuanCo(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean canMoveTo(int x, int y) {
        return false;
    }
    public void moveTo(int x, int y) {
        // nếu tồn tại quân cờ tại (x,y) thì ăn quân cờ đó

    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
