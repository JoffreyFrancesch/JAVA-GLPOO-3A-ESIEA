package tirage;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.esiea.glpoo.dao.TirageDao;
import fr.esiea.glpoo.tirage.Tirage;

public abstract class AbstractTirageDaoTest {

	protected TirageDao dao;
	
	@Test
	public void testAnnee() throws Exception {
		final int expectedAnnee = 2016078;
		final List<Tirage> tirages = dao.findAllTirage();
		final int annee = tirages.get(0).getAnnee();
		Assert.assertEquals(expectedAnnee, annee);
	}
	
	@Test
	public void testDay() throws Exception {
		final String expectedDay = "MARDI";
		final List<Tirage> tirages = dao.findAllTirage();
		final String day = tirages.get(0).getJour();
		Assert.assertEquals(expectedDay,day);
	}
	
	@Test
	public void testDate() throws Exception {
		throw new IllegalArgumentException("not implemented");
	}
	
	@Test
	public void testEndDate() throws Exception {
		throw new IllegalArgumentException("not implemented");
	}
	
	@Test
	public void testNumTirage() throws Exception {
		final int expected = 1;
		final List<Tirage> tirages = dao.findAllTirage();
		final int numero = tirages.get(0).getNumeroTirage();
		Assert.assertEquals(expected,numero);
	}
	
	@Test
	public void testBoule1() throws Exception {
		final int expected = 41;
		final List<Tirage> tirages = dao.findAllTirage();
		final int boule = tirages.get(0).getBoule1();
		Assert.assertEquals(expected,boule);
	}
	
	@Test
	public void testBoule2() throws Exception {
		final int expected = 6;
		final List<Tirage> tirages = dao.findAllTirage();
		final int boule = tirages.get(0).getBoule2();
		Assert.assertEquals(expected,boule);
	}
	
	@Test
	public void testBoule3() throws Exception {
		final int expected = 13;
		final List<Tirage> tirages = dao.findAllTirage();
		final int boule = tirages.get(0).getBoule3();
		Assert.assertEquals(expected,boule);
	}
	
	@Test
	public void testBoule4() throws Exception {
		final int expected = 39;
		final List<Tirage> tirages = dao.findAllTirage();
		final int boule = tirages.get(0).getBoule4();
		Assert.assertEquals(expected,boule);
	}
	
	@Test
	public void testBoule5() throws Exception {
		final int expected = 9;
		final List<Tirage> tirages = dao.findAllTirage();
		final int boule = tirages.get(0).getBoule5();
		Assert.assertEquals(expected,boule);
	}
	
	@Test
	public void testEtoile1() throws Exception {
		final int expected = 2;
		final List<Tirage> tirages = dao.findAllTirage();
		final int etoile = tirages.get(0).getEtoile1();
		Assert.assertEquals(expected,etoile);
	}
	
	@Test
	public void testEtoile2() throws Exception {
		final int expected = 12;
		final List<Tirage> tirages = dao.findAllTirage();
		final int etoile = tirages.get(0).getEtoile2();
		Assert.assertEquals(expected,etoile);
	}
	
	@Test
	public void testTableBoule() throws Exception {
		throw new IllegalArgumentException("not implemented");
	}
	
	@Test
	public void testTableEtoile() throws Exception {
		throw new IllegalArgumentException("not implemented");
	}
	
	@Test
	public void testBoule1InTable() throws Exception {
		final String expectedResult = "6";
		final List<Tirage> tirages = dao.findAllTirage();
		final String[] tableBoule1 = tirages.get(0).getBoules();
		final String boule1 = tableBoule1[0];
		
		Assert.assertEquals(expectedResult, boule1);
	}
	
	
}
