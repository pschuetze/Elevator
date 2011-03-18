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

    public Cabin(Elevator elevator){
        _cabinPanel = new CabinPanel(elevator.getLevels());
        add(_cabinPanel);
    }

    /**
     * @return the _cabinPanel
     */
    public CabinPanel getCabinPanel() {
        return _cabinPanel;
    }

}
