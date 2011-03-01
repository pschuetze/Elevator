/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package elevator;

/**
 *
 * @author martin
 */
public class Cabin {
    private CabinPanel _cabinPanel;

    public Cabin(){
        this._cabinPanel = new CabinPanel();
    }

    /**
     * @return the _cabinPanel
     */
    public CabinPanel getCabinPanel() {
        return _cabinPanel;
    }

}
