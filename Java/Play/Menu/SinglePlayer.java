package Play.Menu;
import Play.Interfacing.AllPlayer;
import Play.Abstracts.All;
import Play.Check.CheckInput;
import Play.Check.CheckResult;
import Play.Display.OX_Table;
import Play.ComMODE.*;
import Play.Player;
import Play.Start;
import javax.swing.JOptionPane;
public class SinglePlayer extends All implements AllPlayer {
    private int mode; //attribute mode
    public SinglePlayer() {
        Player p = new Player(); //player is person
        this.start(p);
    }
    @Override
    public void start(Player person) {
        person.setMode(); //set computer mode [Easy,Medium,Hard,Very Hard]
        mode = person.getMode(); //record mode for find or research
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
        String input;
        int ch,stop = 0; //variable controlled loop all
        while (stop == 0) {
            ch = 0;
            input = null;
            table.Table(person);
            check.check(person.getData()); //check data is null right?
            if(check.getList(0) == null)
                break;
            while(ch==0) { //loop exception
                try {
                    /* input position in TicTacToe */
                    input = (String) JOptionPane.showInputDialog(null,table.output(),table.title(),JOptionPane.PLAIN_MESSAGE,null,check.getList(),check.getList(0));
                    int pos = Integer.parseInt(input);
                    person.setData(person.p1, pos);
                    stop = result.result(person, 1); //check competition result of player
                    check.check(person.getData()); //check again data is null right?
                    if (check.getList(0) == null) {
                        stop = 1;
                        break;
                    }
                    if (stop == 0) {
                        this.computer(person); //process computing
                        stop = result.result(person, 2); //check competition result of computer
                    }
                    ++ch; //ch = 1 for End while exception
                } catch (Exception e) {
                    //show error exception
                    if (input == null)
                        new Exit();
                    JOptionPane.showMessageDialog(null, e, "ERROR!!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    protected void finish(Player person) { //show competition result
        if (person.getResult(1) == 1)
            JOptionPane.showMessageDialog(null, "Your win.", "Competition Result", JOptionPane.INFORMATION_MESSAGE);
        else if (person.getResult(2) == 1)
            JOptionPane.showMessageDialog(null, "Your lose.", "Competition Result", JOptionPane.INFORMATION_MESSAGE);
        else if (person.getResult(1) != 1 && person.getResult(2) != 1)
            JOptionPane.showMessageDialog(null, "Your draw.", "Competition Result", JOptionPane.INFORMATION_MESSAGE);
        this.again(); //replay again
    }
    private void computer(Player person) { //process computing
        switch (mode) {
            case 1 : new Easy(person);
                break;
            case 2 : new Medium(person);
                break;
            case 3 : new Hard(person);
                break;
            case 4 : new VeryHard(person);
                break;
        }
    }
}