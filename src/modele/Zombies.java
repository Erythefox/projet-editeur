package modele;

import donnee.Exportable;

public class Zombies implements Exportable {
	public enum ZOMBIES {NORMAL, CONE, SEAU, FOOTBALL, VAGUE, JOURNAL}
	protected ZOMBIES Zombies;
	protected double x;
	protected double y;
		public Zombies() {
			
		}
		
		public Zombies(ZOMBIES zombies) {
			
		}
		
		public Zombies(ZOMBIES zombies, double x, double y) {
			this.Zombies = zombies;
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String exporterXML() {
			String xml = "";
			xml += "<sorte>" + this.Zombies + "</sorte>";
			xml += "<coordonnees>" + this.x + "," + this.y + "</coordonnees>";
			return "<zombie>" + xml + "</zombie>";
		}
		@Override
		public String exporterJSON() {
			return "NON-IMPLEMENTE";
		}
}
