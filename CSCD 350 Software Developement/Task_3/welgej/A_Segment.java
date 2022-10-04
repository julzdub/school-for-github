package cs350f20task3;

public abstract class A_Segment {

    private String id;
    private Coordinates tipCCoordinates;
    private Coordinates tipDCoordinates;
    private Join tipCjoin;
    private Join tipDjoin;

    public A_Segment(java.lang.String id, Coordinates tipCCoordinates, Coordinates tipDCoordinates) {

        this.id = id;
        this.tipCCoordinates = tipCCoordinates;
        this.tipDCoordinates = tipDCoordinates;
        this.tipCjoin = null;
        this.tipDjoin = null;

    }
   /*
   Creates a segment. [3]
    Parameters:
    id - the segment identifier
    tipCCoordinates - the coordinates of the C tip
    tipDCoordinates - the coordinates of the D tip
    */

    public abstract Coordinates calculatePosition(boolean isFromTipCorD, double distance);
    /*
    Calculates the coordinates on the segment or joined segment(s) as a distance from the starting tip.
    Parameters:
    isFromTipCorD - whether to start from the C or D tip.
            distance - the distance
    Returns:
    the coordinates
    */

    public java.lang.String getID() {
        return this.id;
    }
    /*
    Gets the segment identifier. [1]
    Returns:
    the identifier
    */


    public abstract double getLength();
    /* Gets the length of the segment.
    Returns:
    the length
     */

    public Coordinates getTipCCoordinates() {
        return this.tipCCoordinates;
    }
    /*
    Gets the coordinates of the C tip. [1]
    Returns:
    the coordinates
    getTipCJoin
     */


    public Join getTipCJoin() {
        return this.tipCjoin;
    }
    /*
    Gets the join between the C tip of this segment and another segment. [1]
    Returns:
    the join

     */


    public Coordinates getTipDCoordinates(){
        return this.tipDCoordinates;
    }
    /*
    Gets the coordinates of the D tip. [1]
    Returns:
    the coordinates
    getTipDJoin
    */


    public Join getTipDJoin(){
        return this.tipDjoin;
    }
    /*
    Gets the join between the D tip of this segment and another segment. [1]
    Returns:
    the join
    joinTipC
    */


    public void joinTipC(Join join) {
        if(this.tipCjoin == null) {
            this.tipCjoin = join;
        }
        else {
            throw new RuntimeException("multiple join tips.");
        }
    }

    /*
    Sets the join between the C tip of this segment and another segment. [3]
    Parameters:
    join - the join


     */

    public void joinTipD(Join join) {
        if(this.tipDjoin == null) {
            this.tipDjoin = join;
        }
        else {
            throw new RuntimeException("multiple join tips.");
        }

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
