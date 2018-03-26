package fr.esiea.glpoo.ihm;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import fr.esiea.glpoo.tirage.Tirage;

public class MyDrawPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private int red, blue, green, depth;
	private double angle;

	public void paintComponent(Graphics g) {
		g.setColor(new Color(red, green, blue));
		setBackground(Color.WHITE);
		drawTree(g, getWidth() / 2 , getHeight() / 2,  - angle, depth);
	}

	private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
		if (depth == 0)
			return;
		int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 10.0);
		int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * 10.0);
		g.drawLine(x1, y1, x2, y2);
		drawTree(g, x2, y2, angle - 20, depth - 1);
		drawTree(g, x2, y2, angle + 20, depth - 1);
	}

	public void setColor(Tirage tirage) {
		red = tirage.getBoule1();
		blue = tirage.getBoule2();
		green = tirage.getBoule3();
	}

	public void setAngle(Tirage tirage) {
		angle = tirage.getBoule4() + tirage.getBoule5();
	}

	public void setDepth(Tirage tirage) {
		if (tirage.getEtoile1() > tirage.getEtoile2()) {
			depth = tirage.getEtoile1();
		} else {
			depth = tirage.getEtoile2();
		}
	}

}
