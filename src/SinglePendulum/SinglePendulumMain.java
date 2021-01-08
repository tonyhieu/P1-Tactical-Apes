package SinglePendulum;

import javax.swing.*;
import java.awt.EventQueue;

public class SinglePendulumMain {
    SinglePendulumModel model;
    SinglePendulumView view;
    SinglePendulumControl control;

    public SinglePendulumMain() {
        model = new SinglePendulumModel(view);
        view = new SinglePendulumView(model);
        control = new SinglePendulumControl();

    }




}
