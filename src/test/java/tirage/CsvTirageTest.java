package tirage;

import java.io.File;

import org.junit.Before;

import fr.esiea.glpoo.dao.CsvTirageDao;

public class CsvTirageTest extends AbstractTirageDaoTest {

	private final static String RESOURCES_PATH = "src/test/resources/";
	private final static String TIRAGES_FILE_PATH = "my_euromillions_test.csv";
	
	@Before
	public void doBefore() {
		final File file = new File(RESOURCES_PATH + TIRAGES_FILE_PATH);
		dao = new CsvTirageDao();
		dao.init(file);
	}
	
}
