import java.util.Random;

/**
 * Created by kopra on 16.06.2017.
 */
public class PlayerComp {
    private String name;
    private Field compField;
    private Ship[] shipsPlayer;

    public void setCompField(Field compField) {
        this.compField = compField;
    }

    public void setShipS(Ship[] ship) {
        this.shipsPlayer = ship;
    }

}
