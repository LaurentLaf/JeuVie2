package jeuvie.bestiole;

import jeuvie.Couleur;

public class Dauphin extends Bestiole {

	private static final Couleur MORT = Couleur.BLEU_MARINE;
	private static final Couleur VIVANT = Couleur.BLEU_GRIS;
	
	public Dauphin() {}

	public Dauphin(Couleur couleur, int nUMERO, boolean vivante) {
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
		return "Dauphin [couleur=" + couleur + ", NUMERO=" + NUMERO + ", vivante=" + vivante;
	}
	
	public Dauphin clone() {
		return new Dauphin(super.getCouleur(), super.getNumero(), super.isVivante());
	}
	 
}