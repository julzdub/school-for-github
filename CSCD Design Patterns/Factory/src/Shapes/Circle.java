package Shapes;

class Circle extends Shape {

    double radius;

    Circle(double r) {
        this.radius = r;
    }

    @Override
    public String name() {
        return "Circle";
    }

    @Override
    public double perimeter() {
        return this.radius * Math.PI * 2;
    }

    @Override
    public double area() {
        return (this.radius * Math.PI) * (this.radius * Math.PI);
    }

}
