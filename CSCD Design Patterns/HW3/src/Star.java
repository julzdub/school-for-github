public class Star extends Decorator{

    HolidayItem item;
    boolean starAdded;

    public Star(HolidayItem item) {
        this.item = item;
        if(this.item.hasStar) {
            System.out.println(" This item already has a star. ");
        }
        else {
            item.hasStar = true;
            this.starAdded = true;
        }
    }

    public double cost() {
        if(starAdded) {
            return item.cost() + 4.0;
        }
        else {
            return item.cost();
        }
    }

    public String description() {
        return item.description;
    }
}
