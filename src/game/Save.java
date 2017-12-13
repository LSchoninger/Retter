package game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.imageio.ImageIO;

import br.senai.sc.engine.Utils;

public class Save {

	public void serializarPlayer(Object o) throws Exception {
		FileOutputStream fos = new FileOutputStream("Ranking.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(o);
		oos.close();
	}

	public Ranking deserializarPlayer(Ranking ranking) throws Exception {
		FileInputStream fis = new FileInputStream("Ranking.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Ranking r = new Ranking();
		r = (Ranking) ois.readObject();
		ranking.setList(r.getList());
		ois.close();
		return ranking;
	}

}
