public class GameCharacterYoung extends GameCharacter {
	
	private String name = new String("Angus Young");
	private Guitar guitar;
	private SoloAct soloAct;

	//constructors

	public void GameCharacterYoung() {
		this.guitar = new GibsonFlyingV(); 
		this.soloAct = new GuitarOnFire();
	}

	public void GameCharacterYoung(Guitar g) {
		this.guitar = g; 
		this.soloAct = new GuitarOnFire();
	}

	public void GameCharacterYoung(SoloAct s) {
		this.guitar = new GibsonFlyingV(); 
		this.soloAct = s;
	}

	public void GameCharacterYoung(Guitar g, SoloAct s) {
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