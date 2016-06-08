package jeuvie.ocean.vague;

import java.util.ArrayList;
import java.util.List;

import jeuvie.ocean.vague.casemer.ICase;

public abstract class LigneEau implements ILigneEau {

	protected final int NB_COLONNE;
	protected List<ICase> lesCases = new ArrayList<ICase>();
	
	protected abstract void remplirLesCasesVides();
	protected abstract ILigneEau clone();
	
	public LigneEau(int taille, boolean prevoirLesCasesVides) {
		super();
		this.NB_COLONNE=taille;
		if (prevoirLesCasesVides) {
			remplirLesCasesVides();
		}
	}

	public boolean add(ICase uneCase) {
		return lesCases.add(uneCase);
	}
	
	public ICase get(int i) {
		return lesCases.get(i);
	}

	public int getNbColonnes() {
		return this.NB_COLONNE;
	}
 
}
