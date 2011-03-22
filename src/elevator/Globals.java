/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package elevator;

import java.util.NoSuchElementException;
import java.util.SortedSet;

/**
 *
 * @author martin
 */
public class Globals {
    public static int levels;
    public static int elevators;
    public enum levelKind {HIGHEST,LOWEST,BETWEEN};
    public enum directionType {UP,DOWN,STANDBY};

    public static int popSortedSetInt(SortedSet<Integer> set, boolean left, boolean right) {
        int value = 0;

        if (!set.isEmpty()) {
            if (left) {
                value = set.first();
            }
            if (right) {
                value = set.last();
            }
            set.remove(value);
        } else {
            throw new NoSuchElementException("Can not pop value from empty set");
        }

        return value;
    }

}
