package DoublePendulum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoublePendulumControl {
    public static void main(String[] args) {
        DoublePendulumView DoublePendulumGUI = new DoublePendulumView();
        DoublePendulumGUI.startSimulation();
        System.out.println(DoublePendulumGUI.pendulum1Settings.get("mass"));




    }


}
