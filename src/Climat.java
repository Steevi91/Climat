/**
 * Ensemble de Relev� M�t�o
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
	 * Ajoute le relev� donn� en param�tre au climat
	 * @param releve Le relev� � ajouter au climat
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
	 * Retire le relev� m�t�o correspondant � l'index du climat
	 * @param index Index du Relev� M�t�o � enlever
	 */
	public void retirer(int index){
		if(index > 0 && index < pointeur)
			releves[index] = releves[--pointeur];
	}
	
	/**
	 * Retire tout les relev�s nocturnes
	 * @return le nombre de relev�s retir�s du climat
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
	 * Fournit tout les relev�s m�t�os ayant eu lieu pendant des temp�tes
	 * @return Un climat correspondant aux temp�tes
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
	 * Fournit le relev� m�t�o correspondant � l'index
	 * @param index index du relev� m�t�o
	 * @return le relev� si il existe, null sinon
	 */
	public ReleveMeteo getReleve(int index){
		if(index >= 0 && index < pointeur)
			return releves[index];
		return null;
	}
}
