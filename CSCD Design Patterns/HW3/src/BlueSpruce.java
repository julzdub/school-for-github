public class BlueSpruce extends HolidayItem {
    public BlueSpruce() {
        super.description = "Blue Spruce";
    }

    public double cost() {
        return 50.0;
    }

    public String description() {
        return description;
    }
}
