/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package elevator;

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
                    this._buttonUp = true;
                    break;
            case BETWEEN:
                this._buttonUp = true;
                this._buttonDown = true;
                break;
            case HIGHEST:
                this._buttonDown = true;
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
