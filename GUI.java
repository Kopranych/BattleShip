/**
 * Created by kopra on 29.06.2017.
 */
public class GUI {
    private Field fieldComp;
    private Field fieldPlayer;


    public void setFieldPlayer(Field fieldPlayer) {
        this.fieldPlayer = fieldPlayer;
    }

    public void setFieldComp(Field fieldComp) {
        this.fieldComp = fieldComp;
    }

    public void showField(Field field) {
        for (int i = 0; i < field.spaceGame.length; i++) {
            for (int j = 0; j < field.spaceGame.length; j++) {
                if (i == 10) {
                    System.out.print(field.spaceGame[i][j] + "  ");
                } else
                    System.out.print(" " + field.spaceGame[i][j] + " ");
            }
            System.out.println();
        }
    }
}
