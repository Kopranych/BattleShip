package modul;

public class PointOnField {
    private int x;
    private int y;
    public String name;

    public PointOnField(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public PointOnField() {

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
