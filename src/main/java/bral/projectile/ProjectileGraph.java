package bral.projectile;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

import static java.lang.Math.round;

public class ProjectileGraph extends JComponent
{
    Projectile initialProjectile = new Projectile(31, 65);
//    initialProjectile.setSeconds(2.7);

    Projectile projectile = new Projectile(initialProjectile);
    // method that you can use to draw to screen:
    // code > override methods > paint component

    private static final DecimalFormat FORMAT = new DecimalFormat("0.00");

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.LIGHT_GRAY);
        g.drawLine(0, 0, 0, getHeight());

        // to move the origin
        g.translate(0, getHeight());



//        g.drawString("(100, 100)", 100, -100);
//        g.setColor(Color.DARK_GRAY);
//        g.drawLine(0, 0, getWidth(), -getHeight());
//        g.drawRect(200, -200, 50, 50);
//        g.setColor(Color.MAGENTA);

//        g.setColor(Color.ORANGE);
//        g.drawOval(200, -200, 50, 50);
//
//        // draw some values of projectile
//        g.fillOval((int) projectile.getX(), (int) -projectile.getY(), 10, 10);

        // light gray rule lines:
        g.setColor(Color.LIGHT_GRAY);
//        for (int i = 0; i < get)

        g.setColor(Color.DARK_GRAY);
        // draw path of projectile:
        double oldX = 0;
        double oldY = 0;
        double newX;
        double newY;
        Projectile copyProjectile = new Projectile(projectile);

        for (double i = 0.0; i < (copyProjectile.getApexTime() * 2); i += 0.1) {
            copyProjectile.setSeconds(i);
            newX = copyProjectile.getX();
            newY = copyProjectile.getY();
            g.drawLine((int) oldX, (int) -oldY,
                    (int) newX, (int) -newY);
            oldX = newX;
            oldY = newY;
        }

        // indicate point at seconds in RED
        g.setColor(Color.RED);
        double currX = projectile.getX();
        double currY = projectile.getY();
        g.fillOval((int) currX - 5, (int) -currY - 5, 10, 10);
        // write coordinates
        g.drawString(("(" + FORMAT.format(currX) + ", " + FORMAT.format(currY) + ")"),
                ( (int) currX - 30 ), ( (int) -currY - 20 ));

        // indicate point where projectile is at peak in BLUE
        g.setColor(Color.BLUE);
        double apexTime = copyProjectile.getApexTime();
        copyProjectile.setSeconds(apexTime);
        newX = copyProjectile.getX();
        newY = copyProjectile.getY();
        g.fillOval((int) newX - 5, (int) -newY - 5, 10, 10);
        // write coordinates
        g.drawString( ("(" + FORMAT.format(newX) + ", " + FORMAT.format(newY) + ")"),
                ( (int) newX - 30 ), ( (int) -newY - 20 ));

        g.setColor(Color.DARK_GRAY);

    }

    public void setProjectile(Projectile projectile)
    {
        this.projectile = projectile;

        // tells the OS to call paintComponent again:
        repaint();
    }

}
