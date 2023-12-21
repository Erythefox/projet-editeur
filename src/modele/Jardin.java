package modele;

import java.util.ArrayList;
import java.util.List;

import donnee.Exportable;
import modele.Plantes.PLANTES;

public class Jardin implements Exportable {

	public enum TERRAIN {ENTREE_JOUR, ENTREE_NUIT, PISCINE_JOUR, PISCINE_NUIT, TOIT_JOUR, TOIT_NUIT};

	protected TERRAIN terrain = TERRAIN.ENTREE_JOUR;

	protected List<Plantes> plantesDuJardin;
	protected List<Zombies> zombiesDuJardin;
	
	public Jardin() {
		this.plantesDuJardin = new ArrayList<Plantes>();
		this.zombiesDuJardin = new ArrayList<Zombies>();
	}
	public TERRAIN getTerrain() {
		return terrain;
	}

	public void setTerrain(TERRAIN terrain) {
		this.terrain = terrain;
	}
	
	public List<Plantes> getPlantesDuJardin() {
		return plantesDuJardin;
	}
	
	public List<Zombies> getZombiesDuJardin() {
		return zombiesDuJardin;
	}

	public void setPlantesDuJardin(List<Plantes> plantesDuJardin) {
		this.plantesDuJardin = plantesDuJardin;
	}
	
	public void setZombiesDuJardin(List<Zombies> zombiesDuJardin) {
		this.zombiesDuJardin = zombiesDuJardin;
	}
	
	public void ajouterPlante(Plantes plante)
	{
		this.plantesDuJardin.add(plante);
	}
	
	public void ajouterZombie(Zombies zombie) {
		this.zombiesDuJardin.add(zombie);
	}

	@Override
	public String exporterXML() {
		
		String xml = "";
		xml += "<terrain>" + this.terrain + "</terrain>";
		xml += "<plantes>";
		for(Plantes plante:this.plantesDuJardin)
		{
			xml+=plante.exporterXML();
		}
		xml += "</plantes>";
		xml += "<zombies>";
		for(Zombies zombie:this.zombiesDuJardin)
		{
			xml+=zombie.exporterXML();
		}
		xml += "</zombies>";
		
		
		return "<jardin>" + xml + "</jardin>";
	}

	@Override
	public String exporterJSON() {
		return "";
	}

}