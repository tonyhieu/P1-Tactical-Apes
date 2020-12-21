package DoublePendulum;

import java.util.*;

//Links MVC together
public class DoublePendulumMain {
    DoublePendulumControl control;
    DoublePendulumModel model;
    DoublePendulumView view;

    public DoublePendulumMain() {
        control = new DoublePendulumControl(model,view);
        view = new DoublePendulumView(control);
        model = new DoublePendulumModel(control);

    }

    public static void main(String[] args) {

    }

    //necessary methods across MVC to start game
    public void start() {
        this.view.menu();
    }

}
