package cs350f20task3;

public class Coordinates {

    private final double x;
    private final double y;

    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;

    }
    /*
    Create coordinates. [2]
    Parameters:
    x - the x coordinate
    y - the y coordinate

     */



    public Coordinates add(Coordinates coordinates) {
        return new Coordinates(this.x + coordinates.getX(), this.y + coordinates.getY());
    }
    /*
    Adds coordinates to these coordinates. [4]
    Parameters:
    coordinates - the coordinates to add
    Returns:
    the result

     */



    public double calculateBearing(Coordinates coordinates) {
        Coordinates difference = this.subtract(coordinates);
        double bearing =  Math.toDegrees((Math.atan2(difference.x, difference.y) + Math.PI));
        return bearing % 360;
    }
    /*
    Calculates the bearing from these coordinates to other coordinates. [6]
    Parameters:
    coordinates - the other coordinates
    Returns:
    the bearing


     */


    public double calculateDistance(Coordinates coordinates) {

        double xDistance, yDistance;

        Coordinates distance = subtract(coordinates);

        xDistance = distance.getX();
        yDistance = distance.getY();

       return java.lang.Math.hypot(java.lang.Math.abs(xDistance), java.lang.Math.abs(yDistance));

    }
    /*
    Calculates the distance from these coordinates to other coordinates. [3]
    Parameters:
    coordinates - the other coordinate
    Returns:
    the distance


     */


    public double getX() {
        return this.x;
    }
    /*
    Gets the x coordinate. [1]
    Returns:
    the coordinate

     */

    public double getY() {
        return this.y;
    }
    /*
    Gets the y coordinate. [1]
    Returns:
    the coordinate


     */


    public boolean isNear(Coordinates coordinates) {
        return this.calculateDistance(coordinates) <= 0.01;
    }
    /*
    Determines whether coordinates are near these coordinates. [3]
    Parameters:
    coordinates - the other coordinates
    Returns:
    the result


     */


    public Coordinates subtract(Coordinates coordinates) {
        return new Coordinates(this.x - coordinates.getX(), this.y - coordinates.getY());
    }
    /*
    Subtracts coordinates from these coordinates. [4]
    Parameters:
    coordinates - the coordinates to subtract
    Returns:
    the result





    public Join.java.lang.String toString() {

    }
    /*
    This is not required.
    Overrides:
    toString in class java.lang.Object
    Returns:
    the string representation

     */
}
