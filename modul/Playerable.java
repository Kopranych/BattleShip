package modul;

public interface Playerable {
    String shot = "X";
    String shotToShip = "*";
    String killShot = "+";
    int killed = 2;
    int wounded = 1;
    int miss = -1;
    int shot();
}
