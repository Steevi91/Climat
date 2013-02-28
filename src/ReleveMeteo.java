public class ReleveMeteo {
	
	private Date date;
	private Mesure mesure;
	private String observation;
	
	public ReleveMeteo(Date date, Mesure mesure, String observation){
		this.date = date;
		this.mesure = mesure;
		this.observation = observation;
	}
	
	public ReleveMeteo(String observation){
		this(new Date(), new Mesure(), observation);
	}
	
	public Date getDate(){
		return this.date;
	}
	
	public Mesure getMesure(){
		return this.mesure;
	}
	
	public String getObservation(){
		return this.observation;
	}

	public String toString(){
		String message = observation;
		message = message + "\n----------";
		message = message + "\nDate : " + date;
		message = message + "\n" + mesure;
		message = message + "\n\n\tEst nocturne : " + date.estNocturne();
		message = message + "\n\tEst une tempête : " + mesure.estUneTempete();
		return message;
	}
}
