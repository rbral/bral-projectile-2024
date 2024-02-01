package bral.projectile;

public class Projectile {

    // data:
    // when making objects:
    // must be private: not accessible by anything outside the class
    private double angle;
    private double radians;
    private double seconds;
    private double velocity;
    private double v_0_y; // initial vertical component of velocity

    public Projectile(double angle, double velocity) {
        this.angle = angle;
        this.velocity = velocity;
        this.radians = Math.toRadians(angle);
    }

    public void setSeconds(double seconds) {
        this.seconds = seconds;
    }

    public double getX() {
        return Math.cos(radians) * velocity * seconds;
    }

    public double getY() {
        return Math.sin(radians) * velocity * seconds - (0.5 * 9.8 * Math.pow(seconds, 2));
    }

    /**
     * @return the time where the Projectile is at its highest point.
     */
    public double getApexTime() {
        double v_0_y = velocity * Math.sin(radians);
        return v_0_y / 9.8;
    }


}



/*
What is a class?
A way to organize our data and methods on that data within your code.
fundamentally has: 1-data, 2-methods.

to create a test:
ctrl > shift > t > create new test



 */
