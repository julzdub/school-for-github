public class Ruffles extends Decorator {
    HolidayItem item;

    public Ruffles(HolidayItem item) {
        this.item = item;
        description = item.description() + " Ruffles,";
    }

    public double cost() {
        return item.cost() + 1.0;
    }

    public String description() {
        return item.description;
    }
}
