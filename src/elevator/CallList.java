/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;

import elevator.Globals.directionType;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.swing.JTextArea;

/**
 *
 * @author martin
 */
public class CallList {

    private SortedSet<Integer> callListUp = new TreeSet<Integer>();
    private SortedSet<Integer> callListDown = new TreeSet<Integer>();
    private directionType _currentDrive = directionType.UP;
    private JTextArea callListTextArea;
    private Elevator _elevator;

    public CallList(JTextArea callListTextArea, Elevator elevator) {
        this.callListTextArea = callListTextArea;
        this._elevator = elevator;
        updateCallListArea();
    }

    @Override
    public String toString() {
        String myString = "\n::::Elevator " + _elevator.getElevatorNum() + "::::\n"
                + "\t UP: " + callListUp.toString() + "\n"
                + "\t DOWN: " + callListDown.toString() + "\n"
                + "\t current direction: " + _currentDrive.toString();


        return myString;
    }

    public directionType getCurrentDrive() {
        return _currentDrive;
    }

    public CallList setCurrentDrive(directionType _currentDrive) {
        this._currentDrive = _currentDrive;
        return this;
    }

    public CallList addCall(CallListEntry callListEntry) {

        if (callListEntry.getDirection().equals(directionType.UP)) {
            callListUp.add(callListEntry.getDestinationLevel());
        } else {
            callListDown.add(callListEntry.getDestinationLevel());
        }

        updateCallListArea();

//        System.out.println(getNextStop());

        return this;
    }

    /**
     *
     * @return
     */
    public int getNextStop() {
        checkAndToggleDirection();

        switch (_currentDrive) {
            case UP:
                return Globals.popSortedSetInt(callListUp, true, false);
            case DOWN:
                return Globals.popSortedSetInt(callListDown, false, true);
            case STANDBY:
                return 0;
            default:
                return 0;
        }
    }

    /**
     * 
     */
    private void checkAndToggleDirection() {
        if (callListDown.isEmpty() && callListUp.isEmpty()) {
            _currentDrive = directionType.STANDBY;
            return;
        }
        if (callListDown.isEmpty()) {
            _currentDrive = directionType.UP;
        }
        if (callListUp.isEmpty()) {
            _currentDrive = directionType.DOWN;
        }
    }

    public final void updateCallListArea(){
//        callListTextArea.setText(toString());
        callListTextArea.append(toString());
    }
}
