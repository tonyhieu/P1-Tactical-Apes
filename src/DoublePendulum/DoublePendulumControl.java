package DoublePendulum;

import java.lang.Math;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


public class DoublePendulumControl {


    public static void test(){
        DoublePendulumView DoublePendulumGUI = new DoublePendulumView();
        DoublePendulumGUI.pendulum1Settings.put("mass", DoublePendulumGUI.pendulum1Settings.get("mass") * 0.9);
    }

    public static void main(String[] args) {
        DoublePendulumView DoublePendulumGUI = new DoublePendulumView();
        DoublePendulumGUI.startSimulation();

        System.out.println(DoublePendulumGUI.pendulum1Settings.get("mass"));
    }

    public static void calculateFrame(HashMap<String, Double> pendulum1Settings, HashMap<String, Double> pendulum2Settings, HashMap<String, Double> simSettings){
        double g = simSettings.get("gravity");

        //double num1 = -g * (2 * m1 + m2) * sin(a1);
        //double num2 = -m2 * g * sin(a1-2*a2);
        //double num3 = -2*sin(a1-a2)*m2;
        //double num4 = a2_v*a2_v*r2+a1_v*a1_v*r1*cos(a1-a2);
        //double den = r1 * (2*m1+m2-m2*cos(2*a1-2*a2));
        //double a1_a = (num1 + num2 + num3*num4) / den;


    }


}
