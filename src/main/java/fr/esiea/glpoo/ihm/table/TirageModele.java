package fr.esiea.glpoo.ihm.table;

import java.io.File;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.esiea.glpoo.dao.CsvTirageDao;
import fr.esiea.glpoo.dao.TirageDao;
import fr.esiea.glpoo.tirage.Tirage;

public class TirageModele extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private final String[] headers;
	private List<Tirage> tirages;

	public TirageModele() throws Exception {
		headers = new String[] { "Annee et Numero du Tirage", "Jour", "Date", "Numero du tirage dans le cycle",
				"Date de fermeture", "Boule 1", "Boule 2", "Boule 3", "Boule 4", "Boule 5", "Etoile 1", "Etoile 2" };

		final String fileName = "src/main/resources/my_euromillions.csv";
		final File file = new File(fileName);
		final TirageDao dao = new CsvTirageDao();
		dao.init(file);
		tirages = dao.findAllTirage();
	}

	@Override
	public int getRowCount() {
		return tirages.size();
	}

	@Override
	public int getColumnCount() {
		return headers.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		final Tirage tirage = tirages.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return tirage.getAnnee();
		case 1:
			return tirage.getJour();
		case 2:
			return tirage.getDate()[0] +"/" + tirage.getDate()[1] +"/" + tirage.getDate()[2] ;
		case 3:
			return tirage.getNumeroTirage();
		case 4:
			return tirage.getDateFermeture()[0] + "/" + tirage.getDateFermeture()[1] + "/" + tirage.getDateFermeture()[2];
		case 5:
			return tirage.getBoule1();
		case 6:
			return tirage.getBoule2();
		case 7:
			return tirage.getBoule3();
		case 8:
			return tirage.getBoule4();
		case 9:
			return tirage.getBoule5();
		case 10:
			return tirage.getEtoile1();
		case 11:
			return tirage.getEtoile2();
		default:
			throw new IllegalArgumentException("La colonne n'est pas connu");
		}
	}

	@Override
	public String getColumnName(int column) {
		return headers[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return Integer.class;
		case 1:
			return String.class;
		case 2:
			return String[].class;
		case 3:
			return Integer.class;
		case 4:
			return String[].class;
		case 5:
			return Integer.class;
		case 6:
			return Integer.class;
		case 7:
			return Integer.class;
		case 8:
			return Integer.class;
		case 9:
			return Integer.class;
		case 10:
			return Integer.class;
		case 11:
			return Integer.class;
		default:
			return Object.class;
		}
	}

}
