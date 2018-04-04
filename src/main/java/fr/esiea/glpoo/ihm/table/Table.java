package fr.esiea.glpoo.ihm.table;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.apache.log4j.Logger;
import fr.esiea.glpoo.Launcher;
import fr.esiea.glpoo.ihm.MainMenu;

public class Table extends JFrame {
	private static final long serialVersionUID = 1L;
	private final static Logger log = Logger.getLogger(Launcher.class);
	private final TirageModele modele = new TirageModele();
	private final JTable tableau = new JTable(modele);
	JButton btn_menu;

	public Table() throws Exception {
		log.debug("Table des données du CSV");
		setTitle("Tirages");
		setPreferredSize(new Dimension(600, 400));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		btn_menu = new JButton(new GoToMenu());

		final JPanel barreButton = new JPanel();
		barreButton.add(btn_menu);

		final JScrollPane scroll = new JScrollPane(tableau);
		getContentPane().add(scroll, BorderLayout.CENTER);
		getContentPane().add(barreButton, BorderLayout.SOUTH);
		tableau.setAutoCreateRowSorter(true);

		pack();
	}

	private class GoToMenu extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public GoToMenu() {
			super("Menu principal");
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			log.debug("ici actionPerformed aller au menu");
			try {
				@SuppressWarnings("unused")
				final MainMenu menu = new MainMenu();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dispose();
		}

	}
}
