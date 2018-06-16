package Play.Check;
import Play.Player;

public class CheckResult {

    public int result(Player person,int n) { //check competition result
        new CheckPoint(person,n);
        int stop = 0;
        if (person.getResult(1) >= 1)
            stop = 1;
        else if (person.getResult(2) >= 1)
            stop = 1;
        return stop;
    }

}
