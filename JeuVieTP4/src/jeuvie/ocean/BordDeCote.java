package jeuvie.ocean;

import java.util.ArrayList;
import java.util.List;

import jeuvie.ocean.vague.ILigneEau;
import jeuvie.ocean.vague.LigneEauProfonde;
import jeuvie.ocean.vague.Vague;

public class BordDeCote extends Ocean {

	private static final int NB_LIGNES = 95;
	private static final int NB_COLONNES = 70;
	
	public BordDeCote(int forme) {
		super(forme);
	}

	public BordDeCote(List<ILigneEau> grille) {
		super(grille);
	}

	public int getNbLignes() {
		return NB_LIGNES;
	}

	@Override
	protected void remplirDeLignesEau() {
		for (int i = 0; i < NB_LIGNES; i++) {
			Vague ligne =new Vague(NB_COLONNES, true);
			super.grille.add(ligne);
		}
	}

	public BordDeCote clone() {
		List<ILigneEau> grilleDupliquee = new ArrayList<ILigneEau>(grille.size());
		for (ILigneEau iLigneEau : grille) {
			grilleDupliquee.add(((Vague) iLigneEau).clone());
		}
		return new BordDeCote(grilleDupliquee);
	}
}
