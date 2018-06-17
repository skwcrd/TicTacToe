package Play.Check;
import Play.Player;
public class ChecktoWin {
    private char[][] tmp;
    private boolean[][] temp = new boolean[3][3];
    private char ch;
    private int position;
    public int check(Player person, int n) {
        tmp = person.getData();
        person.setResult(0,n);
        switch (n) {
            case 1 : ch = person.p1;
                break;
            case 2 : ch = person.p2;
                break;
        }
        for (int i=0;i<3;i++) { //check data
            for (int j=0;j<3;j++) {
                temp[i][j] = (person.getData(i,j) != 'X') && (person.getData(i,j) != 'O');
            }
        }
        position = 0;
        this.Horizontal(); //   |
        this.Vertical(); //     _
        this.Diagonal1(); //    \
        this.Diagonal2(); //    /
        return position;
    }
    private void Horizontal() {
        if(position == 0) {
            for (int i=0;i<3;i++) { //check for horizontal
                if ((tmp[i][0] == ch) && (tmp[i][1] == ch) && temp[i][2])
                    position = i*3+3;
                else if ((tmp[i][0] == ch) && temp[i][1] && (tmp[i][2] == ch))
                    position = i*3+2;
                else if (temp[i][0] && (tmp[i][1] == ch) && (tmp[i][2] == ch))
                    position = i*3+1;
            }
        }
    }
    private void Vertical() {
        if(position == 0) {
            for(int i=0;i<3;i++){ //check for vertical
                if ((tmp[0][i] == ch) && (tmp[1][i] == ch) && temp[2][i])
                    position = 2*3+i+1;
                else if ((tmp[0][i] == ch) && temp[1][i] && (tmp[2][i] == ch))
                    position = 3+i+1;
                else if (temp[0][i] && (tmp[1][i] == ch) && (tmp[2][i] == ch))
                    position = i+1;
            }
        }
    }
    private void Diagonal1() {
        if(position == 0) { //check for diagonal
            if ((tmp[0][0] == ch) && (tmp[1][1] == ch) && temp[2][2])
                position = 9;
            else if ((tmp[0][0] == ch) && temp[1][1] && (tmp[2][2] == ch))
                position = 5;
            else if (temp[0][0] && (tmp[1][1] == ch) && (tmp[2][2] == ch))
                position = 1;
        }
    }
    private void Diagonal2() {
        if(position == 0) { //check for diagonal
            if ((tmp[0][2] == ch) && (tmp[1][1] == ch) && temp[2][0])
                position = 7;
            else if ((tmp[0][2] == ch) && temp[1][1] && (tmp[2][0] == ch))
                position = 5;
            else if (temp[0][2] && (tmp[1][1] == ch) && (tmp[2][0] == ch))
                position = 3;
        }
    }
}