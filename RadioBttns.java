/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvctypingtest;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Owner
 */
class RadioBttns extends JPanel {

    private static JPanel buttonPanel;
    public static int timeSelect;

    public RadioBttns() {

        buttonPanel = new JPanel(new GridLayout(1, 3));

        JRadioButton ThirtySec = new JRadioButton("Thirty Seconds");
        JRadioButton OneMinute = new JRadioButton("One Minute");
        JRadioButton ThreeMinute = new JRadioButton("Three Minutes");

        OneMinute.setSelected(true);
        timeSelect = 60;

        ThirtySec.addActionListener(event -> timeSelect = 30);
        ThirtySec.addActionListener(event -> OneMinute.setSelected(false));
        ThirtySec.addActionListener(event -> ThreeMinute.setSelected(false));
        
       
        OneMinute.addActionListener(event -> timeSelect = 60);
        OneMinute.addActionListener(event -> ThreeMinute.setSelected(false));
        OneMinute.addActionListener(event -> ThirtySec.setSelected(false));

        ThreeMinute.addActionListener(event -> timeSelect = 180);
        ThreeMinute.addActionListener(event -> OneMinute.setSelected(false));
        ThreeMinute.addActionListener(event -> ThirtySec.setSelected(false));

        buttonPanel.add(ThirtySec);
        buttonPanel.add(OneMinute);
        buttonPanel.add(ThreeMinute);

    }

    public static JPanel getButtonPanel() {

        return buttonPanel;
    }
    
    public static int getTimeChoice(){
        return timeSelect;
    }


}
