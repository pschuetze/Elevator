/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;

import java.util.HashMap;
import javax.swing.JPanel;

/**
 *
 * @author martin
 */
public class Elevator extends JPanel {

    private int _levelsNum;
    private HashMap<Integer, Level> _levelsList = new HashMap<Integer, Level>();
    private int _elevatorNum;
    private Cabin _cabin;
    private CallList _callList = new CallList();

    public Elevator(int elevatorNum, int levelsNum) {
        Level level;

        setElevatorNum(elevatorNum).setLevels(levelsNum).setLayout(new java.awt.GridLayout(0, 1));

        _cabin = new Cabin(this);

        for (int i = _levelsNum; i != 0; i--) {
            level = new Level(i, this);
            _levelsList.put(i, level);
            add(level);
        }

        moveCabin(1);
    }

    public final void moveCabin(int destLevelNum) {
        Level desttLevelObj = fetchLevelByNum(destLevelNum);
        Level sourceLevelObj = fetchLevelByNum(_cabin.getCurrentLevel());

        desttLevelObj.toggleSparsePanel(false);
        if (sourceLevelObj != desttLevelObj) { // in case of initial move at startup don't reenable the sparsepanel
            sourceLevelObj.remove(_cabin);
            sourceLevelObj.toggleSparsePanel(true);
        }
        desttLevelObj.add(_cabin);
        repaint();

    }

    /**
     *
     * @param numLevel
     * @return Level
     */
    public final Level fetchLevelByNum(int numLevel) {

//        int listIndex = _levelsNum - numLevel; // inverting the level identifier to get the List index

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

    public CallList getCallList() {
        return _callList;
    }
}
