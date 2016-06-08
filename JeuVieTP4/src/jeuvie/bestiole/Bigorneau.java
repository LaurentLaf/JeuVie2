package jeuvie.bestiole;

import jeuvie.Couleur;

public class Bigorneau extends Bestiole {

	private static final Couleur MORT = Couleur.GRIS_CLAIR;
	private static final Couleur VIVANT = Couleur.NOIR;
	
	public Bigorneau() {}

	public Bigorneau(Couleur couleur, int nUMERO, boolean vivante) {
		super(couleur, nUMERO, vivante);
	}

	@Override
	protected Couleur getCouleurVivant() {
		return VIVANT;
	}

	@Override
	protected Couleur getCouleurMorte() {
		return MORT;
	}
	
	@Override
	public String toString() {
		return "Bigorneau [couleur=" + couleur + ", NUMERO=" + NUMERO + ", vivante=" + vivante;
	}
	
	public Bigorneau clone() {
		return new Bigorneau(super.getCouleur(), super.getNumero(), super.isVivante());
	}

}
