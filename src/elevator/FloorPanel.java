/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;

import elevator.Globals.directionType;
import elevator.Globals.levelKind;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author martin
 */
public class FloorPanel extends Panel {

//    private Boolean _buttonUp = false;
//    private Boolean _buttonDown = false;
    private JButton _callButtonDown; // sollte mal noch in eiene eigene class, dann faellt das if im constructor weg
    private JButton _callButtonUp;
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
                _callButtonUp =  new JButton("Up");
                break;
            case BETWEEN:
                _callButtonDown =  new JButton("Down");
                _callButtonUp =  new JButton("Up");
                break;
            case HIGHEST:
                _callButtonDown =  new JButton("Down");;
        }

        if (_callButtonDown instanceof JButton) { // @TODO siehe var-definition
            _callButtonDown.addActionListener(_callButtonActionListener);
            add(_callButtonDown);
        }
        if (_callButtonUp instanceof JButton) {
            _callButtonUp.addActionListener(_callButtonActionListener);
            add(_callButtonUp);
        }
    }

    private void callButtonActionPerformed(ActionEvent evt) {
//        _elevator.moveCabin(_myLevelNum);
        directionType direction;

        if(_elevator.getCabin().getCurrentLevel() == _myLevelNum){
            return;
        }

        if(evt.getActionCommand().equals("Up")){
            direction = directionType.UP;
            _callButtonUp.setEnabled(false);
        }else{
            direction = directionType.DOWN;
            _callButtonDown.setEnabled(false);
        }
        _elevator.getCallList().addCall(new CallListEntry(direction, _myLevelNum));
//        return; // for breakpoint only
    }

    /**
     *
     * @return
     */
    public JButton getCallButtonDown() {
        return _callButtonDown;
    }
    
    /**
     *
     * @return
     */
    public JButton getCallButtonUp() {
        return _callButtonUp;
    }
}
