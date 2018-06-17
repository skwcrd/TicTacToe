package Play.Check;
import java.util.ArrayList;
public class CheckInput {
    private ArrayList<Character> arrayList = new ArrayList<>();
    private String[] list;
    public void check(char[][] data) { //check value input data
        arrayList.clear();
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                if((data[i][j] != 'X') && (data[i][j] != 'O'))
                    arrayList.add(data[i][j]);
            }
        }
        //convert array list to string array
        if (arrayList.size() == 0)
            list[0] = null;
        else {
            list = new String[arrayList.size()];
            for (int c=0,i=0;i<3;i++) {
                for (int j=0;j<3;j++) {
                    if ((data[i][j] != 'X') && (data[i][j] != 'O'))
                        list[c++] = Character.toString(data[i][j]);
                }
            }
        }
    }
    public String[] getList() {
        return list;
    }
    public String getList(int index) {
        return list[index];
    }
}