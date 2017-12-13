package game;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlaySound {
	private Clip clip;

	public PlaySound(String soundName) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao carregar o audio: " + soundName);
		}
	}

	public void start() {
		// AudioInputStream audioInputStream =
		// AudioSystem.getAudioInputStream(new
		// File(soundName).getAbsoluteFile());
		// Clip clip = AudioSystem.getClip();
		// clip.open(audioInputStream);
		try {
			if (!clip.isRunning()) {
				clip.stop();
				clip.start();
				if (clip.getMicrosecondLength() <= clip.getMicrosecondPosition()) {
					clip.setMicrosecondPosition(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void stop() {
		try {
			if (clip.isRunning()) {
				clip.stop();
				clip.setMicrosecondPosition(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
