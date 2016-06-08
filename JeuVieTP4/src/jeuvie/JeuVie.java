package jeuvie;

import controleur.Controleur;
import jeuvie.ocean.BordDeCote;
import jeuvie.ocean.HauteMer;
import jeuvie.ocean.Ocean;


public class JeuVie {

	public static void main(String[] args) {

		new Controleur(new BordDeCote(Ocean.PI));
		//new Controleur(new HauteMer(Ocean.ALEA));
		//new Controleur(new HauteMer(Ocean.BARRE));
		//new Controleur(new HauteMer(Ocean.CANON));
		
		//new Controleur(new HauteMer(Ocean.CLOWN), Controleur.ITER_CLOWN);
		
		//new Controleur(new HauteMer(Ocean.PI), Controleur.ITER_PI);
		//new Controleur(new HauteMer(Ocean.GRAND_VAISSEAU));
		//new Controleur(new HauteMer(Ocean.PETIT_VAISSEAU));
		
		//bouclerBestiole();
		
	}

	/*private static void bouclerBestiole() {
		int taille = 10;
		List<IBestiole> listeBestioles = new ArrayList<IBestiole>(taille);
		
		for (int i = 0; i < 10; i++) {
			IBestiole bestiole = new Dauphin();
			if (i % 2 == 0) {
				bestiole.tuer();
			}
			listeBestioles.add(bestiole);
		}
		
		int taille2 = taille * 2;
		List<ICase> lesCases = new ArrayList<ICase>(taille2);
		for (int i = 0; i < taille2; i++) {
			ICase uneCase;
			if (i % 2 == 0) {
				uneCase = new ColonneEau();
				lesCases.add(uneCase);
			}
			else {
				uneCase = new ColonneEau((Dauphin)listeBestioles.get(i/2),false);
				lesCases.add(uneCase);
			}
		} 
		System.out.println(lesCases);
	}*/
}
