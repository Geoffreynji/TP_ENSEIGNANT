package champollion;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");		
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}
	@Test
	public void testEnSousService() {
	
		untel.ajouteEnseignement(uml, 12, 20, 20);
		untel.ajouteEnseignement(java, 8, 20, 30);
		assertEquals(true, untel.enSousService(),
                        "L'enseignant est en sous service");
	}
	
	@Test
	public void testResteAPlanifier()
	{
		UE uml = new UE("test", 10,20,30);
		assertEquals(172, untel.resteAPlanifier(uml, TypeIntervention.TD),
		"Il y a plus d'heures à planifier)");
		assertEquals(182, untel.resteAPlanifier(uml, TypeIntervention.CM),
				"Il y a plus d'heures à planifier)");
		assertEquals(162, untel.resteAPlanifier(uml, TypeIntervention.TP),
				"Il y a plus d'heures à planifier)");
	}
	
}
