package jeuvie.ocean;

import java.util.ArrayList;
import java.util.List;

import jeuvie.ocean.vague.ILigneEau;
import jeuvie.ocean.vague.casemer.ICase;

public abstract class Ocean implements IOcean {

	public static final int CLOWN = 1;
	public static final int CANON = 2;
	public static final int PETIT_VAISSEAU = 3;
	public static final int GRAND_VAISSEAU = 4;
	public static final int PI = 5;
	public static final int ALEA = 6;
	public static final int BARRE = 7;

	protected List<ILigneEau> grille;

	protected abstract void remplirDeLignesEau();

	public Ocean(int forme) {
		super();
		grille = new ArrayList<ILigneEau>(getNbLignes());
		remplirDeLignesEau();
		creerFormeDeVie(forme);
	}

	protected Ocean(List<ILigneEau> grille) {
		super();
		this.grille=grille;
	}

	public ILigneEau get(int i) {
		return grille.get(i);
	}

	private void setBestiole(int i, int j){
		//Equivalent à la ligne du dessous
		/* ILigneEau ligne = get(j);
		ICase unCase = ligne.get(i);
		unCase.setVivante();*/

		(this.get(j)).get(i).setVivante();
	}

	public void etapeSuivante(){
		try {
			IOcean OceanInstantT = (IOcean) this.clone();
			for (int lin = 0; lin < getNbLignes(); lin++) {
				for (int col = 0; col < getNbColonnes(); col++) {
					ICase laCase = (this.get(lin)).get(col);
					// on fait évoluer en fonction du clone OceanInstantT

					laCase.evoluer(OceanInstantT, col, lin);
				}
			}

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();

		}

	}

	public int getNbColonnes() {
		int rep = -1;
		if (grille!=null && !grille.isEmpty()) {
			rep = this.get(0).getNbColonnes();
		}
		return rep;
	}

	public int compterVoisinsVivants(int i, int j) {
		//Initialisation des variables
		int nbVivants = 0;
		int colonneDebut = i - 1;
		int colonneFin = i + 1;
		int ligneDebut = j - 1;
		int ligneFin = j + 1;

		//Gestions des cas où on est sur le bord de l'océan
		if (i==0) {colonneDebut = i;}
		if (i==getNbColonnes()-1) {colonneFin = i;}
		if (j==0) {ligneDebut = j;}
		if (j==getNbLignes()-1) {ligneFin = j;}

		// La boucle qui compte les voisins vivants
		for (int l = ligneDebut; l <= ligneFin; l++) {
			for (int col = colonneDebut; col <= colonneFin; col++) {
				// On évite le cas (i,j) et on incrémente
				
				if ((i!=col) || (j!=l)) {
					ILigneEau laLigne = this.get(l);
					ICase laCase = laLigne.get(col);
					if (laCase.contientBestioleVivante()) {
						nbVivants++;

					}

				}
			}
		}

		return nbVivants;
	}

	protected void creerFormeDeVie(int forme){

		final int BASE_X = 25;
		final int BASE_Y = 25;

		switch (forme) {
		case PETIT_VAISSEAU:
			for (int i = 0; i < getNbLignes()/7; i++) {
				int delta=i*7+3;
				setBestiole(3, delta);
				setBestiole(4, delta+1);
				setBestiole(2, delta+2); setBestiole(3, delta+2); setBestiole(4, delta+2);
			}
			break;
		case GRAND_VAISSEAU:
			for (int i = 0; i < getNbLignes()/9; i++) {
				int delta=i*9+3;
				setBestiole(2, delta);setBestiole(5, delta);
				setBestiole(6, delta+1);
				setBestiole(2, delta+2); setBestiole(6, delta+2);
				setBestiole(3, delta+3);setBestiole(4, delta+3);setBestiole(5, delta+3);setBestiole(6, delta+3);
			}

			break;
		case PI:
			for (int i = 0; i < (getNbLignes()/47); i++) {
				int delta= i*47 + BASE_Y;
				setBestiole(BASE_X, delta+3);
				setBestiole(BASE_X-1, delta+2);setBestiole(BASE_X+1, delta+2);
				setBestiole(BASE_X-1, delta+1);setBestiole(BASE_X+1, delta+1);
				setBestiole(BASE_X-1, delta);setBestiole(BASE_X+1, delta);
			}
			break;
		case CLOWN:

			// ligne haute
			setBestiole(BASE_X, BASE_Y); 			setBestiole(BASE_X+1, BASE_Y); 			setBestiole(BASE_X+2, BASE_Y);

			// deux barres parallèles
			setBestiole(BASE_X, BASE_Y+1);			setBestiole(BASE_X+2, BASE_Y+1);
			setBestiole(BASE_X, BASE_Y+2); 			setBestiole(BASE_X+2, BASE_Y+2);
			break;
		case BARRE:
			// ligne haute			
			setBestiole(BASE_X, BASE_Y); 			setBestiole(BASE_X+1, BASE_Y);	setBestiole(BASE_X-1, BASE_Y);

			break;
		case CANON:
			// le canon à planneur
			// carré gauche
			setBestiole(2, 10);setBestiole(3, 10);
			setBestiole(2, 11);setBestiole(3, 11);

			// carré droit

			// carré droit
			setBestiole(36, 8);setBestiole(37, 8);
			setBestiole(36, 9);setBestiole(37, 9);


			//flèche gauche
			setBestiole(14, 8);setBestiole(15, 8);
			setBestiole(13, 9);setBestiole(17, 9);
			setBestiole(12, 10); setBestiole(18, 10);
			setBestiole(12, 11);setBestiole(16, 11);setBestiole(18, 11);setBestiole(19, 11);
			setBestiole(12, 12);setBestiole(18, 12);
			setBestiole(13, 13); setBestiole(17, 13);
			setBestiole(14, 14);setBestiole(15, 14);

			//flèche droite
			setBestiole(26, 6);
			setBestiole(24, 7);setBestiole(26, 7);
			setBestiole(22, 8);setBestiole(23, 8);
			setBestiole(22, 9);setBestiole(23, 9);
			setBestiole(22, 10);setBestiole(23, 10);
			setBestiole(24, 11);setBestiole(26, 11);
			setBestiole(26, 12);

			break;

		default: creerDeLaVieAleatoirement();
		break;
		}

	} 

	private void creerDeLaVieAleatoirement() {
		for (int j = 0; j < getNbLignes(); j++) {
			ILigneEau ligne = get(j);
			for (int i = 0; i < ligne.getNbColonnes(); i++) {
				double alea = Math.random();
				if (alea<0.2) {
					setBestiole(i, j);
				}
			}
		}
	}


}
