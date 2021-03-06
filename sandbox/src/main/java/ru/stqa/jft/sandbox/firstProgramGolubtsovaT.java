package ru.stqa.jft.sandbox;

public class firstProgramGolubtsovaT {

    public static void main(String[] args) {
        Point p1 = new Point (-11.7,6.6);
        Point p2 = new Point (8,-1.4);
        System.out.println("Distance between points p1 and p2 = " + distance(p1,p2));

        System.out.println("Distance between points p1 and p2 = " + p1.distance(p2));
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
    }
}