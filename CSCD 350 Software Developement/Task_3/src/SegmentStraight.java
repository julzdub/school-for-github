package cs350f20task3;


public class SegmentStraight {

    private String id;
    private Coordinates tipCCoordinates;
    private Coordinates tipDCoordinates;

    public SegmentStraight(java.lang.String id, Coordinates tipCCoordinates,
                           Coordinates tipDCoordinates) {
        this.id = id;
        this.tipCCoordinates = tipCCoordinates;
        this.tipDCoordinates = tipDCoordinates;

    }

    /*
    Create a straight segment. [1]
    Parameters:
    id - the segment identifier
    tipCCoordinates - the coordinates of the C tip
    tipDCoordinates - the coordinates of the D tip
    Method Detail
    calculatePosition

     */

    public Coordinates calculatePosition(boolean isFromTipCorD,
                                         double distance) {


    }
    /*
    Calculates the coordinates on the segment or joined segment(s) as a distance from the starting tip. [19]
    Specified by:
    calculatePosition in class A_Segment
Parameters:
    isFromTipCorD - whether to start from the C or D tip.
            distance - the distance
    Returns:
    the coordinates
    getLength

     */
    public double getLength() {

    }
    /*
    Gets the length of the segment. [2]
    Specified by:
    getLength in class A_Segment
Returns:
    the length

     */
}
