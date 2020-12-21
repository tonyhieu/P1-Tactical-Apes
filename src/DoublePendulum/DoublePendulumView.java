package DoublePendulum;


import DeathGame.DeathGameView;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.lang.*;
import java.util.Hashtable;

public class DoublePendulumView {
    public JButton pendulum1;
    public JButton pendulum2;
    public JButton simulation;

    public static void main(String[] args) {
        DoublePendulumView DoublePendulum = new DoublePendulumView();
        DoublePendulum.startSimulation();
    }

    public void startSimulation(){

        //Initializing GUI that will let the user choose if they want to edit
        // pendulum 1, pendulum 2, or start the simulation.
        JFrame frame = new JFrame();
        JPanel startPanel = new JPanel();
        JButton pendulum1 = new JButton("Edit properties of pendulum 1");
        JButton pendulum2 = new JButton("Edit properties of pendulum 2");
        JButton runSimulation = new JButton("Run Simulation");


        //Sets up frame and specifies properties
        frame.setSize(900, 900);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.add(startPanel);

        //Adds buttons to frame for user interaction
        startPanel.setLayout(null);
        startPanel.setPreferredSize(new Dimension(900,900));
        startPanel.add(pendulum1);
        startPanel.add(pendulum2);
        startPanel.add(runSimulation);

        //Specifies location and size of button on initial panel
        pendulum1.setBounds(50,50,800,100);
        pendulum2.setBounds(50,250,800,100);
        runSimulation.setBounds(250,500,400,200);

        //Button to open panel that will allow thee user to change
        //the properties of pendulum 1
        pendulum1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoublePendulumView configurePendulum1 = new DoublePendulumView();
                configurePendulum1.setPendulum1();
            }
        });


    }

    public void setPendulum1(){

        //Creates JFrame and JPanel for GUI

        JFrame pendulum1Frame = new JFrame();
        JPanel pendulum1Panel = new JPanel();

        JLabel title = new JLabel("Pendulum 1 Properties");
        JLabel massTitle = new JLabel("Enter the length of Pendulum 1 (in cm)");
        JLabel lengthTitle = new JLabel("Enter the mass of Pendulum 1 (in g)");

        JTextField pendulum1Length = new JTextField();
        JTextField pendulum1Mass = new JTextField();
        JButton setValues = new JButton("Click to set values");

        pendulum1Frame.setSize(800, 800);
        pendulum1Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pendulum1Frame.setVisible(true);
        pendulum1Frame.add(pendulum1Panel);

        pendulum1Panel.setLayout(null);
        pendulum1Panel.add(title);

        pendulum1Panel.add(pendulum1Length);
        pendulum1Panel.add(lengthTitle);
        pendulum1Panel.add(pendulum1Mass);
        pendulum1Panel.add(massTitle);

        title.setBounds(333,50,200,50);
        massTitle.setBounds(50, 150, 300, 50);
        pendulum1Mass.setBounds(300,150,200,50);
        pendulum1Length.setBounds(300,250,200,50);
        lengthTitle.setBounds(50, 250, 300, 50);


    }


}
