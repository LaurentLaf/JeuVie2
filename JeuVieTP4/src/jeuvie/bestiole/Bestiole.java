package jeuvie.bestiole;

import jeuvie.Couleur;

public abstract class Bestiole implements IBestiole {

	protected Couleur couleur;
	protected final int NUMERO;
	protected boolean vivante=true;
	protected static int compteur = 0;
	
	protected abstract Couleur getCouleurVivant();
	protected abstract Couleur getCouleurMorte();
	
	public Bestiole() {
		super();
		this.NUMERO = compteur++;
		this.couleur = getCouleurVivant();
	}
	
	public Bestiole(Couleur couleur, int nUMERO, boolean vivante) {
		super();
		this.couleur = couleur;
		NUMERO = nUMERO;
		this.vivante = vivante;
	}
	
	public int getNumero() {
		return this.NUMERO;
	}
	public boolean isVivante() {
		return this.vivante;
	}
	public Couleur getCouleur() {
		return this.couleur;
	}
	public void tuer() {
		this.couleur=getCouleurMorte();
		this.vivante=false;
	}
	 
}
