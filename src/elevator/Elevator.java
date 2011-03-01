/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package elevator;

/**
 *
 * @author martin
 */
public class Elevator {
    private int _elevatorNum;
    private Cabin _cabin;

    public Elevator(int elevatorNum){
        this.setElevatorNum(elevatorNum);
        this._cabin = new Cabin();
    }

    /**
     * @return the _elevatorNum
     */
    public int getElevatorNum() {
        return _elevatorNum;
    }

    /**
     * @param elevatorNum the _elevatorNum to set
     */
    private Elevator setElevatorNum(int elevatorNum) {
        this._elevatorNum = elevatorNum;
        return this;
    }

    /**
     * @return the _cabin
     */
    public Cabin getCabin() {
        return _cabin;
    }



}
