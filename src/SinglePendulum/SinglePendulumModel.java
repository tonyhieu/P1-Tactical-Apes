package SinglePendulum;

import javax.swing.*;
import java.lang.Math;

import java.awt.geom.Point2D;

public class SinglePendulumModel {
    SinglePendulumView view;

    //environmental variables
    double airResistance;
    double g;

    //Pendulum variables
    double bobMass; //in kg
    double rodMass; // in kg
    double rodLength; // in cm
    double pivotFriction; //coefficient of friction , between 0 and 1
    double aAcc;
    double aVel;
    double a;

    //Point2D bobPos;
    double bobX;
    double bobY;

    public SinglePendulumModel(SinglePendulumView view) {

        new SinglePendulumModel(view,30,5.0,50,0,0,0,9.8);
    }

    public SinglePendulumModel(SinglePendulumView view,double a, double bobMass,double rodLength,double rodMass,double pivotFriction, double airResistance, double g) {
        this.view = view;


        this.a = Math.toRadians(a);
        this.bobMass = bobMass;
        this.rodLength = rodLength;

        this.rodMass = rodMass;
        this.pivotFriction = pivotFriction;

        this.airResistance = airResistance;
        this.g = g;

        this.bobX = 10*rodLength*Math.sin(this.a);
        this.bobY = 10*rodLength*Math.cos(this.a);



        //System.out.println(bobX+","+bobY);




    }
    public void update() {





        try {
            aAcc = (g/(rodLength/10))*Math.sin(a);
            Thread.sleep(3);
            aVel += aAcc;
            Thread.sleep(3);
            a += aVel;
            Thread.sleep(3);

            bobX = Math.sin(a) * rodLength;
            bobY = Math.cos(a) * rodLength;

        } catch (InterruptedException e) {
            String msg = String.format("Thread interrupted: %s", e.getMessage());

            JOptionPane.showMessageDialog(this.view.frame, msg, "Error",
                    JOptionPane.ERROR_MESSAGE);



        }


    }
}
