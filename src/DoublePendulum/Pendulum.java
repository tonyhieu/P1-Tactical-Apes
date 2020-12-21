package DoublePendulum;

public class Pendulum {
    int rodMass;
    int rodLength;
    int weightMass;
    int pivotFriction;
    int totalMass;

    //constructor for Ideal Pendulum
    public Pendulum(int rodLength,int weightMass) {
        new Pendulum(0,rodLength,weightMass, 0);
    }


    public Pendulum(int rodMass, int rodLength, int weightMass, int pivotFriction) {
        this.rodMass = rodMass;
        this.rodLength = rodLength;
        this.weightMass = weightMass;
        this.pivotFriction = pivotFriction;
        this.totalMass = rodMass+weightMass;
    }




}
