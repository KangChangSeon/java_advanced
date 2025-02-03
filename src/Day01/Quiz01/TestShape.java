package Day01.Quiz01;

import Day01.Quiz01.Shape;

import java.awt.*;


public class TestShape {
    public static void AreaInfo(Shape shape) {
        if(shape instanceof Circle) {
            Circle circle = (Circle) shape;
            circle.setRadius(10);
            circle.calculationArea();
            System.out.print("원의 면적은 ");
            shape.print();
            System.out.println();
        }else if(shape instanceof Rectangular){
            Rectangular rectangular = (Rectangular) shape;
            rectangular.setWidth(100);
            rectangular.setHight(2);
            rectangular.calculationArea();
            System.out.print("직사각형의 면적은 ");
            shape.print();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Shape[] shape = new Shape[2];
        shape[0] = new Circle();
        shape[1] = new Rectangular();

        AreaInfo(shape[0]);
        AreaInfo(shape[1]);
    }
}