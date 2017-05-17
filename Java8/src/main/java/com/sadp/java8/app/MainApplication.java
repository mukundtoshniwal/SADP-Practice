package com.sadp.java8.app;

import com.sadp.java8.pojo.Coordinates2D;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by srawa5 on 5/17/2017.
 */
public class MainApplication {

    public static void main(String[] args) {
        Coordinates2D point1 = new Coordinates2D(0, 0);
        Coordinates2D point2 = new Coordinates2D(-1, 1);
        Coordinates2D point3 = new Coordinates2D(-2, 4);
        Coordinates2D point4 = new Coordinates2D(-2, -3);
        Coordinates2D point5 = new Coordinates2D(-10, 2);
        Coordinates2D point6 = new Coordinates2D(5, -1);
        Coordinates2D point7 = new Coordinates2D(2, 4);
        Coordinates2D point8 = new Coordinates2D(1, 0);
        Coordinates2D point9 = new Coordinates2D(10, 3);

        List<Coordinates2D> list = new ArrayList<Coordinates2D>();
        list.add(point1);
        list.add(point2);
        list.add(point3);
        list.add(point4);
        list.add(point5);
        list.add(point6);
        list.add(point7);
        list.add(point8);
        list.add(point9);

        System.out.println("Print each coordinate using lambda expression");
        printListOfCoordinates(list);

        System.out.println("Calculate sum of X coordinates using mapToInt and reduce");
        printAllxCoordinatesWithSum(list);

        System.out.println("Calculate sum of all Y coordinates using sum()");
        printSumOfOrdinates(list);

        System.out.println("Filter all coordinates with positive X and Y coordinates, print them");
        listOfCoordinatesInIstQuadrant(list);

        System.out.println("Use collectors to store all coordinates with positive X to a new arrayList");
        List<Coordinates2D> listOfIstQuadrantCoordinates = getIstQuadrantCoordinatesList(list);
        printListOfCoordinates(listOfIstQuadrantCoordinates);

    }

    private static List<Coordinates2D> getIstQuadrantCoordinatesList(List<Coordinates2D> list) {
        return list.stream().filter((Coordinates2D p) ->{
            if(p.getX()>=0&& p.getY()>=0){
                return true;
            }
            return false;

        }).collect(Collectors.toList());
    }

    private static void printAllxCoordinatesWithSum(List<Coordinates2D> list) {

        list.stream().mapToInt(p->p.getX()).reduce(0,(a,b)->{
            System.out.println("sum is:"+ a);
            System.out.println("next x is:"+ b);
            return a+b;});
    }

    private static void listOfCoordinatesInIstQuadrant(List<Coordinates2D> list) {
        list.stream().filter((Coordinates2D p) ->{
            if(p.getX()>=0&& p.getY()>=0){
                return true;
            }
            return false;

        }).forEach(System.out:: println);
    }

    private static void printSumOfOrdinates(List<Coordinates2D> list) {
        int yCoordinatesSum = list.stream().mapToInt(n->n.getY()).sum();
        System.out.println("Sum of y coordinates: "+yCoordinatesSum);
    }

    private static void printListOfCoordinates(List<Coordinates2D> list) {
        list.forEach((x) -> {
            System.out.println(x);
        });
    }


}
