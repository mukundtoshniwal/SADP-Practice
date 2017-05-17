package com.sadp.java8.pojo;

/**
 * Created by srawa5 on 5/17/2017.
 */
public class Coordinates2D {

    private int x;

    private int y;

    public Coordinates2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
