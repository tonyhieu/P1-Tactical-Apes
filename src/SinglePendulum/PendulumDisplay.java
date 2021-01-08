package SinglePendulum;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;


public class PendulumDisplay extends JPanel implements Runnable {

    SinglePendulumModel model;



    private final int D_WIDTH = 400;
    private final int D_HEIGHT = 400;



    private Thread animator;



    private final int DELAY = 5;

    public PendulumDisplay(SinglePendulumModel model) {
        this.model = model;




        initDisplay();
    }
    public void initDisplay() {


        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(D_WIDTH, D_HEIGHT));
        setVisible(true);


    }
    @Override
    public void addNotify() {
        super.addNotify();

        animator = new Thread(this);
        animator.start();

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);

        int anchorX = getWidth()/2;
        int anchorY = getHeight()/4;
        int bobX = (int) (anchorX + model.bobX);
        int bobY = (int) (anchorY + model.bobY);

        System.out.println(" "+anchorX+","+anchorY);

        g.setColor(Color.BLACK);
        g.drawLine(anchorX,anchorY, bobX,bobY);






        //drawPendulum(g);


    }

    /*private void drawPendulum(Graphics g) {
        System.out.println(origin.getX());
        g.drawLine((int)origin.getX(), (int) origin.getY(),bobX, bobY);


        //pendulum bob
        g.drawOval(bobX,bobY,10,10);
    }*/

    private void cycle() {
        model.update();

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
