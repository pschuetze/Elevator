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
public class CabinPanel extends Panel{
    public CabinPanel(int levelsNum){
        for (int i = levelsNum; i != 0; i--) {
            add(new JButton(String.valueOf(i)));

        }
    }
}
