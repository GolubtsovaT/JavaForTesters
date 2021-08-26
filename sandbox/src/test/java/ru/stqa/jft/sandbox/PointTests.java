package ru.stqa.jft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void testPoint(){
        Point p1 = new Point (0,-3);
        Point p2 = new Point (3,1);
        Assert.assertEquals(p1.distance(p2), 5);
    }

    @Test
    public void testPointForNullCoordinates(){
        Point p1 = new Point (0,0);
        Point p2 = new Point (0,0);
        Assert.assertEquals(p1.distance(p2), 0);
    }

    @Test
    public void testPointWithEqualsCoordinates(){
        Point p1 = new Point (5,0);
        Point p2 = new Point (5,0);
        Assert.assertEquals(p1.distance(p2), 0);
    }

    @Test
    public void testPointWithAllPositiveCoordinates(){
        Point p1 = new Point (5,3.6);
        Point p2 = new Point (3.6,5);
        Assert.assertEquals(p1.distance(p2), 1.979898987322333);
    }

    @Test
    public void testPointWithAllNegativeCoordinates(){
        Point p1 = new Point (-5,-4.4);
        Point p2 = new Point (-0.9,-7);
        Assert.assertEquals(p1.distance(p2), 4.854894437575342);
    }
}
