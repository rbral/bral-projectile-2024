package bral.projectile;

public class Projectile {

    // data:
    // when making objects:
    // must be private: not accessible by anything outside the class
    private double angle;
    private double radians;
    private double seconds;
    private double velocity;

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
        return Math.sin(radians) * velocity * seconds - (0.5 * 9.8 * seconds * seconds);
    }

    /**
     * @return the time the Projectile is at its highest point.
     */
    public double getApexTime() {
        return ( velocity * Math.sin(radians) ) / 9.8;
    }

    /**
     * @return the highest Y value of the Projectile
     * formula obtained from: https://study.com/skill/learn/using-multiple-methods-to-calculate-the-maximum-height-of-a-projectile-explanation.html
     */
    public double getPeakY()
    {
        double v_0_y = velocity * Math.sin(radians);
        return (v_0_y * v_0_y) / 9.8;
    }


}


