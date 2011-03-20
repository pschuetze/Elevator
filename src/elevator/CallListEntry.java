/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;

import elevator.Globals.directionType;

/**
 *
 * @author martin
 */
public class CallListEntry {

    private directionType _direction;
    private int _destinationLevel;

    public CallListEntry(directionType direction, int destinationLevel) {
        _direction = direction;
        _destinationLevel = destinationLevel;
    }

    /**
     *
     * @param compareObject
     * @return
     */
    @Override
    public boolean equals(Object compareObject) {

        CallListEntry callListEntry;
        if (compareObject instanceof CallListEntry) {
            callListEntry = (CallListEntry) compareObject;
        } else {
            return false;
        }

        if (!getDirection().equals(callListEntry.getDirection())
                && getDestinationLevel() != callListEntry.getDestinationLevel()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash;
        hash = (this._direction != null ? this._direction.hashCode() : 0);
        hash = hash + this._destinationLevel;
        return hash;
    }

    /**
     * Get the value of _direction
     *
     * @return the value of _direction
     */
    public directionType getDirection() {
        return _direction;
    }

    /**
     * Set the value of _direction
     *
     * @param direction
     * @return CallListEntry
     */
    public CallListEntry setDirection(directionType direction) {
        this._direction = direction;
        return this;
    }

    /**
     * Get the value of destinationLevel
     *
     * @return the value of destinationLevel
     */
    public int getDestinationLevel() {
        return _destinationLevel;
    }

    /**
     * Set the value of destinationLevel
     *
     * @param destinationLevel new value of destinationLevel
     * @return CallListEntry
     */
    public CallListEntry setDestinationLevel(int destinationLevel) {
        this._destinationLevel = destinationLevel;
        return this;
    }
}
