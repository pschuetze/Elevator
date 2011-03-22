/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;

import elevator.Globals.directionType;
import java.util.NoSuchElementException;
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

        if(_currentDrive.equals(directionType.STANDBY))
            _currentDrive = callListEntry.getDirection();

        updateCallListArea();

        return this;
    }

    public int popSortedSetInt(SortedSet<Integer> set, boolean left, boolean right, boolean toggleButtons) {
        int value = 0;

        if (!set.isEmpty()) {
            if (left) {
                value = set.first();
            }
            if (right) {
                value = set.last();
            }

            if (toggleButtons) {
                removeEntry(value, null);
            } else {
                set.remove(value);
            }
        } else {
            throw new NoSuchElementException("Can not pop value from empty set");
        }

        return value;
    }

    /**
     *
     * @return
     */
    public int getNextStop() {
        int next;
        checkAndToggleDirection();

        switch (_currentDrive) {
            case UP:
                next = popSortedSetInt(callListUp, true, false, true);
                if (!callListDown.isEmpty() && next == callListDown.last()) { // damit die cabin beim wechsel der liste nicht zweimal auf dem selben level haelt
                    removeEntry(callListDown.last(), directionType.DOWN);
                }
                return next;
            case DOWN:
                next = popSortedSetInt(callListDown, false, true, true);

                if (!callListUp.isEmpty() && next == callListUp.first()) { // damit die cabin beim wechsel der liste nicht zweimal auf dem selben level haelt
                    removeEntry(callListUp.first(), directionType.UP);
                }
                return next;
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

    public void removeEntry(int value, directionType directionType) {
        directionType = directionType instanceof directionType ? directionType : getCurrentDrive();

        SortedSet<Integer> callList = directionType.equals(Globals.directionType.UP)
                ? callListUp : callListDown;
        callList.remove(value);

        _elevator.fetchLevelByNum(value).getFloorPanel().enableButton(directionType);
    }

    public final void updateCallListArea() {
//        callListTextArea.setText(toString());
        callListTextArea.append(toString());
    }
}
