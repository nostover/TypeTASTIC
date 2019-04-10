package mvctypingtest;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Model{
    
    private Typist currentUserData;
    private TypistData nickList;
    private TypistData wpmList;
    private TypistData typistList;
    public String[] textPassage;
    public String[] missedWords;
    public double tempWPM;
    
    public Model() throws Exception{//Stove
        currentUserData = new Typist();
        typistList = new TypistData(currentUserData);
        this.setTextPassage();
    }
        
    public ArrayList<String> getNickList(){//Stove
        return typistList.getNickList();
    }
    
    public ArrayList<String> getWPMList(){//Stove
        return typistList.getWPMList();
    }
    
    public void setTypist(String nick){//Stove
        this.currentUserData.setNick(nick);
        this.currentUserData.setWPM((int)tempWPM);
    }
    
    public void setTextPassage() throws Exception{//Stove
        File inputFile = new File("textPassage.txt");
        Scanner sc = new Scanner(new FileReader(inputFile));
       
        ArrayList<String> lines = new ArrayList<String>();
       
        while((sc.hasNextLine())){
          lines.add(sc.nextLine().toString());
            
         }   

        textPassage = lines.toArray(new String[0]);
        
    }
    
    public String[] getTextPassage(){//Stove
        return textPassage;
    }
    
    public double calcWPM(String userInput){//Stove
        double wpm = 0;
        int time = RadioBttns.getTimeChoice();
        int words = 0;
        
        String[] textPassage = getTextPassage();
        String[] newTextPassage = textPassage[0].split("\\s+");
        String[] userInputArray = userInput.split("\\s+");
        
        for (int i = 0; i < userInputArray.length; i++)
        {
            if(userInputArray[i].compareTo(newTextPassage[i]) == 0)
                words++;
        }
        
        wpm = words/(time/60);
        return wpm;
    }
    
}
