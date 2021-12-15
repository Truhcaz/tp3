package poste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestColisExpress {
	ColisExpress colisEx1;
	
	@BeforeEach
	void setUp() throws Exception {
		colisEx1 = new ColisExpress("Montpellier","Paris","95000",
				3,0.02f, Recommandation.deux, "iphone", 200,true);
	}
	@Test
	void testToStringColisExpress() {
		assertEquals("Colis express 95000/Paris/2/0.02/200.0/3.0/0", colisEx1.toString());
	}
	
	@Test
	void testTarifAffranchissement() {
		assertTrue(colisEx1.tarifAffranchissement()==33f);
	}
	  
	@Test
	public void invalide() {
		try {
			ColisExpress colisExpress1 = new ColisExpress("Le pere Noel", "famille Kaya, igloo 10, terres ouest", "7877", 10, 0.02f, Recommandation.deux, "train electrique", 200, true);
			assertTrue(colisExpress1.getPoids() > 30);
			colisExpress1.affiche();
		} catch(Exception e) {
			assertTrue(e.getMessage().equals("poids incohérent, votre colis ne pourra pas être acheminé."));
		}
	}
}
