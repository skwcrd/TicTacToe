package Play.Display;
import Play.Interfacing.InDisplay;

public class Select implements InDisplay { //list OX for show out

    private String[] list;

    public Select(){
        list = new String[]{"X", "O"};
    }

    public String[] getList() {
        return list;
    }

    public String getList(int index) {
        return list[index];
    }

    @Override
    public String output() {
        return "Select symbol of first player.";
    }

    @Override
    public String title() {
        return "PLAYER [X/O]";
    }

}
