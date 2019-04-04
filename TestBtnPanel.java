package mvctypingtest;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TestBtnPanel extends JPanel { //njc5447

    private static JPanel buttonPanel;
    public TestBtnPanel() {

        buttonPanel = new JPanel(new GridLayout(3, 1));
        JButton startButton = new JButton("Start");
  
        JButton menuButton = new JButton("Main Menu");
        JButton exitButton = new JButton("Exit");

        exitButton.addActionListener(event -> exitApp());
        startButton.addActionListener(event -> startButton());
        menuButton.addActionListener(event -> mainMen());

        buttonPanel.add(startButton);
        buttonPanel.add(menuButton);
        buttonPanel.add(exitButton);
    }

    public static JPanel getButtonPanel() {

        return buttonPanel;
    }

    private void exitApp() {
        System.exit(0);
    }

    private void startButton() {
        TestSetup.setTextPassage();
        TestSetup.startTimer(RadioBttns.getTimeChoice());
        TestSetup.timeStart=(true);

    }

    private void mainMen() {
        MainMenu.endTest();
        TypingView.cntl.sendTypist();
    }

}
