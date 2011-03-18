/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author martin
 */
public class Elevator extends JPanel{

    private int _levelsNum;
    private List<Level> _levelsList;
    private int _elevatorNum;
    private Cabin _cabin;

    public Elevator(int elevatorNum, int levelsNum) {
        Level level;

        setElevatorNum(elevatorNum)
                .setLevels(levelsNum)
                .setLayout(new java.awt.GridLayout(0, 1));

        _cabin = new Cabin(this);
        _levelsList = new ArrayList<Level>();

        for (int i = _levelsNum; i != 0; i--) {
            level = new Level(i, this);
            _levelsList.add(level);
            add(level);
        }

        Level firstLevel = fetchLevelByNum(1);
        firstLevel.remove(firstLevel.getSparsePanel());
        firstLevel.add(_cabin);
    }

    /**
     *
     * @param numLevel
     * @return Level
     */
    public final Level fetchLevelByNum(int numLevel) {

        int listIndex = _levelsNum - numLevel; // inverting the level identifier to get the List index

        return _levelsList.get(listIndex);
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
    private Elevator setLevels(int levels) {
        _levelsNum = levels;
        return this;
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
