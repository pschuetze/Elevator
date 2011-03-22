/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package elevator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author martin
 */
public class Building extends javax.swing.JPanel{
    
    private int _elevatorsNum;
    private List<Elevator> _elevatorsList;

    public Building(int levels, int elevators, Controls controls){
        Elevator elevator;
        _elevatorsList  = new ArrayList<Elevator>();

        setElevators(elevators);

        setLayout(new java.awt.GridLayout(1, 0));

        for (int i = 0; i < _elevatorsNum; i++){
            elevator = new Elevator(i, levels, controls);
            _elevatorsList.add(elevator);
            add(elevator); //adding new elevator to JPanel building
        }
    }

    /**
     * @return the _elevatorsNum
     */
    public int getElevators() {
        return _elevatorsNum;
    }

    /**
     * @param elevators the _elevatorsNum to set
     */
    private Building setElevators(int elevators) {
        this._elevatorsNum = elevators;
        return this;
    }

    /**
     *
     * @param numElevator
     * @return Elevator
     */
    public Elevator fetchElevatorByNum(int numElevator) {
        return _elevatorsList.get(numElevator);
    }
}
