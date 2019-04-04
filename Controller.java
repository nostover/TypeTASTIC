
package mvctypingtest;

import java.util.ArrayList;

class Controller //njc5447
{
    
    Model mod;
    TypingView view;
    
    private static final int PassageIndex = 0;

    public Controller() throws Exception {
        mod = new Model(); 
        view = new TypingView(this, PassageIndex);
 
    }
    
    public String sendTextPassage(){
        String [] txt = mod.getTextPassage();
        String text = txt[0];
        //random generator for passage in future 
        return text;
    }
    
    public String getWPM(String userInput){
        double wpm = mod.calcWPM(userInput, view.tst.sendTimeChoice());
        String wpmString = String.valueOf(wpm);
        
        return wpmString;
    }
    
    public void sendTypist(){
        mod.setTypist(MainMenu.sendNick());
    }
    public ArrayList<String> getNickList(){
        return mod.getNickList();
    }
    public ArrayList<String> getWPMList(){
        return mod.getWPMList();
    }
}
