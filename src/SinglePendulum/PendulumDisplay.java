package SinglePendulum;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;


public class PendulumDisplay extends JPanel implements Runnable {

    SinglePendulumModel model;


    private final int D_WIDTH = 400;
    private final int D_HEIGHT = 400;

    private final Point2D origin = new Point2D.Double(D_WIDTH/2,0 );

    private Thread animator;
    public int bobX;
    public int bobY;


    private final int DELAY = 5;

    public PendulumDisplay(SinglePendulumModel model) {
        this.model = model;

        initDisplay();
    }
    public void initDisplay() {
        this.bobX = (int) (origin.getX() + model.bobPos.getX());
        this.bobY = (int) (origin.getY() + model.bobPos.getY());

        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(D_WIDTH, D_HEIGHT));


    }
    @Override
    public void addNotify() {
        super.addNotify();

        animator = new Thread(this);
        animator.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawPendulum(g);
    }

    private void drawPendulum(Graphics g) {
        g.drawLine((int)origin.getX(), (int) origin.getY(),bobX, bobY);
        g.drawOval(bobX,bobY,10,10);
    }

    private void cycle() {
        model.update();
        bobX = (int) (origin.getX() + model.bobPos.getX());
        bobY = (int) (origin.getY() + model.bobPos.getY());
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
