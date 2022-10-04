package cs350f20task3;

import java.util.Arrays;
import java.util.Collections;

public class TrackManager {

    private java.util.ArrayList<A_Segment> segments;

    public TrackManager() {
    /*
    Creates a manager. [0]

    */
    }



    public void addSegments(A_Segment... newSegments) {

        if(this.segments == null) {this.segments = new java.util.ArrayList<A_Segment>();}
        Collections.addAll(this.segments, newSegments);

    }
    /*
    Adds segments. [2]
    Parameters:
    segments - the segments
     */


    public void compile() {

        if(this.segments == null || this.segments.size() < 2) {throw new RuntimeException("not enough segments in list of segments.");}

        for(int x = 0; x < this.segments.size(); x++) {

            A_Segment theSegment = this.segments.get(x);

            for(int y = x+1; y < this.segments.size(); y++) {

                A_Segment nextSegmentInList = this.segments.get(y);

                //System.out.println("# checking "+ theSegment.getID() +" and "+ nextSegmentInList.getID());

                //if D tip of first near C tip of second
                if(theSegment.getTipDCoordinates().isNear(nextSegmentInList.getTipCCoordinates())) {

                    Join ADtoC = new Join(nextSegmentInList, true);
                    Join BCtoD = new Join(theSegment,        false);

                //    System.out.println("# joining "+ theSegment.getID() +".D and "+ nextSegmentInList.getID() +".C");

                    theSegment.joinTipD(ADtoC);
                    nextSegmentInList.joinTipC(BCtoD);
                }

                //if C tip of first near D tip of second
                else if(theSegment.getTipCCoordinates().isNear(nextSegmentInList.getTipDCoordinates())) {

                    Join ACtoD = new Join(nextSegmentInList, false);
                    Join BDtoC = new Join(theSegment,        true);

                 //   System.out.println("# joining "+ theSegment.getID() +".C and "+ nextSegmentInList.getID() +".D");

                    theSegment.joinTipC(ACtoD);
                    nextSegmentInList.joinTipD(BDtoC);
                }

                //if two D tips near each other
                else if(theSegment.getTipDCoordinates().isNear(nextSegmentInList.getTipDCoordinates())) {

                    Join ADtoD = new Join(nextSegmentInList, false);
                    Join BDtoD = new Join(theSegment,        false);

                 //   System.out.println("# joining "+ theSegment.getID() +".D and "+ nextSegmentInList.getID() +".D");

                    theSegment.joinTipD(ADtoD);
                    nextSegmentInList.joinTipD(BDtoD);
                }

                //if two C tips near each other
                else if(theSegment.getTipCCoordinates().isNear(nextSegmentInList.getTipCCoordinates())) {

                    Join ADtoC = new Join(nextSegmentInList, true);
                    Join BCtoD = new Join(theSegment,        true);

                 //   System.out.println("# joining "+ theSegment.getID() +".C and "+ nextSegmentInList.getID() +".C");

                    theSegment.joinTipC(ADtoC);
                    nextSegmentInList.joinTipC(BCtoD);
                }
            }
        }

        for (A_Segment theSegment : this.segments) {
            if(theSegment.getTipCJoin() == null || theSegment.getTipDJoin() == null) {
                throw new RuntimeException("not all C & D tips joined on segment: " + theSegment.getID());
            }
        }
    }
    /*
    Compiles the segments by joining their tips. This also validates the joins. [31]
    */

    public java.util.List<A_Segment> getSegments() {
        return this.segments;

    }

    /*
    Gets the segments added. [1]
    Returns:
    the segments
     */
}
