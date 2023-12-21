package controleur.commande;

import java.util.ArrayList;
import java.util.List;

import modele.Jardin;
import modele.Plantes;
import modele.Zombies;
import modele.Zombies.ZOMBIES;
import vue.VuePvZanor;

public class CommandePlacerPlante extends Commande {
	protected Jardin jardin;
	
	protected List<Plantes> nouvelleListePlante = new ArrayList<>();
	protected List<Plantes> ancienneListePlante = new ArrayList<>();
	
	public CommandePlacerPlante(List<Plantes> ancien, List<Plantes> nouveau, Jardin jardin) {
		this.nouvelleListePlante = nouveau;
		this.ancienneListePlante = ancien;
		this.jardin = jardin;
	}

	@Override
	public void executer() {
		VuePvZanor.getInstance().EnleverImageView();
		jardin.setPlantesDuJardin(nouvelleListePlante);
		VuePvZanor.getInstance().RecreerImageView();
	}

	@Override
	public void annuler() {
		VuePvZanor.getInstance().EnleverImageView();
		jardin.setPlantesDuJardin(ancienneListePlante);
		VuePvZanor.getInstance().RecreerImageView();
	}
}
