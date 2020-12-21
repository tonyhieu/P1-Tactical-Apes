package DoublePendulum;


//This is used in DoublePendulumControl so that it updates each time the user enters values into the Pendulum Menus.
//This is opposed to the normal Pendulum class, which may be replaced with this class to eliminate redundancy
//The main difference is that this class has setters, while the normal Pendulum class does not.
public class PendulumBuilder extends Pendulum {

    public PendulumBuilder() {
        super(0,0,0,0);
    }

    public void setRodMass(int rodMass) {
        this.rodMass = rodMass;
    }
    public void setRodLength(int rodLength) {
        this.rodLength = rodLength;
    }
    public void setWeightMass(int weightMass) {
        this.weightMass = weightMass;
    }
    public void setPivotFriction(int pivotFriction) {
        this.pivotFriction = pivotFriction;
    }

}
