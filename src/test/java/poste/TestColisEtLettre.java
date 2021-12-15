package poste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestColisEtLettre{
	private static float tolerancePrix=0.001f;
	Lettre lettre1;
	Lettre lettre2;
	Colis colis1;
	
	@BeforeEach
	void setUp() throws Exception {
		lettre1 = new Lettre("Le pere Noel",
				"famille Kirik, igloo 5, banquise nord",
				"7877", 25, 0.00018f, Recommandation.un, false);
		lettre2 = new Lettre("Le pere Noel",
				"famille Kouk, igloo 2, banquise nord",
				"5854", 18, 0.00018f, Recommandation.deux, true);
		colis1 = new Colis("Le pere Noel", 
				"famille Kaya, igloo 10, terres ouest",
				"7877", 1024, 0.02f, Recommandation.deux, "train electrique", 200);
	}

	@Test
	void testToStringLettreEtColis() {
		assertEquals("Lettre 7877/famille Kirik, igloo 5, banquise nord/1/ordinaire",lettre1.toString());
		assertEquals("Lettre 5854/famille Kouk, igloo 2, banquise nord/2/urgence", lettre2.toString());
		assertEquals("Colis 7877/famille Kaya, igloo 10, terres ouest/2/0.02/200.0",colis1.toString());
	}


	@Test
	void testAffranchissement() {
		assertTrue(lettre1.tarifAffranchissement()-1.0f<tolerancePrix);
		assertTrue(lettre2.tarifAffranchissement()-2.3f<tolerancePrix);
		assertTrue(colis1.tarifAffranchissement()-3.5f<tolerancePrix);
	}
	
	@Test
	void testTarifRemboursement() {
		assertTrue(lettre1.tarifRemboursement()-1.5f<tolerancePrix);
		assertTrue(lettre2.tarifRemboursement()-15.0f<tolerancePrix);
		assertTrue(colis1.tarifRemboursement()-100.0f<tolerancePrix);
		
	}
}
