public class Date {
	private int annee, mois, jour, heure;
	
	private static final int debut_nuit = 20;
	private static final int fin_nuit = 6;
	
	public Date(int annee, int mois, int jour, int heure){
		this.annee = annee;
		this.mois = mois;
		if(this.mois == 2 && jour > 28)
			this.jour = 28;
		else
			this.jour = jour;
		this.heure = heure;
	}
	
	public Date(){
		this(2013,(int)(Math.random()*11)+1,(int)(Math.random()*32),(int)(Math.random()*25));
	}
	
	public boolean estNocturne(){
		return (heure >= debut_nuit || heure < fin_nuit);
	}

	public String toString(){
		return "" + jour + "/" + mois + "/" + annee + " à " + heure + "h";
	}
}
