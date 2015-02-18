package src.Model;
import java.net.*;
import java.applet.*;
/**
* Class for playing audio
* @author Jelmer Postma
*/

public class Sound{
	public Sound() {
		
	}
	public void playSound() {
		try {
			
			AudioClip ac = Applet.newAudioClip(new URL("http://thebirdguide.com/fox/IV_fox_sp_2.wav"));
			ac.play();
		} catch(Exception e) {
			System.err.println(e);
			
		}
	}
}