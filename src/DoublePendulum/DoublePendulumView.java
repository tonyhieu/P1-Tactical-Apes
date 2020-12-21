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

import java.util.*;


//The code for managing the UI.
public class DoublePendulumView {
    public JButton addPendulum;
    public ArrayList<JButton> pendulumButtonList = new ArrayList<JButton>();
    //public JButton simulation;
    public JPanel startPanel;
    public DoublePendulumControl control;

    public DoublePendulumView(DoublePendulumControl control) {
        this.control = control;
    }

    public static void main(String[] args) {

    }

    //start menu
    public void menu(){

        //Initializing GUI that will let the user choose if they want to edit
        JFrame frame = new JFrame();
        startPanel = new JPanel();



        addPendulum = new JButton("Add a pendulum");

        
        JButton globalSettings = new JButton("Edit global properties (like gravity)");
        JButton runSimulation = new JButton("Run Simulation");


        //Sets up frame and specifies properties
        frame.setSize(900, 900);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.add(startPanel);

        //Adds buttons to frame for user interaction
        startPanel.setLayout(null);
        startPanel.setPreferredSize(new Dimension(900,900));
        startPanel.add(addPendulum);
        startPanel.add(globalSettings);
        startPanel.add(runSimulation);

        //Specifies location and size of button on initial panel
        addPendulum.setBounds(10,50,800,100);
        globalSettings.setBounds(50,350,800,100);
        runSimulation.setBounds(350,500,200,200);

        addPendulum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.addPendulumInfo();
                addPendulumButton();
            }
        });

        globalSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                globalPropertiesMenu();
            }
        });


    }

    public void addPendulumButton() {
        //to get index of pendulumbutton, subtract 1
        int pendulumNumber = pendulumButtonList.size()+1;

        pendulumButtonList.add( new JButton("Edit Pendulum "+Integer.toString(pendulumNumber) ) );

        JButton pendulumButton = pendulumButtonList.get(pendulumNumber-1);

        startPanel.add(pendulumButton);

        pendulumButton.setBounds(10,175,800,100);

        pendulumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pendulumMenu(pendulumNumber);
            }
        });
    }
    public void pendulumMenu(int pendulumNumber) {

        int pendulumIndex = pendulumNumber-1;
        PendulumBuilder pendulumInfo = control.pendulumsInfo.get(pendulumIndex);
        //Creates JFrame and JPanel for GUI

        JFrame pendulumFrame = new JFrame();
        JPanel pendulumPanel = new JPanel();

        JLabel title = new JLabel("Pendulum " + Integer.toString(pendulumNumber));
        JLabel rodLengthTitle = new JLabel("Enter the length of the rod (cm):");
        JLabel weightMassTitle = new JLabel("Enter the mass of the weight (in g):");

        JTextField pendulumRodLength = new JTextField(Integer.toString(pendulumInfo.rodLength));

        pendulumRodLength.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pendulumInfo.setRodLength(Integer.parseInt(pendulumRodLength.getText()));
            }
        });

        JTextField pendulumWeightMass = new JTextField(Integer.toString(pendulumInfo.weightMass));

        pendulumWeightMass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pendulumInfo.setWeightMass((Integer.parseInt(pendulumWeightMass.getText())));
            }
        });

        JButton setValues = new JButton("Enter Pendulum Properties");

        pendulumFrame.setSize(800, 800);
        pendulumFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pendulumFrame.setVisible(true);
        pendulumFrame.add(pendulumPanel);

        pendulumPanel.setLayout(null);
        pendulumPanel.add(title);

        pendulumPanel.add(pendulumRodLength);
        pendulumPanel.add(rodLengthTitle);
        pendulumPanel.add(weightMassTitle);
        pendulumPanel.add(pendulumWeightMass);
        pendulumPanel.add(setValues);

        title.setBounds(333,50,200,50);
        weightMassTitle.setBounds(50, 150, 300, 50);
        pendulumWeightMass.setBounds(300,150,200,50);
        pendulumRodLength.setBounds(300,250,200,50);
        rodLengthTitle.setBounds(50, 250, 300, 50);
        setValues.setBounds(300,550, 200,75);
    }


    public void globalPropertiesMenu(){

        JFrame globalFrame = new JFrame();
        JPanel globalPanel = new JPanel();

        JLabel title = new JLabel("Global Properties and Simulation Settings");
        JLabel gravityTitle = new JLabel("Enter gravitational constant (in m/s^2):");

        JTextField gravity = new JTextField();
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

        title.setBounds(275,50,400,50);
        gravityTitle.setBounds(50, 150, 300, 50);
        gravity.setBounds(300,150,200,50);
        setValues.setBounds(300,550, 200,75);
    }


}
