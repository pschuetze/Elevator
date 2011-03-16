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
    private int _levelsNum;
    private int _elevatorsNum;

    private Level[] _arrLevels;;
    private Elevator[] _arrElevators;

    public Building(int levels, int elevators){
        this.setLevels(levels)
                .setElevators(elevators);

        this._arrLevels = new Level[this._levelsNum];
        this._arrElevators  = new Elevator[this._elevatorsNum];

        for (int i = 0; i < this._arrLevels.length; i++) {
            this._arrLevels[i] = new Level(i);
        }

        for (int i = 0; i < this._arrElevators.length; i++){
            this._arrElevators[i] = new Elevator(i);
        }

    }



    /**
     * @return the _levelsNum
     */
    public int getLevels() {
        return _levelsNum;
    }

    /**
     * @param levels the _levelsNum to set
     */
    private Building setLevels(int levels) {
        this._levelsNum = levels;
        return this;
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
