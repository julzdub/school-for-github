public class Ribbons extends Decorator {
    HolidayItem item;

    public Ribbons(HolidayItem item) {
        this.item = item;
        description = item.description + " Ribbons,";
    }

    public double cost() {
        return item.cost() + 2.0;
    }

    public String description() {
        return item.description;
    }
}
