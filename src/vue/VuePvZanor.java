package vue;
import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurPvZanor;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import modele.Jardin;
import modele.Jardin.TERRAIN;
import modele.Plantes;
import modele.Plantes.PLANTES;
import modele.Zombies.ZOMBIES;
import modele.Zombies;
public class VuePvZanor extends Vue {

	protected ControleurPvZanor controleur;
	protected static VuePvZanor instance = null; 
	public static VuePvZanor getInstance() {if(null==instance)instance = new VuePvZanor();return VuePvZanor.instance;};
	protected HashMap<ZOMBIES, Image> enumVersImage;
	
	private VuePvZanor() 
	{
		super("PvZanor.fxml", VuePvZanor.class, 1294,743);
		super.controleur = this.controleur = new ControleurPvZanor();
		Logger.logMsg(Logger.INFO, "new VuePvZanor()");

		enumVersImage = new HashMap<>();
		
		enumVersImage.put(ZOMBIES.NORMAL, new Image("vue/decoration/zombies/zombie_normal.png"));
		enumVersImage.put(ZOMBIES.CONE, new Image("vue/decoration/zombies/zombie_cone.png"));
		enumVersImage.put(ZOMBIES.SEAU, new Image("vue/decoration/zombies/zombie_seau.png"));
		enumVersImage.put(ZOMBIES.FOOTBALL, new Image("vue/decoration/zombies/zombie_football.png"));
		enumVersImage.put(ZOMBIES.VAGUE, new Image("vue/decoration/zombies/zombie_drapeau.png"));
		enumVersImage.put(ZOMBIES.JOURNAL, new Image("vue/decoration/zombies/zombie_journal.png"));
	}
	
	public void afficherTerrain (TERRAIN terrain) {
		ImageView imageTerrain = (ImageView)lookup("#terrain");
		
		if (terrain == TERRAIN.ENTREE_JOUR)
			imageTerrain.setImage(new Image("ArriereFond-Entree-Jour.png"));
		
		if (terrain == TERRAIN.ENTREE_NUIT)
			imageTerrain.setImage(new Image("ArriereFond-Entree-Nuit.png"));
		if (terrain == TERRAIN.PISCINE_JOUR)
			imageTerrain.setImage(new Image("ArriereFond-Piscine-Jour.png"));
		if (terrain == TERRAIN.PISCINE_NUIT)
			imageTerrain.setImage(new Image("ArriereFond-Piscine-Nuit.png"));
		if (terrain == TERRAIN.TOIT_JOUR)
			imageTerrain.setImage(new Image("ArriereFond-Toit-Jour.png"));
		if (terrain == TERRAIN.TOIT_NUIT)
			imageTerrain.setImage(new Image("ArriereFond-Toit-Nuit.png"));
	}

	private Boolean zombieBool;	
	public void activerControles()
	{
		super.activerControles();
		
		Button actionUndo = (Button)lookup("#action-undo");
		actionUndo.setOnAction(new EventHandler<>() {

			@Override
			public void handle(ActionEvent e) {
				controleur.avertirClicUndo();				
			}});
		
		Button actionRedo = (Button)lookup("#action-redo");
		actionRedo.setOnAction(new EventHandler<>() {

			@Override
			public void handle(ActionEvent e) {
				controleur.avertirClicRedo();
			}});
		
		Button entreeJour = (Button)lookup("#entree-jour");
		entreeJour.setOnAction(new EventHandler<>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("entree jour");
				
				controleur.notifierClicTerrain(TERRAIN.ENTREE_JOUR);
			}});
		
		Button entreeNuit = (Button)lookup("#entree-nuit");
		entreeNuit.setOnAction(new EventHandler<>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("entree nuit");
				controleur.notifierClicTerrain(TERRAIN.ENTREE_NUIT);
				
			}});
		
		Button piscineJour = (Button)lookup("#piscine-jour");
		piscineJour.setOnAction(new EventHandler<>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("piscine jour");
				controleur.notifierClicTerrain(TERRAIN.PISCINE_JOUR);
				
			}});
		Button piscineNuit = (Button)lookup("#piscine-nuit");
		piscineNuit.setOnAction(new EventHandler<>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("piscine nuit");
				
				controleur.notifierClicTerrain(TERRAIN.PISCINE_NUIT);
			}});
		Button toitJour = (Button)lookup("#toit-jour");
		toitJour.setOnAction(new EventHandler<>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("toit jour");
				controleur.notifierClicTerrain(TERRAIN.TOIT_JOUR);
				
				
			}});
		
		Button toitNuit = (Button)lookup("#toit-nuit");
		toitNuit.setOnAction(new EventHandler<>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("toit nuit");
				controleur.notifierClicTerrain(TERRAIN.TOIT_NUIT);
			}});
		
		Button emplacement1 = (Button)lookup("#emplacement-1");
		emplacement1.setOnAction(new EventHandler<>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("emplacement1");
				zombieBool = false;
				controleur.notifierChoixPlantes(Plantes.PLANTES.SUNFLOWER);
			}});
		Button emplacement2 = (Button)lookup("#emplacement-2");
		emplacement2.setOnAction(new EventHandler<>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("emplacement2");
				zombieBool = false;
				controleur.notifierChoixPlantes(Plantes.PLANTES.PEASHOOTER);
			}});
		Button emplacement3 = (Button)lookup("#emplacement-3");
		emplacement3.setOnAction(new EventHandler<>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("emplacement3");
				zombieBool = false;
				controleur.notifierChoixPlantes(Plantes.PLANTES.CHOUSHOOTER);
			}});
		Button emplacement4 = (Button)lookup("#emplacement-4");
		emplacement4.setOnAction(new EventHandler<>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("emplacement4");
				zombieBool = false;
				controleur.notifierChoixPlantes(Plantes.PLANTES.CORNSHOOTER);
			}});
		Button emplacement5 = (Button)lookup("#emplacement-5");
		emplacement5.setOnAction(new EventHandler<>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("emplacement5");
				zombieBool = false;
				controleur.notifierChoixPlantes(Plantes.PLANTES.FASTSHOOTER);
			}});
		
		Button emplacement6 = (Button)lookup("#emplacement-6");
		emplacement6.setOnAction(new EventHandler<>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("emplacement6");
				zombieBool = false;
				controleur.notifierChoixPlantes(Plantes.PLANTES.FIRETRUNK);
			}});
		
		Button emplacement7 = (Button)lookup("#emplacement-7");
		emplacement7.setOnAction(new EventHandler<>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("emplacement7");
				zombieBool = false;
				controleur.notifierChoixPlantes(Plantes.PLANTES.NENUPHAR);
				
			}});
		
		Button emplacement8 = (Button)lookup("#emplacement-8");
		emplacement8.setOnAction(new EventHandler<>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("emplacement8");
				zombieBool = false;
				controleur.notifierChoixPlantes(Plantes.PLANTES.PLANTPOT);
			}});
		
		Button emplacement9 = (Button)lookup("#emplacement-9");
		emplacement9.setOnAction(new EventHandler<>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("emplacement9");
				zombieBool = false;
				controleur.notifierChoixPlantes(Plantes.PLANTES.TALLNUT);
			}});
		
		Button zombie1 = (Button)lookup("#zombie1");
		zombie1.setOnAction(new EventHandler<>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Clic sur zombie1");
				zombieBool = true;
				controleur.notifierChoixZombies(Zombies.ZOMBIES.NORMAL);
			}});
		
		Button zombie2 = (Button)lookup("#zombie2");
		zombie2.setOnAction(new EventHandler<>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Clic sur zombie2");
				zombieBool = true;
				controleur.notifierChoixZombies(Zombies.ZOMBIES.CONE);
				
			}});
		
		Button zombie3 = (Button)lookup("#zombie3");
		zombie3.setOnAction(new EventHandler<>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Clic sur zombie3");
				zombieBool = true;
				controleur.notifierChoixZombies(Zombies.ZOMBIES.SEAU);
			}});
		
		Button zombie4 = (Button)lookup("#zombie4");
		zombie4.setOnAction(new EventHandler<>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Clic sur zombie4");
				zombieBool = true;
				controleur.notifierChoixZombies(Zombies.ZOMBIES.FOOTBALL);
			}});
		
		Button zombie5 = (Button)lookup("#zombie5");
		zombie5.setOnAction(new EventHandler<>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Clic sur zombie5");
				zombieBool = true;
				controleur.notifierChoixZombies(Zombies.ZOMBIES.VAGUE);
			}});
		
		Button zombie6 = (Button)lookup("#zombie6");
		zombie6.setOnAction(new EventHandler<>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Clic sur zombie6");
				zombieBool = true;
				controleur.notifierChoixZombies(Zombies.ZOMBIES.JOURNAL);
			}});
		
		
		Rectangle jardinRectangle = (Rectangle)lookup("#jardin-rectangle");
		jardinRectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent clic) {
				double x = clic.getX();
				double y = clic.getY();
			System.out.println("Clic jardin");	
			controleur.notifierClicJardin(x,y,zombieBool);
			
			}});
		
			Button actionSauvegarder = (Button)lookup("#export-button");
			actionSauvegarder.setOnAction(new EventHandler<>() {

				@Override
				public void handle(ActionEvent arg0) {
					System.out.println("Action de sauvegarder");	
					controleur.notifierSauvegarder();
					
				}});
		
	}
	public void planterPlantes(double x, double y, PLANTES planteChoisi) {
		//Ajouter les plantes dans le java
		
		ImageView plantePlantee = new ImageView();
		if(planteChoisi == PLANTES.SUNFLOWER) {
		plantePlantee.setImage(new Image("vue/decoration/plantes/sunflower.jpg"));
		}
		if(planteChoisi == PLANTES.PEASHOOTER) {
		plantePlantee.setImage(new Image("vue/decoration/plantes/peashooter.jpg"));
		}
		if(planteChoisi == PLANTES.CHOUSHOOTER) {
		plantePlantee.setImage(new Image("vue/decoration/plantes/choushooter.jpg"));
		}
		if(planteChoisi == PLANTES.CORNSHOOTER) {
		plantePlantee.setImage(new Image("vue/decoration/plantes/cornshooter.jpg"));
		}
		if(planteChoisi == PLANTES.FASTSHOOTER) {
		plantePlantee.setImage(new Image("vue/decoration/plantes/fastshooter.jpg"));
		}
		if(planteChoisi == PLANTES.FIRETRUNK) {
		plantePlantee.setImage(new Image("vue/decoration/plantes/firetrunk.jpg"));
		}
		if(planteChoisi == PLANTES.NENUPHAR) {
		plantePlantee.setImage(new Image("vue/decoration/plantes/nenuphar.jpg"));
		}
		if(planteChoisi == PLANTES.PLANTPOT) {
		plantePlantee.setImage(new Image("vue/decoration/plantes/plantpot.jpg"));
		}
		if(planteChoisi == PLANTES.TALLNUT) {
		plantePlantee.setImage(new Image("vue/decoration/plantes/tallnut.jpg"));
		}
		
		plantePlantee.setPreserveRatio(true);
		plantePlantee.setFitHeight(100);
		plantePlantee.setY(y - 50);
		plantePlantee.setX(x -40);
		
		AnchorPane jardin = (AnchorPane)lookup("#jardin");
		jardin.getChildren().add(plantePlantee);
		
	}
	
	public void placerZombies(double x, double y, ZOMBIES zombiesChoisi) {
		
		ImageView zombiePlacer = new ImageView();
		/*
		if(zombiesChoisi == ZOMBIES.NORMAL) {
		zombiePlacer.setImage(new Image("vue/decoration/zombies/zombie_normal.png"));
		}
		if(zombiesChoisi == ZOMBIES.CONE) {
			zombiePlacer.setImage(new Image("vue/decoration/zombies/zombie_cone.png"));
		}
		if(zombiesChoisi == ZOMBIES.SEAU) {
			zombiePlacer.setImage(new Image("vue/decoration/zombies/zombie_seau.png"));
		}
		if(zombiesChoisi == ZOMBIES.FOOTBALL) {
			zombiePlacer.setImage(new Image("vue/decoration/zombies/zombie_football.png"));
		}
		if(zombiesChoisi == ZOMBIES.VAGUE) {
			zombiePlacer.setImage(new Image("vue/decoration/zombies/zombie_drapeau.png"));
		}
		if(zombiesChoisi == ZOMBIES.JOURNAL) {
			zombiePlacer.setImage(new Image("vue/decoration/zombies/zombie_journal.png"));
		}*/
		
		switch (zombiesChoisi) {
		case NORMAL:
			zombiePlacer.setImage(this.enumVersImage.get(ZOMBIES.NORMAL));
			break;
			
		case CONE:
			zombiePlacer.setImage(this.enumVersImage.get(ZOMBIES.CONE));
			break;
			
		case SEAU:
			zombiePlacer.setImage(this.enumVersImage.get(ZOMBIES.SEAU));
			break;
			
		case FOOTBALL:
			zombiePlacer.setImage(this.enumVersImage.get(ZOMBIES.FOOTBALL));
			break;
			
		case VAGUE:
			zombiePlacer.setImage(this.enumVersImage.get(ZOMBIES.VAGUE));
			break;
			
		case JOURNAL:
			zombiePlacer.setImage(this.enumVersImage.get(ZOMBIES.JOURNAL));
			break;
		}
		
		zombiePlacer.setPreserveRatio(true);
		zombiePlacer.setFitHeight(100);
		zombiePlacer.setY(y - 50);
		zombiePlacer.setX(x -40);
		
		AnchorPane jardin = (AnchorPane)lookup("#jardin");
		jardin.getChildren().add(zombiePlacer);
	}
	
	public void EnleverImageView() {
		AnchorPane jardin = (AnchorPane)lookup("#jardin");
		jardin.getChildren().clear();
	}
	
	public void RecreerImageView() {
		AnchorPane jardinGraphique = (AnchorPane)lookup("#jardin");
		Jardin jardin = controleur.getJardin();
		
		List<Plantes> listePlante = jardin.getPlantesDuJardin();
		
		for (Plantes plante : listePlante) {
			planterPlantes(plante.getX(), plante.getY(), plante.getPlantes());
		}
		
		List<Zombies> listeZombie = jardin.getZombiesDuJardin();
		
		for (Zombies zombie : listeZombie) {
			placerZombies(zombie.getX(), zombie.getY(), zombie.getZombies());
		}
	}
}
