package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;
import javax.swing.border.StrokeBorder;

import br.senai.sc.engine.Utils;

public class Ranking extends TelaEstatica implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1669084188926432824L;

	private LinkedList<Player> list = new LinkedList<>();

	private Player player;
	private Player[] npc = new Player[11];
	private String name = "";
	private int contador;
	private int controle;

	public Ranking() {

	}

	public Ranking(Save save) {
		super("images/fundoRanking2.png", false);
		contador = 0;
		controle = 150;
		npc[10] = new Player("Leandro", 500);
		npc[9] = new Player("Jorge", 600);
		npc[8] = new Player("Amanda", 700);
		npc[7] = new Player("Felipe", 800);
		npc[6] = new Player("Luís", 900);
		npc[5] = new Player("Leonardo", 1000);
		npc[4] = new Player("Eduardo", 1100);
		npc[3] = new Player("Milena", 1200);
		npc[2] = new Player("Flávio", 1300);
		npc[1] = new Player("Retter", 200000);
		npc[0] = new Player("RetterInverso", 300000);
		for (int i = 0; i < 11; i++) {
			list.add(npc[i]);
		}
		setBotoes(new Botao[2]);
		getBotoes()[0] = new Botao(50,
				(Utils.getInstance().getHeight() / 2 - 86) + (Utils.getInstance().getHeight() / 3), 216, 72,
				"images/RESTART.png");
		getBotoes()[1] = new Botao(Utils.getInstance().getWidth() - 200,
				(Utils.getInstance().getHeight() / 2 - 86) + (Utils.getInstance().getHeight() / 3), 180, 170,
				"images/SETADIEREITA.png");
	}

	public void RankingOrganize(Save save, long points) throws Exception {
		if (contador == 0) {
			player = new Player(JOptionPane.showInputDialog(name), points);
			contador++;
		}
		for (int i = 0; i < 11; i++) {
			if (contador == 1 && list.get(i).getPontuacao() < player.getPontuacao()) {
				list.add(i, player);
				contador++;
				save.serializarPlayer(this);
				break;
			}
		}
	}

	public void drawRanking(Graphics2D g) {
		Iterator<Player> iter = list.iterator();
		String[] rank = new String[10];
		for (int i = 0; i < 10; i++) {
			if (rank[i] == null) {
				rank[i] = (String) iter.next().toString();
			}
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", 1, 24));
			g.drawString(rank[i], 370, controle + 60 * i);
		}
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public int getControle() {
		return controle;
	}

	public LinkedList<Player> getList() {
		return list;
	}

	public void setList(LinkedList<Player> list) {
		this.list = list;
	}

	public void setControle(int controle) {
		this.controle = controle;
	}

}
