package Play.Menu;
import Play.Interfacing.AllPlayer;
import Play.Abstracts.All;
import Play.Check.CheckInput;
import Play.Check.CheckResult;
import Play.Display.OX_Table;
import Play.Player;
import Play.Start;
import javax.swing.JOptionPane;

public class TwoPlayer extends All implements AllPlayer {

    public TwoPlayer() {
        Player p = new Player(); //player is person
        this.start(p);
    }

    @Override
    public void start(Player person) {
        this.select(person); //select X or O
        this.input(person); //start play TicTacToe
        this.finish(person); //announced competition result
        System.exit(0);
    }

    @Override
    public void input(Player person) {
        /* Object in method input */
        OX_Table table = new OX_Table();
        CheckResult result = new CheckResult();
        CheckInput check = new CheckInput();
        /**/
        String input;
        int p=1,ch,stop=0; //variable controlled loop all and variable swap player 1 and 2
        while (stop==0) {
            ch=0;
            input = null;
            table.Table(person,p);
            check.check(person.getData()); //check data is null right?
            if(check.getList(0) == null) {
                break;
            }
            if (p == 1) {
                while (ch == 0) { //loop exception
                    try {
                        /* input position in TicTacToe */
                        input = (String) JOptionPane.showInputDialog(null,
                                table.output(),
                                table.title(),
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                check.getList(),
                                check.getList(0));
                        /**/
                        int pos = Integer.parseInt(input);
                        person.setData(person.p1, pos);
                        stop = result.result(person, 1); //check competition result of player 1
                        check.check(person.getData()); //check again data is null right?
                        if(check.getList(0) == null) {
                            break;
                        }
                        ++ch; //ch = 1 for End while exception
                        p = 2;
                    } catch (Exception e) {
                        //show error exception
                        if (input == null)
                            new Exit();
                        JOptionPane.showMessageDialog(null, e, "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            else if (p == 2) {
                while (ch == 0) { //loop exception
                    try {
                        /* input position in TicTacToe */
                        input = (String) JOptionPane.showInputDialog(null,
                                table.output(),
                                table.title(),
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                check.getList(),
                                check.getList(0));
                        /**/
                        int pos = Integer.parseInt(input);
                        person.setData(person.p2, pos);
                        stop = result.result(person, 2); //check competition result of player 2
                        check.check(person.getData()); //check again data is null right?
                        if(check.getList(0) == null) {
                            break;
                        }
                        ++ch; //ch = 1 for End while exception
                        p = 1;
                    } catch (Exception e) {
                        //show error exception
                        if (input == null)
                            new Exit();
                        JOptionPane.showMessageDialog(null, e, "ERROR!!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }

    protected void finish(Player person) { //show competition result
        if (person.getResult(1)==1) {
            JOptionPane.showMessageDialog(null, "Player 1 win.", "Competition Result", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (person.getResult(2)==1) {
            JOptionPane.showMessageDialog(null, "Player 2 win.", "Competition Result", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (person.getResult(1)!=1 && person.getResult(2)!=1){
            JOptionPane.showMessageDialog(null, "Draw", "Competition Result", JOptionPane.INFORMATION_MESSAGE);
        }
        this.again(); //replay again
    }

}
