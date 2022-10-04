public class BallsRed extends Decorator {
    HolidayItem item;

    public BallsRed(HolidayItem item) {
        this.item = item;
        description = item.description + " Balls Red,";
    }

    public double cost() {
        return item.cost() + 1.0;
    }

    public String description() {
        return item.description;
    }
}
