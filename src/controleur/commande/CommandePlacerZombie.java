package controleur.commande;

import java.util.ArrayList;
import java.util.List;

import modele.Jardin;
import modele.Zombies;
import modele.Zombies.ZOMBIES;
import vue.VuePvZanor;

public class CommandePlacerZombie extends Commande {
	protected Jardin jardin;
	
	protected List<Zombies> nouvelleListeZombie = new ArrayList<>();
	protected List<Zombies> ancienneListeZombie = new ArrayList<>();
	
	public CommandePlacerZombie(List<Zombies> ancien, List<Zombies> nouveau, Jardin jardin) {
		this.nouvelleListeZombie = nouveau;
		this.ancienneListeZombie = ancien;
		this.jardin = jardin;
	}

	@Override
	public void executer() {
		VuePvZanor.getInstance().EnleverImageView();
		jardin.setZombiesDuJardin(nouvelleListeZombie);
		VuePvZanor.getInstance().RecreerImageView();
	}

	@Override
	public void annuler() {
		VuePvZanor.getInstance().EnleverImageView();
		jardin.setZombiesDuJardin(ancienneListeZombie);
		VuePvZanor.getInstance().RecreerImageView();
	}
}
