/**
 * Contient la liste des mesures d'un relev� m�t�o
 * 
 * @author GAILLARD Nicolas
 * @version 1.0
 */
public class Mesure {
	private double temperature, pression, direction_vent, force_vent;
	
	private static final int seuil_tempete = 90; /** D�finition du seuil de temp�te */
	
	
	public Mesure(double temperature, double pression, double direction_vent, double force_vent){
		this.temperature = temperature;
		this.pression = pression;
		this.direction_vent = direction_vent;
		this.force_vent = force_vent;
	}
	
	/** G�n�re une mesure al�atoire */
	public Mesure(){
		this(Math.random()*50-10,Math.random()*210+870, Math.random()*360, Math.random()*220);
		normaliser();
	}
	
	/** D�finit si la mesure est faite pendant une temp�te
	 * @return true si c'est une temp�te, false sinon
	 */
	public boolean estUneTempete(){
		return (force_vent > seuil_tempete);
	}
	
	public String toString(){
		String message = "Mesure : ";
		message = message + "\n\tTemp�rature : " + temperature + " �C";
		message = message + "\n\tPression : " + pression + " hPa";
		message = message + "\n\tDirection du vent : " + direction_vent + " �";
		message = message + "\n\tForce du vent : " + force_vent + " km/h";
		return message; 
	}
	
	private void normaliser(){
		temperature = (int)(temperature*100)/100.;
		pression = (int)(pression*100)/100.;
		direction_vent = (int)(direction_vent*100)/100.;
		force_vent = (int)(force_vent*100)/100.;
	}
}
