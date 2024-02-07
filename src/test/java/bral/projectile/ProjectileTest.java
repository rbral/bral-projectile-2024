package bral.projectile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectileTest {

    @Test
    public void getX()
    {
        //given: need to create an object
        Projectile projectile = new Projectile(31, 65);
        projectile.setSeconds(2.7);

        // when
        double actual = projectile.getX();

        // then
        // 3rd arg is how much we allow the numbers to be dif
        assertEquals(46.28, actual, 0.01);

    }

    @Test
    void getY()
    {
        //given: need to create an object
        Projectile projectile = new Projectile(31, 65);
        projectile.setSeconds(2.7);

        // when
        double actual = projectile.getY();

        // then
        assertEquals(-7.90, actual, 0.01);
    }

    @Test
    void getApexTime()
    {
        //given: need to create an object
        Projectile projectile = new Projectile(31, 65);
        projectile.setSeconds(2.7);

        //when
        double actual = projectile.getApexTime();

        // then
        assertEquals(1.05, actual, 0.01);
    }

    @Test
    void getPeakY()
    {
        // given
        Projectile projectile = new Projectile(31, 65);
        projectile.setSeconds(2.7);

        // when
        double actual = projectile.getPeakY();

        // then
        assertEquals(114.36, actual, 0.01);

    }

}