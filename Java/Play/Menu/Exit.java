package Play.Menu;
import Play.Start;
import javax.swing.JOptionPane;
public class Exit {
    public Exit() { //exit for end program
        String output,title;
        int input = -1,ch = 0;
        output = "Are you sure you want to exit program?\n";
        title = "END PROGRAM";
        while (ch == 0) { //loop exception
            try {
                input = JOptionPane.showConfirmDialog(null,output,title,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                this.checkExit(input);
                ++ch; //ch = 1 for End while exception
            }
            catch (Exception e) {
                //show error exception
                JOptionPane.showMessageDialog(null, e, "ERROR!!", JOptionPane.ERROR_MESSAGE);
            }
        }
        System.exit(0);
    }
    private void checkExit(int input) {
        String temp,tab,output;
        tab = "\n                ";
        output = tab + "THANK YOU THEN SEE U AGAIN\n";
        temp = "========================================";
        output = temp + output + temp;
        switch (input) {
            case 0 : JOptionPane.showMessageDialog(null, output, "EXIT", JOptionPane.PLAIN_MESSAGE);
                break;
            case 1 : new Start();
                break;
            default : JOptionPane.showMessageDialog(null, output, "EXIT", JOptionPane.PLAIN_MESSAGE);
        }
        System.exit(0);
    }
}