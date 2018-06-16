package Play;
import Play.Menu.Exit;
import Play.Display.MODE;
import javax.swing.JOptionPane;

public class Player {

    private char[][] data;
    private int mode,result1,result2;
    public char p1,p2; //player 1 and player 2 ['X' or 'O']

    /*===================== Player =====================*/
    public Player() {
        data = new char[3][3];
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++)
                data[i][j] = (char)('1'+(i*3+j));
        }
        mode = 0;
        result1 = 0;
        result2 = 0;
    }

    public void setPlayer(char p) {
        switch (p) {
            case 'X' :  p1 = 'X';
                p2 = 'O';
                break;

            case 'O' :  p1 = 'O';
                p2 = 'X';
                break;
        }
    }
    /*==================================================*/

    /*===================== Result =====================*/
    public int getResult(int n) {
        int result;
        switch (n) {
            case 1 : result = result1;
                break;

            case 2 : result = result2;
                break;

                default: result = 0;
        }
        return result;
    }

    public void setResult(int result,int n) {
        switch (n) {
            case 1 : result1 = result;
                break;

            case 2 : result2 = result;
                break;
        }
    }

    public void addResult(int result,int n) {
        switch (n) {
            case 1 : result1 += result;
                break;

            case 2 : result2 += result;
                break;
        }
    }
    /*==================================================*/

    /*====================== Data ======================*/
    public char[][] getData() {
        return data;
    }

    public char getData(int i,int j) {
        return data[i][j];
    }

    public void setData(char d,int pos) {
        for (int c=0,i=0;i<3&&c==0;i++) {
            for (int j=0;j<3&&c==0;j++) {
                if ((i*3+j+1) == pos) {
                    data[i][j] = d;
                    ++c;
                }
            }
        }
    }
    /*==================================================*/

    /*====================== Mode ======================*/
    public int getMode() {
        return mode;
    }

    public void setMode() {
        MODE m = new MODE();
        String input=null;
        int ch=0; //variable controlled loop exception
        while (ch==0) { //loop exception
            try {
                /*input select mode [Easy,Medium,Hard,Very Hard]*/
                input = (String) JOptionPane.showInputDialog(null,
                        m.output(),
                        m.title(),
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        m.getList(),
                        m.getList(0));
                /**/
                if(input.equals(m.getList(0)))
                    mode = 1;
                else if(input.equals(m.getList(1)))
                    mode = 2;
                else if(input.equals(m.getList(2)))
                    mode = 3;
                else if(input.equals(m.getList(3)))
                    mode = 4;
                ++ch; //ch = 1 for End while exception
            }
            catch (Exception e) {
                //show error exception
                if (input == null)
                    new Exit();
                JOptionPane.showMessageDialog(null, e, "ERROR!!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    /*==================================================*/

}
