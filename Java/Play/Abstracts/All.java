package Play.Abstracts;
import Play.Display.Select;
import Play.Menu.Exit;
import Play.Player;
import Play.Start;
import javax.swing.JOptionPane;
public abstract class All { //extends in single player and two player
    protected abstract void finish(Player person);
    protected void select(Player p) { //select X or O
        Select s = new Select();
        String i=null;
        int c=0;
        while(c==0) { //loop exception
            try {
                i = (String) JOptionPane.showInputDialog(null,s.output(),s.title(),JOptionPane.PLAIN_MESSAGE,null,s.getList(),s.getList(0));
                char sym = i.charAt(0);
                p.setPlayer(sym);
                ++c; //c = 1 for End while exception
            }
            catch (Exception e) {
                //show error exception
                if (i == null)
                    new Exit();
                JOptionPane.showMessageDialog(null, e, "ERROR!!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    protected void again() {
        int i=-1,c=0;
        String[] obj = {"Play Again","Exit"};
        while(c==0) { //loop exception
            try {
                i = JOptionPane.showOptionDialog(null,"Do you want to exit the program?","THE END",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,obj,obj[0]);
                ++c; //c = 1 for End while exception
            }
            catch (Exception e) {
                //show error exception
                if (i==-1)
                    new Exit();
                JOptionPane.showMessageDialog(null, e, "ERROR!!", JOptionPane.ERROR_MESSAGE);
            }
        }
        switch (i) {
            case 0 : new Start();
                break;
            case 1 : new Exit();
                break;
            default : new Exit();
        }
    }
}