public class BallsBlue extends Decorator {
    HolidayItem item;

    public BallsBlue(HolidayItem item) {
        this.item = item;
        description = item.description + " Balls Blue,";
    }

    public double cost() {
        return item.cost() + 2.0;
    }

    public String description() {
        return item.description;
    }
}
