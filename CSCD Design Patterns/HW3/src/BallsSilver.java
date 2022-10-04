public class BallsSilver extends Decorator {
    HolidayItem item;

    public BallsSilver(HolidayItem item) {
        this.item = item;
        description = item.description + " Balls Silver,";
    }

    public double cost() {
        return item.cost() + 3.0;
    }

    public String description() {
        return item.description;
    }
}
