/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package elevator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author martin
 */
public class CabinPanel extends Panel{

    private Elevator _elevator;

    public CabinPanel(Elevator elevator){
        _elevator = elevator;

        ActionListener cabinButtonActionListener  = new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cabinButtonActionPerformed(evt);
            }
        };

        for (int i = elevator.getLevels(); i != 0; i--) {
            JButton cabinButton = new JButton(String.valueOf(i));
            cabinButton.addActionListener(cabinButtonActionListener);
            add(cabinButton);

        }
    }
    
    private void cabinButtonActionPerformed(ActionEvent evt){
        int destLevelNum = Integer.parseInt(evt.getActionCommand());
        _elevator.moveCabin(destLevelNum);
    }


}
