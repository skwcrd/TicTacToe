package Play.ComMODE;
import Play.Player;

public class Medium {

    public Medium(Player person) {
        int pos;
        pos = ((int) (Math.round(Math.random() * 10))) % 2;
        switch (pos) {
            case 0 : new Easy(person);
                break;

            case 1 : new Hard(person);
                break;

                default: new Medium(person);
        }
    }

}
