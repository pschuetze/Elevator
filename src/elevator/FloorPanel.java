/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package elevator;

import javax.swing.JButton;

/**
 *
 * @author martin
 */
public class FloorPanel extends Panel{
    private Boolean _buttonUp = false;
    private Boolean _buttonDown = false;

    public FloorPanel(Globals.LevelKind levelKind){
        switch(levelKind){
            case LOWEST:
                    _buttonUp = true;
                    break;
            case BETWEEN:
                _buttonUp = true;
                _buttonDown = true;
                break;
            case HIGHEST:
                _buttonDown = true;
        }

        if(_buttonDown){
            add(new JButton("Down"));
        }
        if(_buttonUp){
            add(new JButton("Up"));
        }


    }

    /**
     * @return the _buttonUp
     */
    public Boolean getButtonUp() {
        return _buttonUp;
    }

    /**
     * @return the _buttonDown
     */
    public Boolean getButtonDown() {
        return _buttonDown;
    }


}
