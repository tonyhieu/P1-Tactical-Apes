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
        double g = simSettings.get("gravity")/9.8;
        double l1 = pendulum1Settings.get("length"); // length of first pendulum
        double l2 = pendulum2Settings.get("length"); // length of second pendulum
        double m1 = pendulum1Settings.get("mass"); //  mass of first pendulum excluding weight of string
        double m2 = pendulum2Settings.get("mass"); // mass of second pendulum excluding weight of string
        double t1 = pendulum1Settings.get("angle");// angle formed by first pendulum and normal - angle1
        double t2 = pendulum2Settings.get("angle"); //angle formed by second pendulum and normal - angle2
        double a1_v = pendulum1Settings.get("velocity"); //angular velocity of pendulum1
        double a2_v = pendulum2Settings.get("velocity"); //angular velocity of pendulum2



        double num1 = -g * (2 * m1 + m2) * Math.sin(t1);
        double num2 = -m2 * g * Math.sin(t1-2*t2);
        double num3 = -2*Math.sin(t1-t2)*m2;
        double num4 = a2_v*a2_v*l2+a1_v*a1_v*l1*Math.cos(t1-t2);
        double den = l1 * (2*m1+m2-m2*Math.cos(2*t1-2*t2));
        double a1_a = (num1 + num2 + num3*num4) / den; //Split up the fraction into different parts

        num1 = 2 * Math.sin(t1-t2);
        num2 = (a1_v*a1_v*l1*(m1+m2));
        num3 = g * (m1 + m2) * Math.cos(t1);
        num4 = a2_v*a2_v*l2*m2*Math.cos(t1-t2);
        den = l2 * (2*m1+m2-m2*Math.cos(2*t1-2*t2));
        double a2_a = (num1*(num2+num3+num4)) / den; //Split up the fraction into different parts

        //Need to update values and and update the hash map with the calculated values

        a1_v += a1_a;
        a2_v += a2_a;
        t1 += a1_v;
        t2 += a2_v;

        pendulum1Settings.put("angle", t1);// angle formed by first pendulum and normal - angle1
        pendulum2Settings.put("angle", t2); //angle formed by second pendulum and normal - angle2
        pendulum1Settings.put("velocity", a1_v);; //angular velocity of pendulum1
        pendulum1Settings.put("velocity", a2_v); //angular velocity of pendulum2
    }


}
