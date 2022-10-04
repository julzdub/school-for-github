package cs350f20task3;

public abstract class A_Segment {

    private String id;
    private Coordinates tipCCoordinates;
    private Coordinates tipDCoordinates;

    public A_Segment(java.lang.String id, Coordinates tipCCoordinates, Coordinates tipDCoordinates) {

    }
   /*
   Creates a segment. [3]
    Parameters:
    id - the segment identifier
    tipCCoordinates - the coordinates of the C tip
    tipDCoordinates - the coordinates of the D tip
    */

   public abstract Coordinates calculatePosition(boolean isFromTipCorD, double distance) {

   }
    /*
    Calculates the coordinates on the segment or joined segment(s) as a distance from the starting tip.
    Parameters:
    isFromTipCorD - whether to start from the C or D tip.
            distance - the distance
    Returns:
    the coordinates
    getID
    public java.lang.String getID()
    Gets the segment identifier. [1]
    Returns:
    the identifier
    */


    public abstract double getLength() {

    }
    /* Gets the length of the segment.
    Returns:
    the length
    getTipCCoordinates */

    public Coordinates getTipCCoordinates() {

    }
    /*
    Gets the coordinates of the C tip. [1]
    Returns:
    the coordinates
    getTipCJoin
     */


    public Join getTipCJoin() {

    }
    /*
    Gets the join between the C tip of this segment and another segment. [1]
    Returns:
    the join
    getTipDCoordinates
     */


    public Coordinates getTipDCoordinates(){

    }
    /*
    Gets the coordinates of the D tip. [1]
    Returns:
    the coordinates
    getTipDJoin
    */


    public Join getTipDJoin(){

    }
    /*
    Gets the join between the D tip of this segment and another segment. [1]
    Returns:
    the join
    joinTipC
    */


    public void joinTipC(Join join) {

    }
    /*
    Sets the join between the C tip of this segment and another segment. [3]
    Parameters:
    join - the join
    joinTipD

     */

    public void joinTipD(Join join) {

    }
    /*
    Sets the join between the D tip of this segment and another segment. [3]
    Parameters:
    join - the join
    toString



    public java.lang.String toString() {

    }
    /*
    This is not required.
    Overrides:
    toString in class java.lang.Object
    Returns:
    the string representation

     */
}
