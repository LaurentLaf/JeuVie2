package jeuvie.ocean.vague.casemer;

import jeuvie.Couleur;
import jeuvie.bestiole.Bigorneau;
import jeuvie.ocean.IOcean;

public class CasePeuProfonde extends Case {

	private static final Couleur CASE_VIDE = Couleur.BLEU_SOMBRE;
	
	public CasePeuProfonde() {
	}
	
	public CasePeuProfonde(Bigorneau occupant, boolean vide) {
		super();
		super.vide=vide;
		super.occupant=occupant;
	}

	@Override
	protected void setBestioleVivante() {
		super.occupant = new Bigorneau();
	}

	@Override
	protected Couleur getCouleurCaseVide() {
		return CASE_VIDE;
	}

	public CasePeuProfonde clone() {
		CasePeuProfonde nouvelleCase;
		if (super.isVide()) {
			nouvelleCase = new CasePeuProfonde();
		}
		else {
			Bigorneau nouveauBigorneau = ((Bigorneau) occupant).clone();
			nouvelleCase = new CasePeuProfonde(nouveauBigorneau, false);
		}
		return nouvelleCase;
	}
	
	public void evoluer(IOcean copie, int i, int j) {
		int nbVivantsAutour = copie.compterVoisinsVivants(i, j);
		if (this.contientBestioleVivante()) {
			if (nbVivantsAutour < 2 && nbVivantsAutour > 4) {
				this.tuerEventuelOccupant();
			}
		}
		else {
			if ((nbVivantsAutour == 3) || nbVivantsAutour == 8) {
				this.setVivante();
			}
		}
	}
}
