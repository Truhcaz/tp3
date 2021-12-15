package poste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSacPostal {
	private static double tolerancePrix=0.001f;
	private static double toleranceVolume=0.0000001f;

	Lettre lettre2, lettre1;
	Colis colis1 ;
//	private SacPostal sac1;
	SacPostal sac1 = new SacPostal();
	@BeforeEach
	void setUp() throws Exception {
		Lettre lettre1 = new Lettre("Le pere Noel",
				"famille Kirik, igloo 5, banquise nord",
				"7877", 25, 0.00018f, Recommandation.un, false);
		Lettre lettre2 = new Lettre("Le pere Noel",
				"famille Kouk, igloo 2, banquise nord",
				"5854", 18, 0.00018f, Recommandation.deux, true);
		Colis colis1 = new Colis("Le pere Noel", 
				"famille Kaya, igloo 10, terres ouest",
				"7877", 1024, 0.02f, Recommandation.deux, "train electrique", 200);
		sac1.ajoute(lettre1);
		sac1.ajoute(lettre2);
		sac1.ajoute(colis1);
	}
	
	@Test
	void testValeurRemboursement() {
		assert(sac1.valeurRemboursement()-116.5f<tolerancePrix);
		assertTrue(Math.abs(sac1.valeurRemboursement()-116.5f)<tolerancePrix);
	}
	
	@Test
	void testGetVolume() {
		assert(sac1.getVolume()-0.025359999558422715f<toleranceVolume);
		assertTrue(Math.abs(sac1.getVolume()-0.025359999558422715f)<toleranceVolume);
	}

}
