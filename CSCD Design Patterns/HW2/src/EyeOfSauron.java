import java.util.Observable;

public class EyeOfSauron extends Observable {

    private int hobbits;
    private int elves;
    private int dwarves;
    private int men;

    public void setEnemies(int h, int e, int d, int m) {
        this.hobbits = h;
        this.elves = e;
        this.dwarves = d;
        this.men = m;

        setChanged();
        notifyObservers("New message from the eye: ");
    }

    public int getHobbits() {
        return this.hobbits;
    }

    public int getDwarves() {
        return this.dwarves;
    }

    public int getElves() {
        return this.elves;
    }

    public int getMen() {
        return this.men;
    }
}
