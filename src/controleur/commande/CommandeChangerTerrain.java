package controleur.commande;

import modele.Jardin;
import modele.Jardin.TERRAIN;
import vue.VuePvZanor;

public class CommandeChangerTerrain extends Commande {
	
	TERRAIN terrain;
	Jardin jardin;
	
	protected TERRAIN nouveauTerrain;
	protected TERRAIN ancienTerrain;

	public CommandeChangerTerrain(TERRAIN nouveauTerrain, TERRAIN ancienTerrain) {
		this.nouveauTerrain = nouveauTerrain;
		this.ancienTerrain = ancienTerrain;
	}
	
	@Override
	public void executer() {
		VuePvZanor.getInstance().afficherTerrain(nouveauTerrain);
		
	}

	@Override
	public void annuler() {
		VuePvZanor.getInstance().afficherTerrain(ancienTerrain);
		
	}

}
