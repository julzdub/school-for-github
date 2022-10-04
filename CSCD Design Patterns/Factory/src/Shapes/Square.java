package Shapes;

class Square extends Shape {

    double sideLength;

    Square(double l) {
        this.sideLength = l;
    }

    @Override
    public String name() {
        return "Square";
    }

    @Override
    public double perimeter() {
        return this.sideLength * 4;
    }

    @Override
    public double area() {
        return this.sideLength * this.sideLength;
    }
}
