package jeuvie.ocean;

import java.util.ArrayList;
import java.util.List;

import jeuvie.ocean.vague.ILigneEau;
import jeuvie.ocean.vague.LigneEauProfonde;

public class HauteMer extends Ocean {

	private static final int NB_LIGNES = 55;
	private static final int NB_COLONNES = 60;
	
	public HauteMer(int forme) {
		super(forme);
	}

	public HauteMer(List<ILigneEau> grille) {
		super(grille);
	}

	public int getNbLignes() {
		return NB_LIGNES;
	}

	@Override
	protected void remplirDeLignesEau() {
		for (int i = 0; i < NB_LIGNES; i++) {
			LigneEauProfonde ligne =new LigneEauProfonde(NB_COLONNES, true);
			super.grille.add(ligne);
		}
	}

	public HauteMer clone() {
		List<ILigneEau> grilleDupliquee = new ArrayList<ILigneEau>(grille.size());
		for (ILigneEau iLigneEau : grille) {
			grilleDupliquee.add(((LigneEauProfonde) iLigneEau).clone());
		}
		return new HauteMer(grilleDupliquee);
	}
	
	
}
