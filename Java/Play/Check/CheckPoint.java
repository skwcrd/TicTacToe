package Play.Check;
import Play.Player;
class CheckPoint {
    private char[][] tmp;
    private char ch;
    CheckPoint(Player person, int n) {
        tmp = person.getData();
        person.setResult(0,n);
        switch (n) {
            case 1 : ch = person.p1;
                break;
            case 2 : ch = person.p2;
                break;
        }
        this.Horizontal(person,n); //   |
        this.Vertical(person,n); //     _
        this.Diagonal1(person,n); //    \
        this.Diagonal2(person,n); //    /
        if(person.getResult(1)!=1 && person.getResult(2)!=1) {
            person.setResult(0,1);
            person.setResult(0,2);
        }
    }
    private void Horizontal(Player person, int n) {
        if(person.getResult(n)<=0) {
            for (int c=0,i=0; i<3 && c==0; i++) { //check for horizontal
                if ((tmp[i][0] == ch) && (tmp[i][1] == ch) && (tmp[i][2] == ch)) {
                    person.addResult(1,n);
                    ++c;
                }
            }
        }
    }
    private void Vertical(Player person, int n) {
        if(person.getResult(n)<=0) {
            for(int c=0,i=0; i<3 && c==0; i++){ //check for vertical
                if((tmp[0][i]==ch) && (tmp[1][i]==ch) && (tmp[2][i]==ch)) {
                    person.addResult(1,n);
                    ++c;
                }
            }
        }
    }
    private void Diagonal1(Player person, int n) {
        if(person.getResult(n)<=0) { //check for diagonal
            if((tmp[0][0]==ch) && (tmp[1][1]==ch) && (tmp[2][2]==ch))
                person.addResult(1,n);
        }
    }
    private void Diagonal2(Player person, int n) {
        if(person.getResult(n)<=0) { //check for diagonal
            if((tmp[0][2]==ch) && (tmp[1][1]==ch) && (tmp[2][0]==ch))
                person.addResult(1,n);
        }
    }
}