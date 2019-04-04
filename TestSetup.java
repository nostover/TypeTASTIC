/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvctypingtest;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;


/**
 *
 * @author njc5447
 */
public class TestSetup extends JFrame {
    
    private static final JTextArea txtIn = new JTextArea();
    private static final JTextArea txtDisp = new JTextArea();
    private static final JTextField wpm = new JTextField("WPM");
    private static final JTextField accuracy = new JTextField("%");
    private static final JTextField time = new JTextField("TIME");

    private JPanel calcPanel;
    private JPanel textPanel;
    private JPanel buttonPanel;

    public static int timeChoice;
    private int indexOfItemToDisplay;
    
    private static Controller cntl;
    private static String text;
    
    public static boolean timeStart= true;
    
   
public TestSetup(Controller cntl, int startingIndexOfDisplay) {
        
        TestSetup.timeChoice = RadioBttns.getTimeChoice();
        
        this.text = cntl.sendTextPassage();
        this.cntl = cntl;

       
        indexOfItemToDisplay = startingIndexOfDisplay;
        initSetup();
    }

int sendTimeChoice(){
   return timeChoice; 
}
void initSetup(){//njc5447       
        setTitle("TYPETASTIC");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TestBtnPanel btn = new TestBtnPanel();

        txtIn.setLineWrap(true);
        txtIn.setWrapStyleWord(true);

        txtDisp.setLineWrap(true);
        txtDisp.setWrapStyleWord(true);

        JScrollPane txtDispSc = new JScrollPane(txtDisp);
        add(txtDispSc);
        txtDispSc.setSize(150, 150);

        JScrollPane txtInSc = new JScrollPane(txtIn);
        add(txtInSc);
        txtInSc.setSize(150, 150);
        
        textPanel = new JPanel(new GridLayout(2, 1));
       
        textPanel.add(txtDispSc);
        txtDisp.setText("Click 'Start' to begin your typing test!");
        txtIn.setText("Your Text Goes Here!");
        textPanel.add(txtInSc);

        calcPanel = new JPanel(new GridLayout(4, 1));
        calcPanel.add(wpm);
        calcPanel.add(accuracy);
        calcPanel.add(time);
        
        buttonPanel = btn.getButtonPanel();
        setContentPane(new JPanel(new BorderLayout()));
        getContentPane().add(calcPanel, BorderLayout.WEST);
        getContentPane().add(textPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.EAST);

    }

    public static void setTextPassage()//njc5447
    {
        txtDisp.setText(text);
        txtIn.setText("");
    }
    
    public static void stopTimer(){
        timeStart= false;
    }
    
    public static void startTimer(int timeChoice) {
        Timer timer = new Timer(1000, new ActionListener() //creates timer w/ActionListener, 1000 is every second-Troy
        {
            int sec = timeChoice;
            
            @Override
            public void actionPerformed(ActionEvent e) {
               
                    if (!timeStart){

                        ((Timer) e.getSource()).stop();
                        time.setText(":" + sec);
                        
                    }else if (sec == 0) {
                    time.setText(":" + sec);
                    txtDisp.setText("Done! Click Exit to quit, Click Main Menu to save your score");
                    ((Timer) e.getSource()).stop();
                    
                    sec = timeChoice;
                }else{
                    time.setText(":" + sec);
                    sendWPMString();
                    setWPM();
                    sec--;
                    }   
        }
        });
      
        timer.start();
        
    }
    
    
    public static void setWPM()//njc5447
    {
        wpm.setText("WPM:" + cntl.getWPM(txtIn.getText()));
    }

    public static String sendWPMString()//njc5447
    {
        setWPM();
        wpm.setText(wpm.getText());
        return "WPM:" + cntl.getWPM(txtIn.getText());
    }
    
    public static int sendWPMInt(){
        return Integer.parseInt(wpm.getText());
    }
}
