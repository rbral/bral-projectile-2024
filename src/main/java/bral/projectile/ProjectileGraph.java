package bral.projectile;

import javax.swing.*;
import java.awt.*;

public class ProjectileGraph extends JComponent
{
    Projectile projectile = new Projectile(0, 0);
    // method that you can use to draw to screen:
    // code > override methods > paint component
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // to move the origin
        g.translate(0, getHeight());
        g.drawString("(100, 100)", 100, -100);
        g.setColor(Color.DARK_GRAY);
        g.drawLine(0, 0, getWidth(), -getHeight());
        g.drawRect(200, -200, 50, 50);
        g.setColor(Color.MAGENTA);
        g.fillRect(400, -400, 25, 25);
        g.setColor(Color.ORANGE);
        g.drawOval(200, -200, 50, 50);

        // draw some values of projectile
        g.fillOval((int) projectile.getX(), (int) -projectile.getY(), 10, 10);

        // time when projectile is at peak:
        g.setColor(Color.BLUE);
        double apexTime = projectile.getApexTime();
        projectile.setSeconds(apexTime);
        g.fillOval((int) projectile.getX(), (int) projectile.getPeakY(), 10, 10);


        // draw path of projectile:

        /*int numPoints = 100;
        int[] xPoints = new int[numPoints];
        int[] yPoints = new int[numPoints];

        for (int i = 0; i < numPoints; i++) {
            double t = i * projectile.getSeconds() / numPoints;
            double x = projectile.getXAtTime(t);
            double y = projectile.getYAtTime(t);
            xPoints[i] = (int) x;
            yPoints[i] = (int) -y; // Invert Y-axis for screen coordinates
        }

        g.drawPolyline(xPoints, yPoints, numPoints);*/


    }

    public void setProjectile(Projectile projectile)
    {
        this.projectile = projectile;

        // tells the OS to call painComponent again:
        repaint();
    }

}
