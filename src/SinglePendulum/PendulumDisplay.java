package SinglePendulum;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;


public class PendulumDisplay extends JFrame implements Runnable {

    SinglePendulumModel model;

    private JPanel panel;


    private final int D_WIDTH = 400;
    private final int D_HEIGHT = 400;

    private final Point2D origin = new Point2D.Double(D_WIDTH/2,0 );

    private Thread animator;
    public int bobX;
    public int bobY;


    private final int DELAY = 5;

    public PendulumDisplay(SinglePendulumModel model) {
        this.model = model;

        this.bobX = (int) (origin.getX() + model.bobX);
        this.bobY = (int) (origin.getY() + model.bobY);


        initDisplay();
    }
    public void initDisplay() {


        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(D_WIDTH, D_HEIGHT));
        setVisible(true);


    }
    @Override
    public void addNotify() {
        super.addNotify();

        animator = new Thread(this);
        animator.start();

    }

    /*@Override
    private void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        drawPendulum(g2);


    }*/

    private void drawPendulum(Graphics g) {
        System.out.println(origin.getX());
        g.drawLine((int)origin.getX(), (int) origin.getY(),bobX, bobY);


        //pendulum bob
        g.drawOval(bobX,bobY,10,10);
    }

    private void cycle() {
        model.update();
        bobX = (int) (origin.getX() + model.bobX);
        bobY = (int) (origin.getY() + model.bobX);

        //System.out.println("("+bobX+","+bobY);
        //System.out.println(model.bobX);
        //System.out.println(model.bobY);
    }


    @Override
    public void run() {
        long beforeTime,timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (true) {
            cycle();
            repaint();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY-timeDiff;

            if (sleep <0 ) {
                sleep = 2;
            }

            try {
                Thread.sleep(sleep);

            } catch (InterruptedException e) {
                String msg = String.format("Thread interrupted: %s", e.getMessage());

                JOptionPane.showMessageDialog(this, msg, "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            beforeTime = System.currentTimeMillis();
        }
    }
}
