/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author martin
 */
public class Run {

    public Building building;

    public void init(){
         this.building = new Building(Globals.levels, Globals.elevators);
         System.out.println("init succesfully");
    }

    public void drawLayout(){
        JFrame frame = new JFrame("ElevatorSimu");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,1));

        ActionListener initAction = new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                init();
            }
        };

        JButton button = new JButton("Initialise");
        button.addActionListener(initAction);


        panel.add(button);

        frame.add(panel);
        frame.pack();

    }


}
