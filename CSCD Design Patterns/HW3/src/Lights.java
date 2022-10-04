public class Lights extends Decorator {
    HolidayItem item;

    public Lights(HolidayItem item) {
        this.item = item;
        description = item.description + " Lights,";
    }

    public double cost() {
        return item.cost() + 5.0;
    }

    public String description() {
        return item.description;
    }
}
