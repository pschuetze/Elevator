/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;

import elevator.Globals.directionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author martin
 */
public class CabinPanel extends Panel {

    private Elevator _elevator;
    private ActionListener _cabinButtonActionListener = new java.awt.event.ActionListener() {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cabinButtonActionPerformed(evt);
        }
    };

    public CabinPanel(Elevator elevator) {
        _elevator = elevator;
        JButton cabinButton;

        for (int i = elevator.getLevels(); i != 0; i--) {
            cabinButton = new JButton(String.valueOf(i));
            cabinButton.addActionListener(_cabinButtonActionListener);
            add(cabinButton);

        }
    }

    private void cabinButtonActionPerformed(ActionEvent evt) {

        int destLevelNum = Integer.parseInt(evt.getActionCommand());
        directionType direction;
        int currentLevel = _elevator.getCabin().getCurrentLevel();

        if(destLevelNum == currentLevel){
            return;
        }

        direction = destLevelNum > currentLevel ? directionType.UP : directionType.DOWN;
        _elevator.getCallList().add(new CallListEntry(direction, destLevelNum));
    }
}
