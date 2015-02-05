package src.Main;
import src.Model.Simulator;
import src.Model.Sound;


public class Main {
	private static Sound sound;
	
	public static void main(String[]args){
	Simulator simulator = new Simulator();
	sound = new Sound();
	sound.playSound();


}
}
