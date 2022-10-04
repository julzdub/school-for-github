package Shapes;

public abstract class Shape implements Comparable<Shape> {

    public abstract String name();
    public abstract double perimeter();
    public abstract double area();

    public int compareTo(Shape that) {
        if(this.name().equals(that.name())) {
            return (int) (this.area() - that.area());
        }
        return this.name().compareTo(that.name());
    }

}
