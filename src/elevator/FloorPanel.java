/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;

import elevator.Globals.levelKind;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author martin
 */
public class FloorPanel extends Panel {

    private Boolean _buttonUp = false;
    private Boolean _buttonDown = false;
    private int _myLevelNum;
    private Elevator _elevator;
    private ActionListener _callButtonActionListener = new java.awt.event.ActionListener() {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            callButtonActionPerformed(evt);
        }
    };

    public FloorPanel(levelKind levelKind, Elevator elevator, int mylevelNum) {
        _myLevelNum = mylevelNum;
        _elevator = elevator;

        switch (levelKind) {
            case LOWEST:
                _buttonUp = true;
                break;
            case BETWEEN:
                _buttonUp = true;
                _buttonDown = true;
                break;
            case HIGHEST:
                _buttonDown = true;
        }

        if (_buttonDown) {
            JButton callButtonDown = new JButton("Down");
            callButtonDown.addActionListener(_callButtonActionListener);
            add(callButtonDown);
        }
        if (_buttonUp) {
            JButton callButtonUp = new JButton("Up");
            callButtonUp.addActionListener(_callButtonActionListener);
            add(callButtonUp);
        }
    }

    private void callButtonActionPerformed(ActionEvent evt) {
        _elevator.moveCabin(_myLevelNum);
    }

    /**
     * @return the _buttonUp
     */
    public Boolean getButtonUp() {
        return _buttonUp;
    }

    /**
     * @return the _buttonDown
     */
    public Boolean getButtonDown() {
        return _buttonDown;
    }
}
