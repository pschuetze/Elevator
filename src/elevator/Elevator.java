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
        _cabin = new Cabin();
        _levelsList = new ArrayList<Level>();
        Level level;

        setElevatorNum(elevatorNum)
                .setLevels(levelsNum);

        setLayout(new java.awt.GridLayout(0, 1));

        for (int i = 0; i < _levelsNum; i++) {
            level = new Level(i, this);
            _levelsList.add(level);
            add(level);
        }
    }

    /**
     *
     * @param numLevel
     * @return Level
     */
    public Level fetchLevelByNum(int numLevel) {
        return _levelsList.get(numLevel);
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
