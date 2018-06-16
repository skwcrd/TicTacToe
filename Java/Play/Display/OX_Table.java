package Play.Display;
import Play.Interfacing.InDisplay;
import Play.Player;

public class OX_Table implements InDisplay{ //TicTacToe table for show out

    private char[][] data;
    private int num;
    private char c;

    public void Table(Player person) {
        data = person.getData();
        c = person.p1;
        num = 0;
    }

    public void Table(Player person,int n) {
        data = person.getData();
        switch (n) {
            case 1 : c = person.p1;
                break;

            case 2 : c = person.p2;
                break;
        }
        num = n;
    }

    @Override
    public String output() {
        String st1,st2,row1,row2,row3,betw1,betw2,betw3,betw;
        betw1 = "                  ";
        betw2 = "        |        ";
        betw3 = "          ";
        betw = betw3 + "-------------- -------------- --------------\n";
        row1 = betw1 + data[0][0] + betw2 + data[0][1] + betw2 + data[0][2] + "\n";
        row2 = betw1 + data[1][0] + betw2 + data[1][1] + betw2 + data[1][2] + "\n";
        row3 = betw1 + data[2][0] + betw2 + data[2][1] + betw2 + data[2][2] + "\n";
        st1 = "You is [" + c + "]\n\n";
        st2 = "\nPlease input number [1-9 only]\n\n";
        return st1 + row1 + betw + row2 + betw + row3 + st2;
    }

    @Override
    public String title() {
        String title;
        if(num != 0)
            title = "Player " + num + " [" + c + "]";
        else
            title = "Player [" + c + "]";
        return title;
    }

}
