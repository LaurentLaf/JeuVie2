package jeuvie.ocean;

import jeuvie.ocean.vague.ILigneEau;

/**
 * Extension  possible : param�trer les classes, tout r�percuter !!
 * @author MINEFI
 *
 * @param <I>
 */
public interface IOcean extends Cloneable{

	public void etapeSuivante();

	public ILigneEau get(int i);

	public int getNbColonnes();
	public int getNbLignes();
	
	public int compterVoisinsVivants(int i, int j);
	 
}
