package cs350f20task3;

public class SegmentStraight extends A_Segment {

    public SegmentStraight(java.lang.String id, Coordinates tipCCoordinates, Coordinates tipDCoordinates) {

        super(id, tipCCoordinates, tipDCoordinates);

    }

    /*
    Create a straight segment. [1]
    Parameters:
    id - the segment identifier
    tipCCoordinates - the coordinates of the C tip
    tipDCoordinates - the coordinates of the D tip


     */

    public Coordinates calculatePosition(boolean isFromTipCorD, double distance) {

        if(distance > this.getLength()) {
            //subtracting distance and moving to next segment w recursive call
            Join toNextSegment;

            if(isFromTipCorD) {
                toNextSegment = getTipDJoin();
            }
            else {
                toNextSegment = getTipCJoin();
            }
            return toNextSegment.getTargetSegment().calculatePosition(toNextSegment.isTargetSegmentTipCorD(),
                    distance - this.getLength());
        }
        else {
            //distance coordinates are on this segment

            double bearing;

            double xTarget;
            double yTarget;

            if(isFromTipCorD) {
                xTarget = getTipCCoordinates().getX();
                yTarget = getTipCCoordinates().getY();

                bearing = this.getTipCCoordinates().calculateBearing(this.getTipDCoordinates());
            }
            else {
                xTarget = getTipDCoordinates().getX();
                yTarget =  getTipDCoordinates().getY();

                bearing = this.getTipDCoordinates().calculateBearing(this.getTipCCoordinates());
            }

            double xDelta = xTarget + (distance * Math.sin(Math.toRadians(bearing)));
            double yDelta = yTarget + (distance * Math.cos(Math.toRadians(bearing)));

            Coordinates position = new Coordinates(xDelta, yDelta);
            return position;

        }
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


     */
    public double getLength() {
        return super.getTipCCoordinates().calculateDistance(super.getTipDCoordinates());
    }
    /*
    Gets the length of the segment. [2]
    Specified by:
    getLength in class A_Segment
Returns:
    the length

     */
}
