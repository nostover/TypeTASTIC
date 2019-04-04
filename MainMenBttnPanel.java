/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvctypingtest;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Owner
 */
public class MainMenBttnPanel extends JPanel {

    private static JPanel buttonPanel;
    public static int passageNum = 0;
   
    
    public MainMenBttnPanel() {
        
        buttonPanel = new JPanel(new GridLayout(4, 1));

        JButton begin = new JButton("Begin Test");
        JButton scoreboard = new JButton("ScoreBoard");
        JButton exitButton = new JButton("Exit");

        exitButton.addActionListener(event -> exitApp());
        begin.addActionListener(event -> BeginTest());
        scoreboard.addActionListener(event -> scoreboard());

        buttonPanel.add(begin);
        buttonPanel.add(scoreboard);
        buttonPanel.add(exitButton);

    }
    
    
    
    private void exitApp() {
        System.exit(0);
    }
    TestSetup setUp = new TestSetup(TypingView.cntl, passageNum);
    private void BeginTest() {
        
        setUp.initSetup();
        setUp.setVisible(true);

    }
    
    Scoreboard board = new Scoreboard();
    
    private void scoreboard() {
        board.Scoreboard();
        board.setVisible(true);
    }

    public static JPanel getButtonPanel() {

        return buttonPanel;
    }

}
