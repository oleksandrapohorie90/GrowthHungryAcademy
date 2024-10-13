package java_intro.week4;

public class Rectangle extends Shape implements Drawable{
    private double length, width;
    public Rectangle(double length, double width) {
        super("Rectangle");
        this.length = length;
        this.width = width;
    }
    @Override
    double calculateArea() {
        return length * width;
    }
    @Override
    double calculatePerimeter() {
        return 2 * (length + width);
    }
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle with length: " + length + " and width: " +
                width);
    }
}
