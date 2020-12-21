package DoublePendulum;

import java.util.*;

//this is going to be fun figuring out the physics for this.
//Where the calculations for the trajectory of the pendulum will take place
public class DoublePendulumModel {
    DoublePendulumControl control;
    ArrayList<Pendulum> pendulums;

    public DoublePendulumModel(DoublePendulumControl control) {
        //Might be unnecessary
        this.control = control;
    }

    public void addPendulum(int rodLength, int weightMass) {
        pendulums.add(new Pendulum(rodLength, weightMass));
    }
    public void addPendulum(int rodMass, int rodLength, int weightMass, int pivotFriction) {
        pendulums.add(new Pendulum(rodMass, rodLength, weightMass, pivotFriction));
    }
}

