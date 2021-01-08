package DeathGame;

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
import java.util.*;


public class DeathGameView {
    public JButton participant1;
    public JButton participant2;
    public JButton participant3;
    public JButton startSimulation;
    public JScrollPane Scroller;
    public static int p1intel;
    public static int p1str;
    public static int p1soc;
    public static int p1emp;
    int p2intel;
    int p2str;
    int p2soc;
    int p2emp;
    int p3intel;
    int p3str;
    int p3soc;
    int p3emp;

    public static void main(String[] args) {
        DeathGameView initialize = new DeathGameView();
        initialize.RunDeathGameView();
    }
    public void RunDeathGameView() {
        //initialize variables
        JFrame frame = new JFrame();
        JPanel startPanel = new JPanel();
        JButton participant1 = new JButton("Participant 1");
        JButton participant2 = new JButton("Participant 2");
        JButton participant3 = new JButton("Participant 3");
        JButton startSimulation = new JButton("Start Simulation");



        //JScrollPane Scroller = new JScrollPane(startPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //Scroller.setEnabled(true);
        //Scroller.setSize(500,500);
        //Scroller.setPreferredSize(new Dimension(100,100));
        //Scroller.setVisible(true);

        //Scroller.getViewport().setPreferredSize(new Dimension(900, 900));


        //Dimensions and properties of frame
        frame.setSize(900, 900);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        //frame.add(Scroller);
        frame.add(startPanel);
        //frame.add(BorderLayout.CENTER, new JScrollPane(startPanel));

        //Panel adds objects to view
        startPanel.setLayout(null);
        startPanel.setPreferredSize(new Dimension(900,900));
        startPanel.add(participant1);
        startPanel.add(participant2);
        startPanel.add(participant3);
        startPanel.add(startSimulation);
        //startPanel.add(Scroller);

        //Set bounds for buttons
        participant1.setBounds(50,50,800,100);
        participant2.setBounds(50,200,800,100);
        participant3.setBounds(50,350,800,100);
        startSimulation.setBounds(350,500,200,200);
        //Scroller.setBounds(850,0,50,200);

        //Logic for buttons pressed
        participant1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeathGameView secondview = new DeathGameView();
                secondview.SecondView();
            }
        });
        participant2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeathGameView secondview = new DeathGameView();
                secondview.SecondView();
            }
        });
        participant3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeathGameView secondview = new DeathGameView();
                secondview.SecondView();
            }
        });
        /*startSimulation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               frame.dispose();
            }
        });*/


    }
    public void SecondView() {
        //initialize frame and panel
        JFrame frame2 = new JFrame();
        JPanel secondPanel = new JPanel();

        //set name
        JLabel name = new JLabel("Name");
        JTextField enterName = new JTextField("Enter name");

        //set intelligence and initialize hashtable
        JLabel intelligence = new JLabel("Intelligence");
        JSlider slider1 = new JSlider(0, 10, 5);
        Hashtable position = new Hashtable();
        position.put(0, new JLabel("0"));
        position.put(1, new JLabel("1"));
        position.put(2, new JLabel("2"));
        position.put(3, new JLabel("3"));
        position.put(4, new JLabel("4"));
        position.put(5, new JLabel("5"));
        position.put(6, new JLabel("6"));
        position.put(7, new JLabel("7"));
        position.put(8, new JLabel("8"));
        position.put(9, new JLabel("9"));
        position.put(10, new JLabel("10"));
        slider1.setMajorTickSpacing(1);
        slider1.setPaintTicks(true);
        slider1.setLabelTable(position);
        slider1.setPaintLabels(true);
        JLabel slider1label = new JLabel("5");

        //set strength
        JLabel strength = new JLabel("Strength");
        JSlider slider2 = new JSlider(0, 10, 5);
        slider2.setMajorTickSpacing(1);
        slider2.setPaintTicks(true);
        slider2.setLabelTable(position);
        slider2.setPaintLabels(true);
        JLabel slider2label = new JLabel("5");

        //set sociability
        JLabel sociability = new JLabel("Sociability");
        JSlider slider3 = new JSlider(0, 10, 5);
        slider3.setMajorTickSpacing(1);
        slider3.setPaintTicks(true);
        slider3.setLabelTable(position);
        slider3.setPaintLabels(true);
        JLabel slider3label = new JLabel("5");

        //set empathy
        JLabel empathy = new JLabel("Empathy");
        JSlider slider4 = new JSlider(0, 10, 5);
        slider4.setMajorTickSpacing(1);
        slider4.setPaintTicks(true);
        slider4.setLabelTable(position);
        slider4.setPaintLabels(true);
        JLabel slider4label = new JLabel("5");

        //set relationships
        JLabel relationships = new JLabel("Relationships");
        JTextField enterRelationships = new JTextField("Enter Relationships");

        //button to create participant
        JButton createParticipant = new JButton("Create Participant");


        //frame settings
        frame2.setSize(800, 800);
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.setVisible(true);
        frame2.add(secondPanel);

        //adding objects to panel
        secondPanel.setLayout(null);
        secondPanel.add(name);
        secondPanel.add(enterName);
        secondPanel.add(intelligence);
        secondPanel.add(slider1);
        secondPanel.add(slider1label);
        secondPanel.add(strength);
        secondPanel.add(slider2);
        secondPanel.add(slider2label);
        secondPanel.add(sociability);
        secondPanel.add(slider3);
        secondPanel.add(slider3label);
        secondPanel.add(empathy);
        secondPanel.add(slider4);
        secondPanel.add(slider4label);
        secondPanel.add(relationships);
        secondPanel.add(enterRelationships);
        secondPanel.add(createParticipant);

        //Setting dimensions and locations for my objects
        name.setBounds(50, 50, 200, 50);
        enterName.setBounds(300, 50, 200, 50);
        intelligence.setBounds(50, 150, 200, 50);
        slider1.setBounds(150, 150, 500, 50);
        slider1label.setBounds(700, 150, 50, 50);
        strength.setBounds(50, 250, 200, 50);
        slider2.setBounds(150, 250, 500, 50);
        slider2label.setBounds(700, 250, 50, 50);
        sociability.setBounds(50, 350, 200, 50);
        slider3.setBounds(150, 350, 500, 50);
        slider3label.setBounds(700, 350, 50, 50);
        empathy.setBounds(50, 450, 200, 50);
        slider4.setBounds(150, 450, 500, 50);
        slider4label.setBounds(700, 450, 50, 50);
        relationships.setBounds(50, 550, 200, 50);
        enterRelationships.setBounds(50, 600, 200, 50);
        createParticipant.setBounds(450, 525, 200, 200);

        //logic for changing sliders
        slider1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                slider1label.setText("" + ((JSlider) e.getSource()).getValue());
                final int intel = ((JSlider) e.getSource()).getValue();
            }
        });
        slider2.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                slider2label.setText("" + ((JSlider) e.getSource()).getValue());
                final int str = ((JSlider) e.getSource()).getValue();
            }
        });
        slider3.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                slider3label.setText("" + ((JSlider) e.getSource()).getValue());
                final int soc = ((JSlider) e.getSource()).getValue();
            }
        });
        slider4.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                slider4label.setText("" + ((JSlider) e.getSource()).getValue());
                final int emp = ((JSlider) e.getSource()).getValue();
            }
        });
        createParticipant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

}
