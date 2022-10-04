package Shapes;

class Rectangle extends Shape {

    double height;
    double length;

    Rectangle(double h, double l) {
        this.height = h;
        this.length = l;
    }

    @Override
    public String name() {
        return "Rectangle";
    }

    @Override
    public double perimeter() {
        return (this.height * 2) + (this.length * 2);
    }

    @Override
    public double area() {
        return (this.height * this.length);
    }
}
