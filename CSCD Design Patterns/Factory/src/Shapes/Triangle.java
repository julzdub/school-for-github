package Shapes;

class Triangle extends Shape {

    double height;
    double base;

    Triangle(double b, double h) {
        this.base = b;
        this.height = h;
    }

    @Override
    public String name() {
        return "Triangle";
    }

    @Override
    public double perimeter() {
        return (Math.hypot(this.base/2, this.height) * 2) + this.base;
    }

    @Override
    public double area() {
        return (this.base * this.height)/2;
    }
}
