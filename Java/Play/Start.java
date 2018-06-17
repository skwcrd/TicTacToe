package Play;
import Play.Menu.*;
import Play.Display.MENU;
import javax.swing.JOptionPane;
public class Start {
    /*Class for start the program*/
    public Start() {
        this.showMenu(); //start working
    }
    private void showMenu() {
        MENU m = new MENU();
        String input,output,title; //variable for all menu
        int ch = 0,menu = 0;
        input = null; //value initial input is null
        output = m.output();
        title = m.title();
        while (ch==0) { //loop exception
            try {
                input = JOptionPane.showInputDialog(null, output,title,JOptionPane.PLAIN_MESSAGE);
                menu = Integer.parseInt(input);
                //input 1,2,3,4 only
                while(menu>3||menu<1) { //for crash protection
                    String err,t_err;
                    err = "ERROR!!!, Input incorrect.\nYou select the wrong menu input.\nPlease re-enter the menu.";
                    t_err = "ERROR!!";
                    JOptionPane.showMessageDialog(null, err, t_err, JOptionPane.WARNING_MESSAGE);
                    input = JOptionPane.showInputDialog(null, output,title,JOptionPane.PLAIN_MESSAGE);
                    menu = Integer.parseInt(input);
                }
                ++ch; //ch = 1 for End while exception
            }
            catch (Exception e) {
                //show error exception
                if (input == null)
                    new Exit();
                JOptionPane.showMessageDialog(null, e, "ERROR!!", JOptionPane.ERROR_MESSAGE);
            }
        }
        this.menu(menu);
        System.exit(0);
    }
    private void menu(int m) { //Worked by menu input
        switch (m) {
            case 1 : new SinglePlayer();
                break;
            case 2 : new TwoPlayer();
                break;
            case 3 : new Exit();
                break;
            default : System.exit(0);
        }
    }
}