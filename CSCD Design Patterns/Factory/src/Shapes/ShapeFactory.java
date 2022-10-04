package Shapes;

public class ShapeFactory {

    public static Shape createCircle(double r){
        return new Circle(r);
    }

    public static Shape createSquare(double l){
        return new Square(l);
    }

    public static Shape createTriangle(double b, double h) {
        return new Triangle(b, h);
    }

    public static Shape createRectangle(double h, double l) {
        return new Rectangle(h, l);
    }

}
