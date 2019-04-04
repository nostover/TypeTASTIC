package mvctypingtest;

import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author njs5644
 * This class establishes an ordered ArrayList of nicknames based on their WPMs.
 * When the list gets longer than 5, delete the lowest element to keep the list length 5.
 */
public class TypistData {
    public ArrayList<String> nickList; //parallel
    public ArrayList<String> wpmList; //parallel
    public Typist tempTypist;
    
    public TypistData(Typist t){
        nickList = new ArrayList<String>();
        wpmList = new ArrayList<String>();
        tempTypist = t;
        fillLists();
        System.out.println(nickList);
        splitAndAddToList(tempTypist);
        updateList();
    }
    
    public void splitAndAddToList(Typist tt){
        nickList.add(tt.getNick());
        wpmList.add(String.valueOf(tt.getWPM()));
    }
    
    private void sortLists(){
        int temp;
        for(int i = 0; i < wpmList.size(); i++){
            for(int j = i; j > 0; j--){
                if(Integer.parseInt(wpmList.get(j)) < Integer.parseInt(wpmList.get(j - 1))){
                    temp = Integer.parseInt(wpmList.get(j));
                    wpmList.set(wpmList.indexOf(j), wpmList.get(j - 1));
                    nickList.set(nickList.indexOf(j), nickList.get(j - 1));
                    wpmList.set(wpmList.indexOf(j-1), String.valueOf(temp));
                }
            }
        }
    }
    
    void cutLists(){
        if(wpmList.size()>5){
            wpmList.subList(5, 6).clear();
        }
    }
    
    void fillLists(){
        for(int i = 0; i < 4; i++){
            nickList.add("default");
        }
        for(int i = 0; i < 4; i++){
            wpmList.add("0");
        }
    }
    
    void updateList(){
        sortLists();
        cutLists();
    }
    
    ArrayList<String> getNickList(){
        return nickList;
    }
    
    ArrayList<String> getWPMList(){
        return wpmList;
    }
}
