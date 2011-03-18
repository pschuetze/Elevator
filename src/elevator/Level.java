/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author martin
 */
public class Level extends JPanel {

    private int _levelNum;
    private FloorPanel _floorPanel;
    private Globals.LevelKind _kind;
    private JPanel _sparsePanel;

    public Level(int levelNum, Elevator elevator) {
        setLevelNum(levelNum);

        _sparsePanel = new JPanel();

        setLayout(new java.awt.GridLayout(1, 0));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        if (levelNum == 1) {
            _kind = Globals.LevelKind.LOWEST;
        } else if (levelNum == elevator.getLevels()) {
            _kind = Globals.LevelKind.HIGHEST;
        } else {
            _kind = Globals.LevelKind.BETWEEN;
        }

        _floorPanel = new FloorPanel(_kind);
        add(new JLabel("Level " + getLevelNum()));
        add(_floorPanel);
        add(_sparsePanel);

    }

    /**
     * 
     * @return
     */
    public JPanel getSparsePanel() {
        return _sparsePanel;
    }

    /**
     * @return the _levelNum
     */
    public final int getLevelNum() {
        return _levelNum;
    }

    /**
     * @param levelNum the _levelNum to set
     */
    private Level setLevelNum(int levelNum) {
        this._levelNum = levelNum;
        return this;
    }

    /**
     * @return the _floorPanel
     */
    public FloorPanel getFloorPanel() {
        return _floorPanel;
    }
}
