package game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.imageio.ImageIO;

import br.senai.sc.engine.Utils;

public class Teste {

	/**
	 * 
	 */

	public void serializarPlayer(Nave nave) throws Exception {
		FileOutputStream fos = new FileOutputStream("Nave.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(nave);
		System.out.println(nave.getPosX());
		System.out.println(nave.getPosY());
		System.out.println(nave.sprite);
		oos.close();
	}

	public Nave deserializarPlayer(Nave nave) throws Exception {
		FileInputStream fis = new FileInputStream("Nave.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		nave = (Nave) ois.readObject();
		System.out.println(nave.getPosX());
		System.out.println(nave.getPosY());
		System.out.println(nave.sprite);
		if (nave.getEscolha() == 0) {
			nave.setSprite(Utils.getInstance().loadImage("images/FLAKSHEET1.png"));
		} else if (nave.getEscolha() == 1) {
			nave.setSprite(Utils.getInstance().loadImage("images/FLAKSHEET2.png"));
		} else if (nave.getEscolha() == 2) {
			nave.setSprite(Utils.getInstance().loadImage("images/FLAKSHEET3.png"));
		}
		System.out.println(nave.sprite);
		ois.close();
		return nave;

	}

}
