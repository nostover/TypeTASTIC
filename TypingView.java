package mvctypingtest;

import javax.swing.JButton;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class TypingView {

 
    static String text;
    static Controller cntl;
    public TestSetup tst;
    public MainMenu mm;
    public String nick;
    private ArrayList<String> nickList;
    private ArrayList<String> wpmList;
    
    public TypingView(Controller cntl, int startingIndexOfDisplay) {
        
        this.text = cntl.sendTextPassage();
        this.cntl = cntl; 
        this.nickList = cntl.getNickList();
        this.wpmList = cntl.getWPMList();
        
        this.mm = new MainMenu();
        mm.mainMenu(startingIndexOfDisplay);  
        mm.setVisible(true);
        nick = mm.sendNick();
    }
    public void getLists(){
        this.nickList = cntl.getNickList();
        this.wpmList = cntl.getWPMList();
    }
    public void updateLists(){
        cntl.sendTypist();
    }  
}
