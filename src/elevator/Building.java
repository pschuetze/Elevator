/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package elevator;

/**
 *
 * @author martin
 */
public class Building {
    private int _levels;
    private int _elevators;

    private Level[] _arrLevels;;
    private Elevator[] _arrElevators;

    public Building(int levels, int elevators){
        this.setLevels(levels)
                .setElevators(elevators);

        this._arrLevels = new Level[this._levels];
        this._arrElevators  = new Elevator[this._elevators];

        for (int i = 0; i < this._arrLevels.length; i++) {
            this._arrLevels[i] = new Level(i);
        }

        for (int i = 0; i < this._arrElevators.length; i++){
            this._arrElevators[i] = new Elevator(i);
        }

    }



    /**
     * @return the _levels
     */
    public int getLevels() {
        return _levels;
    }

    /**
     * @param levels the _levels to set
     */
    private Building setLevels(int levels) {
        this._levels = levels;
        return this;
    }

    /**
     * @return the _elevators
     */
    public int getElevators() {
        return _elevators;
    }

    /**
     * @param elevators the _elevators to set
     */
    private Building setElevators(int elevators) {
        this._elevators = elevators;
        return this;
    }

    /**
     *
     * @param numLevel
     * @return Level
     */
    public Level fetchLevelByNum(int numLevel) {
        return _arrLevels[numLevel];
    }

    /**
     *
     * @param numElevator
     * @return Elevator
     */
    public Elevator fetchElevatorByNum(int numElevator) {
        return _arrElevators[numElevator];
    }
}
