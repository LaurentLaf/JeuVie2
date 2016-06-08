package jeuvie.ocean.vague.casemer;

import jeuvie.Couleur;
import jeuvie.bestiole.Dauphin;
import jeuvie.ocean.IOcean;

public class ColonneEau extends Case {

	private static final Couleur CASE_VIDE = Couleur.BLEU_SOMBRE;
	
	// Constructeur qui génère seulement une case vide
	public ColonneEau() {
	}

	public ColonneEau(Dauphin occupant, boolean vide) {
		super();
		super.vide=vide;
		super.occupant=occupant;
	}
	
	@Override
	protected void setBestioleVivante() {
		super.occupant = new Dauphin();
	}

	@Override
	protected Couleur getCouleurCaseVide() {
		return CASE_VIDE;
	}

	@Override
	public String toString() {
		return "ColonneEau [occupant=" + occupant + "]\n";
	}
	
	public ColonneEau clone () {
		ColonneEau nouvelleCase;
		if (super.isVide()) {
			nouvelleCase = new ColonneEau();			
		}
		else {
			Dauphin nouveauDauphin = ((Dauphin) occupant).clone();
			nouvelleCase = new ColonneEau(nouveauDauphin, false);
		}
		return nouvelleCase;
	}
	
	public void evoluer(IOcean copie, int i, int j) {
		int nbVivantsAutour = copie.compterVoisinsVivants(i, j);
		if (this.contientBestioleVivante()) {
			if (nbVivantsAutour !=2 && nbVivantsAutour !=3) {
				this.tuerEventuelOccupant();
			}
		}
		else {
			if (nbVivantsAutour == 3) {
				this.setVivante();
			}
		}
	}
	 
}
