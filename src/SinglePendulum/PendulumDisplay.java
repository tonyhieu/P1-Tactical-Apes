package SinglePendulum;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.lang.Math;


public class PendulumDisplay extends JPanel implements Runnable {

    SinglePendulumModel model;

    int anchorX;
    int anchorY;

    int bobX;
    int bobY;

    double rodLength = 100;
    double g;

    double a = 30;
    double aVel;
    double aAcc;

    public PendulumDisplay(SinglePendulumModel model) {
        this.model = model;
        setDoubleBuffered(true);
    }

    @Override
    public void paint(Graphics g) {
        //draw background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());



        anchorX = getWidth() / 2;
        anchorY = getHeight() / 4;


        bobX = anchorX + (int) (Math.sin(a) * rodLength);
        bobY = anchorY + (int) (Math.cos(a) * rodLength);


        g.setColor(Color.BLACK);
        g.drawLine(anchorX, anchorY, bobX, bobY);
        g.fillOval(anchorX - 3, anchorY - 4, 7, 7);
        g.fillOval(bobX - 7, bobY - 7, 14, 14);
    }

    public void run() {

        while (true) {

            aAcc = -.75 / rodLength * Math.sin(a);
            aVel += aAcc;
            a += aVel;
            //System.out.println(a);
            repaint();
            try { Thread.sleep(15); } catch (InterruptedException ex) {}
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension((int) (2 * rodLength + 50), (int) rodLength / 2 * 3);
    }

    /*public static void main(String[] args) {
        JFrame f = new JFrame("PendulumDisplay");
        PendulumDisplay p = new PendulumDisplay(model);
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        new Thread(p).start();
    }*/
}
