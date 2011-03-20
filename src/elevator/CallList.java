/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package elevator;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author martin
 */
public class CallList {
    private Set<CallListEntry> callList = new HashSet<CallListEntry>();

    public CallList add(CallListEntry callListEntry){
        callList.add(callListEntry);
        return this;
    }


}
