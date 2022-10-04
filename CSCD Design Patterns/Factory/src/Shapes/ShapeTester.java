import Shapes.Shape;
import Shapes.ShapeFactory;

import java.util.ArrayList;
import java.util.Collections;

public class ShapeTester {

    public static void main(String [] args) {
        ArrayList<Shape> shapes = new ArrayList<Shape>();

        shapes.add(ShapeFactory.createTriangle(2.0, 4.0));
        shapes.add(ShapeFactory.createCircle(3.0));
        shapes.add(ShapeFactory.createSquare(7.4));
        shapes.add(ShapeFactory.createCircle(3.0));
        shapes.add(ShapeFactory.createRectangle(2.0, 4.0));
        shapes.add(ShapeFactory.createSquare(5.0));
        shapes.add(ShapeFactory.createTriangle(2.1, 4.0));
        shapes.add(ShapeFactory.createRectangle(2.1, 4.0));
        shapes.add(ShapeFactory.createCircle(2.0));
        shapes.add(ShapeFactory.createRectangle(5.0, 4.0));
        shapes.add(ShapeFactory.createSquare(3.0));
        shapes.add(ShapeFactory.createCircle(4.5));
        shapes.add(ShapeFactory.createTriangle(5.0, 4.0));
        shapes.add(ShapeFactory.createRectangle(40.0, 20.5));

        System.out.println("This is the unsorted list: \n");
        for( Shape s: shapes) {
            System.out.println(s.name() + ", area: " + s.area() + ", perimeter: " + s.perimeter());
        }
        System.out.println();
        Collections.sort(shapes, null);
        System.out.println("This is after being sorted: \n");
        for( Shape s: shapes) {
            System.out.println(s.name() + ", area: " + s.area() + ", perimeter: " + s.perimeter());
        }
    }
}
