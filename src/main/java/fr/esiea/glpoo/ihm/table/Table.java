package fr.esiea.glpoo.ihm.table;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.apache.log4j.Logger;
import fr.esiea.glpoo.Launcher;

public class Table extends JFrame {
	private static final long serialVersionUID = 1L;
	private final static Logger log = Logger.getLogger(Launcher.class);
	private final TirageModele modele = new TirageModele();
	private final JTable tableau = new JTable(modele);
	
	public Table() throws Exception {
		log.debug("Table des données du CSV");
		setTitle("Tirages");
		setPreferredSize(new Dimension(600, 400));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		final JScrollPane scroll = new JScrollPane(tableau);
		getContentPane().add(scroll, BorderLayout.CENTER);
		tableau.setAutoCreateRowSorter(true);
		
		pack();
	}
}
