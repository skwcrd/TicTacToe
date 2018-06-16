package Play.Display;
import Play.Interfacing.InDisplay;

public class MENU implements InDisplay { //list menu for show out

    @Override
    public String output() {
        String st1,st2,m1,m2,m3,tab; //variable for all menu
        /*--------------------- MENU your select ---------------------*/
        tab = "          ";
        st1 = "Select MENU for start game\n";
        st2 = "\nPlease input your menu select.\n\n";
        m1 = tab + "1. Single Player\n";
        m2 = tab + "2. Two Player\n";
        m3 = tab + "3. Exit Game\n";
        /*------------------------------------------------------------*/
        return st1 + m1 + m2 + m3 + st2;
    }

    @Override
    public String title() {
        return "Welcome to TicTacToe Game";
    }

}
