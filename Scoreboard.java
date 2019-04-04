/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvctypingtest;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Owner
 */
public class Scoreboard extends JFrame{
    
    private static final JLabel p1 = new JLabel("Player1");
    private static final JLabel p2 = new JLabel("Player2");
    private static final JLabel p3 = new JLabel("Player3");
    private static final JLabel p4 = new JLabel("Player4");
    private static final JLabel p5 = new JLabel("Player5");
    
    private static final JLabel s1 = new JLabel("SCORE1");
    private static final JLabel s2 = new JLabel("SCORE2");
    private static final JLabel s3 = new JLabel("SCORE3");
    private static final JLabel s4 = new JLabel("SCORE4");
    private static final JLabel s5 = new JLabel("SCORE5");
    
    private JPanel names;
    private JPanel scores;

    public  void Scoreboard(){    
        
        setTitle("TYPETASTIC");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        names = new JPanel(new GridLayout(5, 1));
        
        names.add(p1);
        names.add(p2);
        names.add(p3);
        names.add(p4);
        names.add(p5);
        
        scores = new JPanel(new GridLayout(5, 1));
        scores.add(s1);
        scores.add(s2);
        scores.add(s3);
        scores.add(s4);
        scores.add(s5);
    
        JButton menuButton = new JButton("Main Menu");
        menuButton.addActionListener(event -> mainMen());
        
        setContentPane(new JPanel(new GridLayout(1,2)));
        
        getContentPane().add(scores);
        getContentPane().add(names);
        
        getContentPane().add(menuButton);
        setTextFields();
    }

    private void mainMen() {
        setVisible(false);
    }
    
    void setTextFields(){
        ArrayList<String> nickList = TypingView.cntl.getNickList();
        ArrayList<String> wpmList = TypingView.cntl.getWPMList();
        
        p1.setText(nickList.get(0));
        p2.setText(nickList.get(1));
        p3.setText(nickList.get(2));
        p4.setText(nickList.get(3));
        p5.setText(nickList.get(4));
        
        s1.setText(wpmList.get(0));
        s2.setText(wpmList.get(1));
        s3.setText(wpmList.get(2));
        s4.setText(wpmList.get(3));
        s5.setText(wpmList.get(4));
    }
}
