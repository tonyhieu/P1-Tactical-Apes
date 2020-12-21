package DoublePendulum;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//Ignore this. This is just junk code
public class PendulumMenu {
    int pendulumIndex;
    DoublePendulumControl control;
    JFrame pendulumFrame;
    JPanel pendulumPanel;
    JLabel title;
    JLabel rodLengthTitle;
    JLabel weightMassTitle;
    JTextField pendulumRodLength;
    JTextField pendulumWeightMass;
    JButton setValues;



    public PendulumMenu(int pendulumNumber,DoublePendulumControl control) {
        this.pendulumIndex = pendulumNumber -1 ;
        this.control = control;
        this.title = new JLabel("Pendulum " + Integer.toString(pendulumNumber));
        this.rodLengthTitle = new JLabel("Enter the length of the rod (cm):");
        this.weightMassTitle = new JLabel("Enter the mass of the weight (in g):");
        this.pendulumRodLength = new JTextField();
        this.pendulumWeightMass = new JTextField();
        this.setValues = new JButton("Click to set values");



        PendulumBuilder pendulumInfo = control.pendulumsInfo.get(pendulumIndex);

        pendulumRodLength.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pendulumInfo.setRodLength(Integer.parseInt(pendulumRodLength.getText()));
            }
        });

        pendulumWeightMass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pendulumInfo.setWeightMass((Integer.parseInt(pendulumWeightMass.getText())));
            }
        });

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
}
