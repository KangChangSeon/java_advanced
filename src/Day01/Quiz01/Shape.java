package Day01.Quiz01;

import java.awt.*;

public abstract class Shape {

    protected double area;
    private String name;

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shape() {
    }

    public Shape(String name) {
        this.name = name;
    }

    public abstract void calculationArea();

    public void print(){
        System.out.print(this.getArea());
    }
}
//public abstract class Shape {
//    protected double area;
//    private String name;
//
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Shape(){}
//    public Shape(String name) {
//        this.name = name;
//    }
//    abstract void calculationArea();
//    public void print(){
//        System.out.printf("%s의 면적은 %f",name,area);
//    }
//}