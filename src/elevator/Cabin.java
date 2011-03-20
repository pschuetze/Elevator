/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package elevator;

import javax.swing.JPanel;

/**
 *
 * @author martin
 */
public class Cabin extends JPanel{
    private CabinPanel _cabinPanel;
    private int _currentLevel = 1;

    public Cabin(Elevator elevator){
        _cabinPanel = new CabinPanel(elevator);
        add(_cabinPanel);

    }

    /**
     * @return the _cabinPanel
     */
    public CabinPanel getCabinPanel() {
        return _cabinPanel;
    }

    public int getCurrentLevel() {
        return _currentLevel;
    }

    public Cabin setCurrentLevel(int _currentLevel) {
        this._currentLevel = _currentLevel;
        return this;
    }

}
