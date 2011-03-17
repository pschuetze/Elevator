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
public class Bootstrap {

    public static Building init(int levels, int elevators){
         Building building = new Building(levels, elevators);
         System.out.println("init succesfully");
         return building;
    }
}
