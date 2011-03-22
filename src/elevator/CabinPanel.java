/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;

import elevator.Globals.directionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;

/**
 *
 * @author martin
 */
public class CabinPanel extends Panel {

    private Elevator _elevator;
    private HashMap<Integer, JButton> _panelNumberButtons = new HashMap<Integer, JButton>();
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
            _panelNumberButtons.put(i, cabinButton);

        }
    }

    private void cabinButtonActionPerformed(ActionEvent evt) {
        int destLevelNum = Integer.parseInt(evt.getActionCommand());
        JButton myButton = _panelNumberButtons.get(destLevelNum);

        directionType direction;
        int currentLevel = _elevator.getCabin().getCurrentLevel();

        if(destLevelNum == currentLevel){
            return;
        }

        myButton.setEnabled(false);

        direction = destLevelNum > currentLevel ? directionType.UP : directionType.DOWN;
        _elevator.getCallList().addCall(new CallListEntry(direction, destLevelNum));
    }

    public JButton fetchButtonByNum(int num){
        return _panelNumberButtons.get(num);
    }
}
