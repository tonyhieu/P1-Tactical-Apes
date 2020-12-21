package DoublePendulum;
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
import java.util.HashMap;

public class DoublePendulumView {
    public JButton pendulum1;
    public JButton pendulum2;
    public JButton simulation;
    public static HashMap<String, Double> pendulum1Settings = new HashMap<String, Double>();
    public static HashMap<String, Double> pendulum2Settings = new HashMap<String, Double>();
    public static HashMap<String, Double> simulationSettings = new HashMap<String, Double>();


    public static void main(String[] args) {
        DoublePendulumView DoublePendulum = new DoublePendulumView();
        DoublePendulum.startSimulation();
    }

    public void startSimulation() {

        //Initializing GUI that will let the user choose if they want to edit
        // pendulum 1, pendulum 2, or start the simulation.
        JFrame frame = new JFrame();
        JPanel startPanel = new JPanel();
        JButton pendulum1 = new JButton("Edit properties of pendulum 1");
        JButton pendulum2 = new JButton("Edit properties of pendulum 2");
        JButton globalSettings = new JButton("Edit global properties (like gravity)");
        JButton runSimulation = new JButton("Run Simulation");


        //Sets up frame and specifies properties
        frame.setSize(900, 900);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.add(startPanel);

        //Adds buttons to frame for user interaction
        startPanel.setLayout(null);
        startPanel.setPreferredSize(new Dimension(900, 900));
        startPanel.add(pendulum1);
        startPanel.add(pendulum2);
        startPanel.add(globalSettings);
        startPanel.add(runSimulation);

        //Specifies location and size of button on initial panel
        pendulum1.setBounds(50, 50, 800, 100);
        pendulum2.setBounds(50, 200, 800, 100);
        globalSettings.setBounds(50, 350, 800, 100);
        runSimulation.setBounds(350, 500, 200, 200);


        pendulum1Settings.put("mass", 1.0);
        pendulum1Settings.put("length", 1.0);



        pendulum2Settings.put("mass", 1.0);
        pendulum2Settings.put("length", 1.0);

        simulationSettings.put("gravity", 9.80);


        //Button to open panel that will allow thee user to change
        //the properties of pendulum 1
        pendulum1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoublePendulumView configurePendulum1 = new DoublePendulumView();
                configurePendulum1.setPendulum1();
            }
        });

        //Button to open panel that will allow thee user to change
        //the properties of pendulum 2
        pendulum2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoublePendulumView configurePendulum2 = new DoublePendulumView();
                configurePendulum2.setPendulum2();
            }
        });

        globalSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoublePendulumView configureGlobalSettings = new DoublePendulumView();
                configureGlobalSettings.setGlobal();
            }
        });


    }

    public void setPendulum1() {

        //Creates JFrame and JPanel for GUI

        JFrame pendulum1Frame = new JFrame();
        JPanel pendulum1Panel = new JPanel();

        JLabel title = new JLabel("Pendulum 1 Properties");
        JLabel massTitle = new JLabel("Enter the length of Pendulum 1 (in cm):");
        JLabel lengthTitle = new JLabel("Enter the mass of Pendulum 1 (in g):");

        JTextField pendulum1Length = new JTextField(Double.toString(pendulum1Settings.get("length")));
        JTextField pendulum1Mass = new JTextField(Double.toString(pendulum1Settings.get("mass")));
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
        pendulum1Panel.add(setValues);

        title.setBounds(333, 50, 200, 50);
        massTitle.setBounds(50, 150, 300, 50);
        pendulum1Mass.setBounds(300, 150, 200, 50);
        pendulum1Length.setBounds(300, 250, 200, 50);
        lengthTitle.setBounds(50, 250, 300, 50);
        setValues.setBounds(300, 550, 200, 75);

        setValues.addActionListener(e -> {
            pendulum1Settings.put("mass", Double.parseDouble(pendulum1Mass.getText()));
            pendulum1Settings.put("length", Double.parseDouble(pendulum1Length.getText()));
            pendulum1Frame.dispose();
        });
    }

    public void setPendulum2() {

        //Creates JFrame and JPanel for GUI

        JFrame pendulum2Frame = new JFrame();
        JPanel pendulum2Panel = new JPanel();

        JLabel title = new JLabel("Pendulum 2 Properties");
        JLabel massTitle = new JLabel("Enter the length of Pendulum 2 (in cm):");
        JLabel lengthTitle = new JLabel("Enter the mass of Pendulum 2 (in g):");

        JTextField pendulum2Length = new JTextField(Double.toString(pendulum2Settings.get("length")));
        JTextField pendulum2Mass = new JTextField(Double.toString(pendulum2Settings.get("mass")));
        JButton setValues = new JButton("Click to set values");

        pendulum2Frame.setSize(800, 800);
        pendulum2Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pendulum2Frame.setVisible(true);
        pendulum2Frame.add(pendulum2Panel);

        pendulum2Panel.setLayout(null);
        pendulum2Panel.add(title);

        pendulum2Panel.add(pendulum2Length);
        pendulum2Panel.add(lengthTitle);
        pendulum2Panel.add(pendulum2Mass);
        pendulum2Panel.add(massTitle);
        pendulum2Panel.add(setValues);

        title.setBounds(333, 50, 200, 50);
        massTitle.setBounds(50, 150, 300, 50);
        pendulum2Mass.setBounds(300, 150, 200, 50);
        pendulum2Length.setBounds(300, 250, 200, 50);
        lengthTitle.setBounds(50, 250, 300, 50);
        setValues.setBounds(300, 550, 200, 75);

        setValues.addActionListener(e -> {
            pendulum2Settings.put("mass", Double.parseDouble(pendulum2Mass.getText()));
            pendulum2Settings.put("length", Double.parseDouble(pendulum2Length.getText()));
            pendulum2Frame.dispose();
        });
    }


    public void setGlobal() {

        JFrame globalFrame = new JFrame();
        JPanel globalPanel = new JPanel();

        JLabel title = new JLabel("Global Properties and Simulation Settings");
        JLabel gravityTitle = new JLabel("Enter gravitational constant (in m/s^2):");

        JTextField gravity = new JTextField(Double.toString(simulationSettings.get("gravity")));
        JButton setValues = new JButton("Click to set values");

        globalFrame.setSize(800, 800);
        globalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        globalFrame.setVisible(true);
        globalFrame.add(globalPanel);

        globalPanel.setLayout(null);
        globalPanel.add(title);
        globalPanel.add(gravityTitle);
        globalPanel.add(gravity);
        globalPanel.add(setValues);

        title.setBounds(275, 50, 400, 50);
        gravityTitle.setBounds(50, 150, 300, 50);
        gravity.setBounds(300, 150, 200, 50);
        setValues.setBounds(300, 550, 200, 75);

        setValues.addActionListener(e -> {
            simulationSettings.put("gravity", Double.parseDouble(gravity.getText()));
            globalFrame.dispose();
        });
    }


}
