package Play.ComMODE;
import Play.Check.CheckPattern;
import Play.Check.ChecktoWin;
import Play.Player;

public class VeryHard {

    public VeryHard(Player person) {
        int pos;
        ChecktoWin toWin = new ChecktoWin();
        CheckPattern pattern = new CheckPattern(person);
        pos = toWin.check(person,2);
        if(pos>0) {
            person.setData(person.p2,pos);
        }
        else {
            pos = toWin.check(person,1);
            if(pos>0) {
                person.setData(person.p2,pos);
            }
            else {
                pos = pattern.search();
                person.setData(person.p2, pos);
            }
        }
    }

}
