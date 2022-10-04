import java.util.Observable;
import java.util.Observer;

public class BadGuy implements Observer {
    private String name;
    private int hobbits;
    private int elves;
    private int dwarves;
    private int men;
    private Observable theEye;

    public BadGuy(Observable o, String s) {
        this.theEye = o;
        this.name = s;
        o.addObserver(this);
    }
    @Override
    public void update(Observable o, Object arg) {
        if( o instanceof EyeOfSauron) {
            this.hobbits = ((EyeOfSauron) o).getHobbits();
            this.elves = ((EyeOfSauron) o).getElves();
            this.dwarves = ((EyeOfSauron) o).getDwarves();
            this.men = ((EyeOfSauron) o).getMen();
        }
        
        System.out.println(this.name + " says " + (String)arg + " there are now " + this.hobbits + " hobbits, " +
                            this.dwarves + " dwarves, " + this.elves + " elves, " + this.men + " men.");
    }

    public void defeated() {
        this.theEye.deleteObserver(this);
        System.out.println(this.name + " has been defeated.");
    }
}
