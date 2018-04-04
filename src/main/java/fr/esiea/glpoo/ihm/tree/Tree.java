package fr.esiea.glpoo.ihm.tree;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.apache.log4j.Logger;

import fr.esiea.glpoo.Launcher;
import fr.esiea.glpoo.dao.CsvTirageDao;
import fr.esiea.glpoo.dao.TirageDao;
import fr.esiea.glpoo.ihm.MainMenu;
import fr.esiea.glpoo.tirage.SimpleTirage;
import fr.esiea.glpoo.tirage.Tirage;

public class Tree extends JFrame {
	private static final long serialVersionUID = 1L;
	JFrame frame;
	JButton btn_ramdom, btn_save, btn_menu;
	JTextArea textArea;
	private final static Logger log = Logger.getLogger(Launcher.class);

	MyTreePanel DrawPanel;

	private List<Tirage> tirages;
	private Tirage tirageEnCours = new SimpleTirage();
	private Random rand = new Random();
	private boolean first = true;

	public Tree() throws Exception {
		final String fileName = "src/main/resources/my_euromillions.csv";
		final File file = new File(fileName);
		final TirageDao dao = new CsvTirageDao();
		dao.init(file);
		tirages = dao.findAllTirage();

		if (first == true) {
			tirageEnCours = tirages.get(0);
		}

		frame = new JFrame("Fractal Tree");
		textArea = new JTextArea(24, 80);

		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btn_ramdom = new JButton(new RandomTree());
		btn_save = new JButton(new SaveAsPng());
		btn_menu = new JButton(new GoToMenu());

		final JPanel barreButton = new JPanel();
		barreButton.add(btn_ramdom);
		barreButton.add(btn_save);
		barreButton.add(btn_menu);

		DrawPanel = new MyTreePanel();

		frame.getContentPane().add(BorderLayout.SOUTH, barreButton);
		frame.getContentPane().add(BorderLayout.CENTER, DrawPanel);
		DrawPanel.setBackground(Color.WHITE);
		DrawPanel.setColor(tirageEnCours);
		DrawPanel.setDepth(tirageEnCours);

		frame.setVisible(true);

	}

	private class RandomTree extends AbstractAction {

		private static final long serialVersionUID = 1L;

		public RandomTree() {
			super("New Random Tree");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			log.info("ici actionPerformed");
			int value = rand.nextInt(70);
			log.debug("random effctuer " + value);
			tirageEnCours = tirages.get(value);
			log.debug("test some value " + tirageEnCours.getBoule1());
			first = false;
			DrawPanel.removeAll();
			DrawPanel.validate();
			DrawPanel.setColor(tirageEnCours);
			DrawPanel.setDepth(tirageEnCours);
			DrawPanel.revalidate();
			DrawPanel.repaint();
		}

	}

	private class SaveAsPng extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public SaveAsPng() {
			super("Save as PNG");
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			log.info("ici action Performed Save as PNG");
			File file = new File("images/tree.png");
			file.getParentFile().mkdirs();
			BufferedImage image = new BufferedImage(DrawPanel.getSize().width, DrawPanel.getSize().height,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D g2 = image.createGraphics();
			DrawPanel.paint(g2);
			g2.dispose();

			try {
				ImageIO.write(image, "PNG", file);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

	}

	private class GoToMenu extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public GoToMenu() {
			super("Menu principal");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			log.debug("ici actionPerformed aller au menu principal");
			try {
				@SuppressWarnings("unused")
				final MainMenu menu = new MainMenu();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			frame.dispose();
		}

	}
}
