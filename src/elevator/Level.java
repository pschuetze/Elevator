/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package elevator;

/**
 *
 * @author martin
 */
public class Level {

    private int _levelNum;
    private FloorPanel _floorPanel;
    private Globals.LevelKind _kind;

    public Level(int levelNum){
        this.setLevelNum(levelNum);

        if(levelNum == 0){
            this._kind = Globals.LevelKind.LOWEST;
        }else if(levelNum == (Globals.levels -1)){
            this._kind = Globals.LevelKind.HIGHEST;
        }else{
            this._kind = Globals.LevelKind.BETWEEN;
        }

        this._floorPanel = new FloorPanel(this._kind);

    }

    /**
     * @return the _levelNum
     */
    public int getLevelNum() {
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
