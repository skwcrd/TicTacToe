package Play.Check;
import Play.Player;

public class CheckPattern {

    private boolean[] empty = new boolean[9];
    private boolean[][] pos_p = new boolean[3][3];
    private int pos;

    public CheckPattern(Player person) {
        char tmp = person.p1;
        for (int i=0;i<3;i++) { //check data
            for (int j=0;j<3;j++) {
                empty[i*3+j] = (person.getData(i,j) != person.p1) && (person.getData(i,j) != person.p2);
                pos_p[i][j] = (person.getData(i,j) == tmp);
            }
        }
    }

    public int search() {
        boolean pat1,pat2,pat3,pat4,pat5,pat6;
        pat1 = (pos_p[0][0] && pos_p[1][1]) || (pos_p[0][2] && pos_p[1][1]) || (pos_p[2][0] && pos_p[1][1]) || (pos_p[2][2] && pos_p[1][1]);
        pat2 = (pos_p[0][0] && pos_p[2][2]) || (pos_p[0][2] && pos_p[2][0]);
        pat3 = empty[4] && (pos_p[0][0] || pos_p[0][2] || pos_p[2][0] || pos_p[2][2]);
        pat4 = pos_p[0][0] || pos_p[0][2] || pos_p[2][0] || pos_p[2][2];
        pat5 = pos_p[0][1] || pos_p[1][0] || pos_p[1][2] || pos_p[2][1];
        pat6 = pos_p[1][1] || (!empty[4]);
        if(pat1) {
            this.odd2();
        }
        else if(pat2) {
            this.even();
        }
        else if (pat3) {
            pos = 5;
        }
        else if(pat4) {
            this.odd();
        }
        else if (pat5) {
            this.odd();
        }
        else if (pat6) {
            this.odd2();
        }
        else {
            while (true) {
                pos = (((int) (Math.round(Math.random() * 10))) % 9) + 1;
                if(empty[pos-1])
                    break;
            }
        }
        return pos;
    }

    private void even() {
        boolean tmp,pat1,pat2,pat3,pat4;
        while (true) {
            pos = (((int) (Math.round(Math.random()*10)))%9)+1;
            pat1 = empty[pos -1] && pos_p[0][0] && (pos == 2 || pos == 4);
            pat2 = empty[pos -1] && pos_p[0][2] && (pos == 2 || pos == 6);
            pat3 = empty[pos -1] && pos_p[2][0] && (pos == 4 || pos == 8);
            pat4 = empty[pos -1] && pos_p[2][2] && (pos == 6 || pos == 8);
            tmp = empty[pos-1] && (!empty[1] && !empty[3] && !empty[5] && !empty[7]);
            if(patt(pat1,pat2,pat3,pat4,tmp))
                break;
        }
    }

    private void odd() {
        boolean tmp,pat1,pat2,pat3,pat4;
        while (true) {
            pos = (((int) (Math.round(Math.random()*10)))%9)+1;
            pat1 = empty[pos -1] && pos_p[0][1] && (pos == 1 || pos == 3);
            pat2 = empty[pos -1] && pos_p[1][0] && (pos == 1 || pos == 7);
            pat3 = empty[pos -1] && pos_p[1][2] && (pos == 3 || pos == 9);
            pat4 = empty[pos -1] && pos_p[2][1] && (pos == 7 || pos == 9);
            tmp = empty[pos-1] && (!empty[0] && !empty[2] && !empty[6] && !empty[8]);
            if(patt(pat1,pat2,pat3,pat4,tmp))
                break;
        }
    }

    private void odd2() {
        boolean tmp,pat;
        while (true) {
            pos = (((int) (Math.round(Math.random()*10)))%9)+1;
            pat = (pos%2 != 0) && empty[pos -1];
            tmp = empty[pos-1] && (!empty[0] && !empty[2] && !empty[6] && !empty[8]);
            if(pat)
                break;
            else if(tmp)
                break;
        }
    }

    private boolean patt(boolean p1,boolean p2,boolean p3,boolean p4,boolean p5) {
        boolean p = false;
        if(p1)
            p = true;
        else if(p2)
            p = true;
        else if(p3)
            p = true;
        else if(p4)
            p = true;
        else if(p5)
            p = true;
        return p;
    }

}
