package Play.Display;
import Play.Interfacing.InDisplay;

public class MODE implements InDisplay { //list mode for show out

    private String[] list;

    public MODE(){
        list = new String[]{"Easy", "Medium", "Hard", "Very Hard"};
    }

    public String[] getList() {
        return list;
    }

    public String getList(int index) {
        return list[index];
    }

    @Override
    public String output() {
        return "Select mode for playing.";
    }

    @Override
    public String title() {
        return "MODE";
    }

}
