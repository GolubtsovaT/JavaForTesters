package ru.stqa.jft.sandbox;

public class firstProgramGolubtsovaT {

    public static void main(String[] args) {
        Point p1 = new Point (9.7,2.6);
        Point p2 = new Point (16.8,-7.4);
        System.out.println("Distance between points p1 and p2 = " + distance(p1,p2));
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
    }
}