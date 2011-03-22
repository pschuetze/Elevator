/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author martin
 */
public class Drive {

    private Elevator _elevator;
    private Controls _controls;
    private boolean hold = false;
    private ActionListener stepActionListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            doStep();
        }
    };
    private ActionListener autoStepHoldActionListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            hold = hold ? false : true;
        }
    };
    private ActionListener autoStepButtonActionListener;

    public Drive(Controls controls, Elevator elevator) {
        this._elevator = elevator;
        this._controls = controls;

        _controls.stepButton.addActionListener(stepActionListener);
        _controls.holdButton.addActionListener(autoStepHoldActionListener);

        autoStepButtonActionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    autoStep(_controls.autoStepClockSeconds);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Drive.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        _controls.autoStepButton.addActionListener(autoStepButtonActionListener);
    }

    private void doStep() {
        CallList callList = _elevator.getCallList();
        int destination = callList.getNextStop();
//        FloorPanel floorPanel;

        if (destination == 0) {
            return;
        }

        _elevator.moveCabin(destination);
        _elevator.getCabin().getCabinPanel().fetchButtonByNum(destination).setEnabled(true);

        callList.updateCallListArea();

//        floorPanel = _elevator.fetchLevelByNum(destination).getFloorPanel();
//        if(callList.getCurrentDrive().equals(directionType.DOWN))
//            floorPanel.getCallButtonDown().setEnabled(true);
//
//        if(callList.getCurrentDrive().equals(directionType.UP))
//            floorPanel.getCallButtonUp().setEnabled(true);

    }

    public void autoStep(float clockSeconds) throws InterruptedException {
        Float clockMs = clockSeconds * 1000;
        long clock = clockMs.longValue();

        synchronized (this) {
            while (!hold) {
                doStep();
                wait(clock);
            }
        }
    }
}
