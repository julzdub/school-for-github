public class LEDs extends Decorator {
    HolidayItem item;

    public LEDs(HolidayItem item) {
        this.item = item;
        description = item.description + " LEDs,";
    }

    public double cost() {
        return item.cost() + 10.0;
    }

    public String description() {
        return item.description;
    }
}
