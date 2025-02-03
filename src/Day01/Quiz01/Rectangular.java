package Day01.Quiz01;

public class Rectangular extends Shape {

    private double width;
    private double hight;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return hight;
    }

    public void setHight(double hight) {
        this.hight = hight;
    }

    @Override
    public void calculationArea() {
        super.area = width * hight;
    }
}
