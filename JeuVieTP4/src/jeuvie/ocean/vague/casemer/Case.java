package jeuvie.ocean.vague.casemer;

import jeuvie.Couleur;
import jeuvie.bestiole.IBestiole;

public abstract class Case implements ICase {

	protected boolean vide=true;
	protected IBestiole occupant = null;
	
	protected abstract void setBestioleVivante();
	protected abstract Couleur getCouleurCaseVide();
	
	public void setVivante() {
		this.vide=false;
		setBestioleVivante();

	}

	public Couleur getCouleur() {
		Couleur couleur;
		if (this.isVide()) {
			couleur = this.getCouleurCaseVide();
		}
		else {
			couleur = occupant.getCouleur();
		}
		return couleur;
	}

	public boolean isVide() {
		return vide;
	}

	public IBestiole getOccupant() {
		return occupant;
	}
	public void tuerEventuelOccupant() {
		if (!isVide()) {
			occupant.tuer();
		}
	}
	
	public boolean contientBestioleVivante() {
		return (!isVide() && getOccupant().isVivante());
	}
	
}
