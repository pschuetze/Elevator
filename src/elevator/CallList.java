/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;

import elevator.Globals.directionType;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author martin
 */
public class CallList {

    private SortedSet<Integer> callListUp = new TreeSet<Integer>();
    private SortedSet<Integer> callListDown = new TreeSet<Integer>();
    private directionType _currentDrive = directionType.UP;

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
//        System.out.println("next stop: " + getNextStop());
        return this;
    }

    /**
     *
     * @return
     */
    public int getNextStop(){
        return _currentDrive.equals(directionType.UP) ? callListUp.first() : callListDown.last();
    }
}
