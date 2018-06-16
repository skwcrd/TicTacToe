package Play.ComMODE;
import Play.Check.ChecktoWin;
import Play.Player;

public class Hard {

    public Hard(Player person) {
        int c=0,pos;
        ChecktoWin toWin = new ChecktoWin();
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
                while (c==0) {
                    pos = (((int) (Math.round(Math.random() * 10))) % 9) + 1;
                    for (int i=0;i<3 && c==0;i++) {
                        for (int j=0;j<3 && c==0;j++) {
                            if (((i*3+j+1) == pos) && (person.getData(i, j) != 'X') && (person.getData(i, j) != 'O')) {
                                person.setData(person.p2, pos);
                                ++c;
                            }
                        }
                    }
                }
            }
        }
    }

}
