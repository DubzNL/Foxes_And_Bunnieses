package src.Model;
import java.net.*;
import java.applet.*;
/**
* Class for playing audio
* @author Jelmer Postma
*/

public class Sound {
	public Sound() {
		
	}
	public void playSound() {
		try {
			AudioClip ac = Applet.newAudioClip(new URL("http://www.wavsource.com/snds_2015-02-01_1031597268120418/animals/wolf_x.wav"));
			ac.play();
		} catch(Exception e) {
			System.err.println(e);
		}
	}
}