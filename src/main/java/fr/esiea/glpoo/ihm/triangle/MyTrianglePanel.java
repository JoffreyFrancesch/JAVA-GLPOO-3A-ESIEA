package fr.esiea.glpoo.ihm.triangle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import org.apache.log4j.Logger;

import fr.esiea.glpoo.Launcher;
import fr.esiea.glpoo.tirage.Tirage;

public class MyTrianglePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final static Logger log = Logger.getLogger(Launcher.class);
	private int red, blue, green;
	public int level;
	
	public void paintComponent(Graphics g) {
		g.setColor(new Color(red, green, blue));
		setBackground(Color.WHITE);
		log.debug("level = " + level);
		log.debug("color " + red + " " + blue + " " + green);
		drawSierpinskyTriangle(level, 500, 100, 550, (Graphics2D)g);
	}
	
	
	private static void drawSierpinskyTriangle(int level, int x, int y, int size, Graphics2D g) {
		if(level <= 0) return;
 
		g.drawLine(x, y, x+size, y);
		g.drawLine(x, y, x, y+size);
		g.drawLine(x+size, y, x, y+size);
 
		drawSierpinskyTriangle(level-1, x, y, size/2, g);
		drawSierpinskyTriangle(level-1, x+size/2, y, size/2, g);
		drawSierpinskyTriangle(level-1, x, y+size/2, size/2, g);
	}

	public void setColor(Tirage tirage) {
		red = tirage.getBoule5() * 4;
		blue = tirage.getEtoile1() * 15;
		green = tirage.getEtoile2() * 15;
	}

	public void setLevel(Tirage tirage) {
		if( tirage.getEtoile1() > tirage.getEtoile2()){
			level = tirage.getEtoile1();
		} else {
			level = tirage.getEtoile2();
		}
	}
}
