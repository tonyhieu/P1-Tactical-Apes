//import DeathGame.*;
import DoublePendulum.*;
import SinglePendulum.*;
import SinglePendulum.SinglePendulumControl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Main {


    public static void main (String[] args) {
        //Initialize menu objects
        JFrame menuFrame = new JFrame();
        JPanel menuPanel = new JPanel();
        JLabel welcomeLabel = new JLabel("Tactical Apes Simulations");
        JButton deathGame = new JButton("Death Game Simulation");
        JButton doublePendulum = new JButton("Double Pendulum Simulation");



        //frame settings
        menuFrame.setSize(500, 800);
        menuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        menuFrame.setVisible(true);
        menuFrame.add(menuPanel);

        //panel add objects
        menuPanel.setLayout(null);
        menuPanel.add(welcomeLabel);
        menuPanel.add(deathGame);
        menuPanel.add(doublePendulum);


        //setting bounds
        welcomeLabel.setBounds(150,50,200,50);
        deathGame.setBounds(100,150,250,100);
        doublePendulum.setBounds(100,300,250,100);

        JButton singlePendulum = new JButton("Single Pendulum Simulation");
        menuPanel.add(singlePendulum);
        singlePendulum.setBounds(100,600,250,100);

        //button logic
        /*deathGame.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent e) {
                DeathGameView deathgameview = new DeathGameView();
                deathgameview.RunDeathGameView();
            }
        });*/
        doublePendulum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoublePendulumView doublependulumview = new DoublePendulumView();
                doublependulumview.main(null);
            }
        });

        singlePendulum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SinglePendulumMain singlePendulumMain;
                singlePendulumMain = new SinglePendulumMain();
            }
        });


    }

}
