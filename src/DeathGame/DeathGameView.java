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
import DeathGame.Participant;


public class DeathGameView extends JFrame {
    //logic variables
    public final int BHEIGHT = 100;
    public final int BWIDTH = 800;
    public static ArrayList<Participant> ps = new ArrayList<Participant>();
    public static int participantNo = 0;
    public static ArrayList<JButton> buttons = new ArrayList<JButton>();
    public ArrayList<JLabel> labels = new ArrayList<JLabel>();

    //JPanel variables
    /*public JButton participant1;
    public JButton participant2;
    public JButton participant3;*/
    public JButton addParticipant;
    public JButton startSimulation;
    public JScrollPane Scroller;

    public static void main(String[] args) {
        DeathGameView initialize = new DeathGameView();
        initialize.RunDeathGameView();
    }
    public void RunDeathGameView() {

        //initialize variables
        JFrame frame = new JFrame();
        JPanel startPanel = new JPanel();
        JButton startSimulation = new JButton("Start Simulation");
        JButton addParticipant = new JButton("Create New Participant (please be patient while the button loads!)");
        JButton listParticipant = new JButton("List Participants");
        JButton test = new JButton("Test");

        //JScrollPane Scroller = new JScrollPane(startPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //Scroller.setPreferredSize(new Dimension(100,100));
        //Scroller.setVisible(true);

        //Scroller.getViewport().setPreferredSize(new Dimension(900, 900));


        //Dimensions and properties of frame
        frame.setSize(900, 800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        Scroller = new JScrollPane(startPanel);
        Scroller.createHorizontalScrollBar();
        Scroller.createVerticalScrollBar();
        frame.add(Scroller, BorderLayout.CENTER);

      //  frame.add(Scroller);

        //frame.getContentPane().add(Scroller);
       // frame.pack();
        frame.setVisible(true);

        //frame.add(Scroller);
        //frame.add(BorderLayout.CENTER, new JScrollPane(startPanel));

        //Panel adds objects to view
        startPanel.setLayout(null);
       // startPanel.setPreferredSize(new Dimension(900,800));
        startPanel.add(listParticipant);
        startPanel.add(startSimulation);
        startPanel.add(addParticipant);
       // startPanel.add(Scroller);
        //startPanel.add(test);

        //Set bounds for buttons
        listParticipant.setBounds(50,50,800,100);
        startSimulation.setBounds(50,200,800,100);
        addParticipant.setBounds(50,350,800,100);
        test.setBounds(50,750,800,100);
        //Scroller.setBounds(850,0,50,200);

        //Logic for buttons pressed
        addParticipant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttons.add(new JButton("Participant " + (participantNo + 1)));
                buttons.get(participantNo).setBounds(50, 500 + participantNo*150, 800, 100);
                startPanel.add(buttons.get(participantNo));
                ps.add(new Participant(0, 0, 0, 0, new Hashtable<Participant, Integer>(), "Participant " + (participantNo + 1)));
                buttons.get(participantNo).addActionListener(new ActionListener() {
                    public final int placeholder = participantNo;
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DeathGameView editor = new DeathGameView();
                        editor.SecondView(placeholder);
                    }
                });
                System.out.print(participantNo);
                participantNo++;
            }
        });
        listParticipant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeathGameView list = new DeathGameView();
                list.listParticipants();
            }
        });
        /*participant1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeathGameView secondview = new DeathGameView();
                secondview.SecondView(0);
            }
        });;*/
        /*startSimulation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               frame.dispose();
            }
        });*/
    }

    public void SecondView(int index) {
        final int i = index;

        //initialize frame and panel
        JFrame frame2 = new JFrame();
        JPanel secondPanel = new JPanel();

        //set name
        JLabel name = new JLabel("Name");
        //JTextField enterName = new JTextField("Enter Name");
        //changes name to past name
        JTextField enterName = new JTextField(ps.get(i).name);

        //set intelligence and initialize hashtable
        JLabel intelligence = new JLabel("Intelligence");
        JSlider intSlider = new JSlider(0,10,5);
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
        intSlider.setMajorTickSpacing(1);
        intSlider.setPaintTicks(true);
        intSlider.setLabelTable(position);
        intSlider.setPaintLabels(true);
        JLabel intSliderLabel = new JLabel("5");

        //set strength
        JLabel strength = new JLabel("Strength");
        JSlider strSlider = new JSlider(0,10,5);
        strSlider.setMajorTickSpacing(1);
        strSlider.setPaintTicks(true);
        strSlider.setLabelTable(position);
        strSlider.setPaintLabels(true);
        JLabel strSliderLabel = new JLabel("5");

        //set sociability
        JLabel sociability = new JLabel("Sociability");
        JSlider socSlider = new JSlider(0,10,5);
        socSlider.setMajorTickSpacing(1);
        socSlider.setPaintTicks(true);
        socSlider.setLabelTable(position);
        socSlider.setPaintLabels(true);
        JLabel socSliderLabel = new JLabel("5");

        //set empathy
        JLabel empathy = new JLabel("Empathy");
        JSlider empSlider = new JSlider(0,10,5);
        empSlider.setMajorTickSpacing(1);
        empSlider.setPaintTicks(true);
        empSlider.setLabelTable(position);
        empSlider.setPaintLabels(true);
        JLabel empSliderLabel = new JLabel("5");

        //changes values of sliders according to preexisting values
        intSlider.setValue(ps.get(i).intel);
        intSliderLabel.setText(Integer.toString(ps.get(i).intel));
        strSlider.setValue(ps.get(i).str);
        strSliderLabel.setText(Integer.toString(ps.get(i).str));
        socSlider.setValue(ps.get(i).soc);
        socSliderLabel.setText(Integer.toString(ps.get(i).soc));
        empSlider.setValue(ps.get(i).emp);
        empSliderLabel.setText(Integer.toString(ps.get(i).emp));


        //set relationships
        JLabel relationships = new JLabel("Relationships");
        JTextField enterRelationships = new JTextField("Enter Relationships");

        //button to create participant
        JButton createParticipant = new JButton("Create/Update Participant");


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
        secondPanel.add(intSlider);
        secondPanel.add(intSliderLabel);
        secondPanel.add(strength);
        secondPanel.add(strSlider);
        secondPanel.add(strSliderLabel);
        secondPanel.add(sociability);
        secondPanel.add(socSlider);
        secondPanel.add(socSliderLabel);
        secondPanel.add(empathy);
        secondPanel.add(empSlider);
        secondPanel.add(empSliderLabel);
        secondPanel.add(relationships);
        secondPanel.add(enterRelationships);
        secondPanel.add(createParticipant);

        //Setting dimensions and locations for my objects
        name.setBounds(50,50,200,50);
        enterName.setBounds(300,50,200,50);
        intelligence.setBounds(50,150,200,50);
        intSlider.setBounds(150,150,500,50);
        intSliderLabel.setBounds(700,150,50,50);
        strength.setBounds(50,250,200,50);
        strSlider.setBounds(150,250,500,50);
        strSliderLabel.setBounds(700,250,50,50);
        sociability.setBounds(50,350,200,50);
        socSlider.setBounds(150,350,500,50);
        socSliderLabel.setBounds(700,350,50,50);
        empathy.setBounds(50,450,200,50);
        empSlider.setBounds(150,450,500,50);
        empSliderLabel.setBounds(700,450,50,50);
        relationships.setBounds(50,550,200,50);
        enterRelationships.setBounds(50,600,200,50);
        createParticipant.setBounds(450,525,200,200);

        //logic for changing sliders
        intSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                intSliderLabel.setText("" + ((JSlider)e.getSource()).getValue());
            }
        });
        strSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                strSliderLabel.setText("" + ((JSlider)e.getSource()).getValue());
            }
        });
        socSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                socSliderLabel.setText("" + ((JSlider)e.getSource()).getValue());
            }
        });
        empSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                empSliderLabel.setText("" + ((JSlider)e.getSource()).getValue());
            }
        });
        createParticipant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*if (i == NEW) {
                    ps.add(new Participant(Integer.parseInt(intSliderLabel.getText()), Integer.parseInt(strSliderLabel.getText()), Integer.parseInt(socSliderLabel.getText()), Integer.parseInt(empSliderLabel.getText()), new Hashtable<Participant, Integer>(), enterName.getText()));
                } else {
                    ps.set(i, new Participant(Integer.parseInt(intSliderLabel.getText()), Integer.parseInt(strSliderLabel.getText()), Integer.parseInt(socSliderLabel.getText()), Integer.parseInt(empSliderLabel.getText()), new Hashtable<Participant, Integer>(), enterName.getText()));
                }*/

                ps.set(i, new Participant(Integer.parseInt(intSliderLabel.getText()), Integer.parseInt(strSliderLabel.getText()), Integer.parseInt(socSliderLabel.getText()), Integer.parseInt(empSliderLabel.getText()), new Hashtable<Participant, Integer>(), enterName.getText()));
                buttons.get(i).setText(enterName.getText());
                frame2.dispose();
            }
        });
    }
    public void listParticipants() {
        JFrame listFrame = new JFrame();
        JPanel listPanel = new JPanel();
       // JLabel test = new JLabel(String.valueOf(ps.get(0).name));

        listFrame.setSize(800, 800);
        listFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        listFrame.setVisible(true);
        listFrame.add(listPanel);

       // test.setBounds(50,50,50,50);

       // listPanel.add(test);
        listPanel.setLayout(null);

        for (int i = 0; i < ps.size(); i++) {
            labels.add(new JLabel("Participant " + (i + 1) + ": " + "Name: " + ps.get(i).name + ", Intelligence: " + ps.get(i).intel + ", Strength: " + ps.get(i).str + ", Sociability: " + ps.get(i).soc + ", Empathy: " + ps.get(i).emp ));
            labels.get(i).setBounds(50, 50 + i*50, 800, 100);
            listPanel.add(labels.get(i));

        }

    }

}
