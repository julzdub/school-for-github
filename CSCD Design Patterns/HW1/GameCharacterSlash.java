public class GameCharacterSlash extends GameCharacter {
	
	private String name = new String("Slash");
	private Guitar guitar;
	private SoloAct soloAct;

	//constructors

	public GameCharacterSlash() {
		this.guitar = new GibsonFlyingV(); 
		this.soloAct = new GuitarOnFire();
	}

	public GameCharacterSlash(Guitar g) {
		this.guitar = g; 
		this.soloAct = new GuitarOnFire();
	}

	public GameCharacterSlash(SoloAct s) {
		this.guitar = new GibsonFlyingV(); 
		this.soloAct = s;
	}

	public GameCharacterSlash(Guitar g, SoloAct s) {
		this.guitar = g;
		this.soloAct = s;
	}

	//end constructors

	//setters

	public void setGuitar(Guitar g) {
		this.guitar = g;
	}

	public void setSoloAct(SoloAct s) {
		this.soloAct = s;
	}

	//end setters

	//behaviors

	public void playGuitar() {
		
		System.out.print(name + " is playing ");
		this.guitar.playGuitar();

	}

	public void playGuitar(Guitar g) {
		
		this.guitar = g;
		System.out.print(name + " is playing ");
		this.guitar.playGuitar();
	}

	public void playSoloAct() {
		
		System.out.print(name + " is ");
		this.soloAct.playSoloAct();

	}

	public void playSoloAct(SoloAct s) {
		
		this.soloAct = s;
		System.out.print(name + " is ");
		this.soloAct.playSoloAct();
	}

	//end behaviors
}