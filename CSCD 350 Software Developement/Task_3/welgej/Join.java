package cs350f20task3;

public class Join {

    private A_Segment targetSegment;
    private boolean isTargetSegmentTipCorD;
    //if true, joined to a C tip... false = joined to a D tip

    public Join(A_Segment targetSegment, boolean isTargetSegmentTipCorD) {
        this.targetSegment = targetSegment;
        this. isTargetSegmentTipCorD = isTargetSegmentTipCorD;
    }
    /*
    Creates a join. [2]
    Parameters:
    targetSegment - the segment to join to
    isTargetSegmentTipCorD - whether to join to the C or D tip of the segment


     */
    public A_Segment getTargetSegment() {
        return this.targetSegment;
    }
    /*
    Gets the segment joined to. [1]
    Returns:
    the segment

     */

    public boolean isTargetSegmentTipCorD() {
        return this.isTargetSegmentTipCorD;
    }
    /*
    Gets whether the join is to the C or D tip of the segment joined to. [1]
    Returns:
    the result



    public java.lang.String toString() {

    }

    This is not required.
    Overrides:
    toString in class java.lang.Object
    Returns:
    the string representation

     */
}
