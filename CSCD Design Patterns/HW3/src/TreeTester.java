public class TreeTester {
    public static void main(String [] args) {
        HolidayItem mytree = new BlueSpruce(); //HolidayItem is super type for Decorator scenario
        mytree = new Star(mytree);
        mytree = new Ruffles(mytree);
        mytree = new BallsSilver(mytree);
        mytree = new Star(mytree); //this is problematic and should not be permitted
        mytree = new Ruffles(mytree);
        System.out.print(mytree.description());

        System.out.println(" costs $" + mytree.cost());
    }
}
