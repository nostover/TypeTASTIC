/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvctypingtest;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author njc5447- Creates a main menu in which all other panels start from 
 */

public class MainMenu extends JFrame {

    private static JPanel mainButtonPanel;
    private static JPanel radioButtons;
    
    
    static MainMenBttnPanel btn = new MainMenBttnPanel();
    static RadioBttns rbtns = new RadioBttns();
    
    private static final JTextField title = new JTextField("TYPETASTIC");
    private static final JTextField nick = new JTextField("Enter Nickname");
    
    private static JPanel txtFields;
    
    void mainMenu(int passageIndex) {
        
        btn.passageNum = passageIndex;
        
        txtFields = new JPanel(new GridLayout(5, 1));
        
        txtFields.add(title);
        txtFields.add(nick);
        
        setTitle("TYPETASTIC");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    

        mainButtonPanel = MainMenBttnPanel.getButtonPanel();
        radioButtons = RadioBttns.getButtonPanel();
        
        setContentPane(new JPanel(new BorderLayout()));
        
        getContentPane().add(txtFields, BorderLayout.CENTER);
        getContentPane().add(mainButtonPanel, BorderLayout.SOUTH);
        getContentPane().add(radioButtons, BorderLayout.NORTH);

    }
    
    static String sendNick(){
        return nick.getText();
    }
    
    static void endTest() {
         TestSetup.timeStart=(false);
         btn.setUp.dispose();
    }
      



    


}
