package game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Teste implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5809984957929945037L;

	public void serializarPlayer(Nave nave) throws Exception {
		FileOutputStream fos = new FileOutputStream("Nave.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(nave);
		oos.close();
	}

	public void deserializarPlayer(Nave nave) throws Exception {
		FileInputStream fis = new FileInputStream("Nave.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		nave = (Nave) ois.readObject();
		ois.close();
	}

}
