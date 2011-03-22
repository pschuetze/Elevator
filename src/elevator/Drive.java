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
public class Drive implements Runnable {

    private Elevator _elevator;
    private Controls _controls;
    private boolean hold = false;
    private float clockSeconds;
    private boolean whileAnchor = false;
    private ActionListener stepActionListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            doStep();
        }
    };
    private ActionListener autoStepHoldActionListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            holdButtonAction();
        }
    };
    private ActionListener autoStepButtonActionListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            autoStepButtonAction();
        }
    };

    public Drive(Controls controls, Elevator elevator) {
        this._elevator = elevator;
        this._controls = controls;
        
        _controls.stepButton.addActionListener(stepActionListener);
        _controls.holdButton.addActionListener(autoStepHoldActionListener);
        _controls.autoStepButton.addActionListener(autoStepButtonActionListener);
    }

    private void holdButtonAction(){
        hold = hold ? false : true;
            if (hold) {
                _controls.holdButton.setText("Release");
            } else {
                _controls.holdButton.setText("Hold");
            }
    }

    private void autoStepButtonAction() {
        this.clockSeconds = Float.parseFloat(_controls.autoStepClockSeconds.getValue().toString());

        whileAnchor = whileAnchor ? false : true;

        if (whileAnchor) {
            _controls.holdButton.setEnabled(true);
            _controls.autoStepButton.setText("Stop Autostep");
            new Thread(this).start();
        }else{
            _controls.holdButton.setEnabled(false);
            _controls.autoStepButton.setText("Start Autostep");
        }
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

        if (clock < 100) {
            throw new RuntimeException("minimum autoStep clock: 100 ms, given: " + clock);
        }

        while (whileAnchor) {
            if (!hold) {
                doStep();
            }
            Thread.sleep(clock);
        }
        whileAnchor = false;
    }

    @Override
    public void run() {
        try {
            autoStep(clockSeconds);
        } catch (InterruptedException ex) {
            Logger.getLogger(Drive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
