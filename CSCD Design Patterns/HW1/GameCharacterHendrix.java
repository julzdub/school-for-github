public class GameCharacterHendrix extends GameCharacter {
	
	private String name = new String("Jimi Hendrix");
	private Guitar guitar;
	private SoloAct soloAct;

	//constructors

	public GameCharacterHendrix() {
		this.guitar = new GibsonFlyingV(); 
		this.soloAct = new GuitarOnFire();
	}

	public GameCharacterHendrix(Guitar g) {
		this.guitar = g; 
		this.soloAct = new GuitarOnFire();
	}

	public GameCharacterHendrix(SoloAct s) {
		this.guitar = new GibsonFlyingV(); 
		this.soloAct = s;
	}

	public GameCharacterHendrix(Guitar g, SoloAct s) {
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