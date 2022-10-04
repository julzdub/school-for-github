public class GuitarHero {
    public static void main(String[] args) {
        GameCharacter player1 = new GameCharacterSlash(); //note that constructor could be designed to accept initial behaviors

        // e.g. GameCharacter player1 = new GameCharacterSlash(new GibsonFlyingV(), new GuitarOnFire());
        GameCharacter player2 = new GameCharacterHendrix();
        player1.playGuitar();  //should print a message saying Slash is playing a Gibson Flying V
        player2.playGuitar(); //should print a message saying Jimi Hendrix is playing whatever you assigned in constructor
        player1.playSoloAct(); //should print a message saying Slash just set guitar on fire
        player2.playSoloAct(); //etc.

        //add code below to show the swapping of behaviors
        player2.setGuitar(new FenderTelecaster());
        player2.playGuitar();
        player2.setSoloAct(new SmashGuitar());

        player1.setSoloAct(new JumpOffStage()); 
        player1.playSoloAct();
        player1.playSoloAct(new GuitarOnFire()); //-- this should print a message that Slash jumped off stage
    }
}