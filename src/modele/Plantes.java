package modele;

import donnee.Exportable;

public class Plantes implements Exportable {
	public enum PLANTES {SUNFLOWER, PEASHOOTER, CHOUSHOOTER, CORNSHOOTER, FASTSHOOTER, FIRETRUNK, NENUPHAR, PLANTPOT, TALLNUT}
	protected PLANTES Plantes;
	protected double x;
	protected double y;
		public Plantes() {
			
		}
		
		public Plantes(PLANTES Plantes) {
			
		}
		
		public Plantes(PLANTES Plantes, double x, double y) {
			this.Plantes = Plantes;
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String exporterXML() {
			String xml = "";
			xml += "<sorte>" + this.Plantes + "</sorte>";
			xml += "<coordonnees>" + this.x + "," + this.y + "</coordonnees>";
			return "<plante>" + xml + "</plante>";
		}
		@Override
		public String exporterJSON() {
			return "NON-IMPLEMENTE";
		}

		public PLANTES getPlantes() {
			return Plantes;
		}

		public void setPlantes(PLANTES plantes) {
			Plantes = plantes;
		}

		public double getX() {
			return x;
		}

		public void setX(double x) {
			this.x = x;
		}

		public double getY() {
			return y;
		}

		public void setY(double y) {
			this.y = y;
		}
		
}
