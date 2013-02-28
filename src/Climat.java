/**
 * Ensemble de Relevé Météo
 * @author GAILLARD Nicolas
 * @version 1.0
 */
public class Climat {
	private ReleveMeteo[] releves;
	private int pointeur = 0;
	
	public Climat(int taille){
		releves = new ReleveMeteo[taille];
		for(int i =0; i < releves.length; i++)
			releves[i] = null;
	}
	
	/**
	 * Ajoute le relevé donné en paramètre au climat
	 * @param releve Le relevé à ajouter au climat
	 */
	public void ajouter(ReleveMeteo releve){
		if(pointeur == releves.length){
			ReleveMeteo[] temp = new ReleveMeteo[releves.length * 2];
			for(int i = 0; i < releves.length; i++)
				temp[i] = releves[i];
			releves = temp;
		}
		releves[pointeur++] = releve;
	}
	
	/**
	 * Retire le relevé météo correspondant à l'index du climat
	 * @param index Index du Relevé Météo à enlever
	 */
	public void retirer(int index){
		if(index > 0 && index < pointeur)
			releves[index] = releves[--pointeur];
	}
	
	/**
	 * Retire tout les relevés nocturnes
	 * @return le nombre de relevés retirés du climat
	 */
	public int retirerNocturne(){
		int result = 0;
		for(int i = 0; i < pointeur; i++)
			if(releves[i].getDate().estNocturne()){
				retirer(i);
				result++;
			}
		return result;
	}
	
	/**
	 * Fournit tout les relevés météos ayant eu lieu pendant des tempêtes
	 * @return Un climat correspondant aux tempêtes
	 */
	public Climat relevesTempete(){
		Climat tempetes = new Climat(10);
		for(int i = 0; i < pointeur; i++)
			if(releves[i].getMesure().estUneTempete())
				tempetes.ajouter(releves[i]);
		return tempetes;
	}
	
	public ReleveMeteo[] getReleves(){
		ReleveMeteo[] liste = new ReleveMeteo[pointeur];
		for(int i = 0; i < pointeur; i++){
			liste[i] = releves[i];
		}
		return liste;
	}
	
	/**
	 * Fournit le relevé météo correspondant à l'index
	 * @param index index du relevé météo
	 * @return le relevé si il existe, null sinon
	 */
	public ReleveMeteo getReleve(int index){
		if(index >= 0 && index < pointeur)
			return releves[index];
		return null;
	}
}
