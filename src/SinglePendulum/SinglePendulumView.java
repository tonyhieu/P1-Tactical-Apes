package SinglePendulum;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import java.awt.EventQueue;
import java.awt.Dimension;


public class SinglePendulumView {
    SinglePendulumModel model;

    JFrame frame;
    JPanel panel;
    JButton startSimulation;

    public SinglePendulumView(SinglePendulumModel model) {
        this.model = model;
        initUI();


    }

    public void initUI() {
        frame = new JFrame();
        panel = new JPanel();
        JButton startSimulation = new JButton("Start Simulation");

        JButton editProperties = new JButton("Edit Pendulum Properties)");




        frame.setSize(new Dimension(800,800));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);

        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(800, 800));
        panel.add(startSimulation);
        panel.add(editProperties);

        startSimulation.setBounds(100,200,500,100);

        editProperties.setBounds(100,400,500,100);

        startSimulation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startSimulation();
            }
        });

        /*editProperties.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {editPendulumProperties();}
        });*/

    }

    public void startSimulation() {
        JFrame f = new JFrame("PendulumDisplay");
        PendulumDisplay p = new PendulumDisplay(model);
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        new Thread(p).start();

    }


}

