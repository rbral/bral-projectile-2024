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
        /*g.drawString("(100, 100)", 100, -100);
        g.setColor(Color.DARK_GRAY);
        g.drawLine(0, 0, getWidth(), -getHeight());
        g.drawRect(200, -200, 50, 50);
        g.setColor(Color.MAGENTA);
        g.fillRect(400, -400, 25, 25);
        g.setColor(Color.ORANGE);
        g.drawOval(200, -200, 50, 50);

        // draw some values of projectile
        g.fillOval((int) projectile.getX(), (int) -projectile.getY(), 10, 10);*/

        g.setColor(Color.DARK_GRAY);
        // draw path of projectile:
        double oldX = 0;
        double oldY = 0;
        double newX;
        double newY;
        for (double i = 0.0; i < (projectile.getApexTime() * 2); i += 0.1)
        {
            projectile.setSeconds(i);
            newX = projectile.getX();
            newY = projectile.getY();
            g.drawLine((int) oldX, (int) -oldY,
                    (int) newX, (int) -newY);
            oldX = newX;
            oldY = newY;

            if (Math.abs(i - projectile.getApexTime()) < 0.05)
            {
                g.setColor(Color.BLUE);
                g.fillOval((int) newX - 5, (int) -newY - 5, 10, 10);
                g.setColor(Color.DARK_GRAY);
            }

            repaint();
        }

    }

    public void setProjectile(Projectile projectile)
    {
        this.projectile = projectile;

        // tells the OS to call painComponent again:
        repaint();
    }

}
